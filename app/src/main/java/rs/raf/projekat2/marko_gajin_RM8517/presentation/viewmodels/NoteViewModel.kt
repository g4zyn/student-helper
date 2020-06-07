package rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.NoteRepository
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.NoteContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.AddNoteState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.DeleteNoteState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.NotesState
import timber.log.Timber
import java.util.concurrent.TimeUnit

class NoteViewModel(
    private val noteRepository: NoteRepository
) : ViewModel(), NoteContract.ViewModel {

    private val subscriptions = CompositeDisposable()
    override val notesState: MutableLiveData<NotesState> = MutableLiveData()
    override val addDone: MutableLiveData<AddNoteState> = MutableLiveData()
    override val deleteDone: MutableLiveData<DeleteNoteState> = MutableLiveData()

    private val publishSubject: PublishSubject<String> = PublishSubject.create()

    init {
        val subscription = publishSubject
            .debounce(200, TimeUnit.MILLISECONDS)
            .switchMap {
                noteRepository
                    .getBySearch(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError {
                        Timber.e("Error in publish subject")
                        Timber.e(it)
                    }
            }
            .subscribe(
                {
                    notesState.value = NotesState.Success(it)
                },
                {
                    notesState.value = NotesState.Error("Error happened while fetching data from database")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getNotes(archived: Boolean) {
        if (archived) {
            val subscription = noteRepository
                .getArchived()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        notesState.value = NotesState.Success(it)
                    },
                    {
                        notesState.value = NotesState.Error("Error happened while fetching data from database")
                        Timber.e(it)
                    }
                )
            subscriptions.add(subscription)
        } else {
            val subscription = noteRepository
                .getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        notesState.value = NotesState.Success(it)
                    },
                    {
                        notesState.value = NotesState.Error("Error happened while fetching data from database")
                        Timber.e(it)
                    }
                )
            subscriptions.add(subscription)
        }

    }

    override fun searchNotes(search: String) {
        publishSubject.onNext(search)
    }

    override fun archiveNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun addNote(note: Note) {
        val subscription = noteRepository
            .insert(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    addDone.value = AddNoteState.Success
                },
                {
                    addDone.value = AddNoteState.Error("Error happened while adding new note")
                    Timber.e(it)
                }
            )
            subscriptions.add(subscription)
    }

    override fun editNote(note: Note) {
        val subscription = noteRepository
            .edit(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("UPDATED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun deleteNote(note: Note) {
        val subscription = noteRepository
            .delete(note.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    deleteDone.value = DeleteNoteState.Success
                },
                {
                    deleteDone.value = DeleteNoteState.Error("Error happened while deleting note")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getNoteData(intent: Intent): Note? {
        return noteRepository.getNoteData(intent)
    }

    override fun setNoteData(note: Note, intent: Intent) {
        noteRepository.setNoteData(note, intent)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}