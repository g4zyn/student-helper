package rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels

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
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.NotesState
import timber.log.Timber

class NoteViewModel(
    private val noteRepository: NoteRepository
) : ViewModel(), NoteContract.ViewModel {

    private val subscriptions = CompositeDisposable()
    override val notesState: MutableLiveData<NotesState> = MutableLiveData()
    override val addDone: MutableLiveData<AddNoteState> = MutableLiveData()

    private val publishSubject: PublishSubject<String> = PublishSubject.create()

    init {}

    override fun getNotes() {

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

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}