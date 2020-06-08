package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import android.content.Intent
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local.NoteDao
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared.NoteDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared.NoteIntentDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.data.models.NoteEntity

class NoteRepositoryImpl(
    private val localDataSource: NoteDao,
    private val sharedDataSource: NoteDataSource
) : NoteRepository {

    private val noteMap = {
        entities: List<NoteEntity> -> entities.map { Note(it.id, it.title, it.body, it.archived) }
    }

    override fun getAll(): Observable<List<Note>> {
        return localDataSource
            .getAll()
            .map{
                noteMap(it)
            }
    }

    override fun getArchived(): Observable<List<Note>> {
        return localDataSource
            .getArchived()
            .map{
                noteMap(it)
            }
    }

    override fun getBySearch(search: String): Observable<List<Note>> {
        return localDataSource
            .getBySearch(search)
            .map {
                noteMap(it)
            }
    }

    override fun insert(note: Note): Completable {
        val noteEntity = NoteEntity(note.id, note.title, note.body, false)

        return localDataSource.insert(noteEntity)
    }

    override fun delete(id: Long): Completable {
        return localDataSource.delete(id)
    }

    override fun edit(note: Note): Completable {
        return Completable.fromCallable {
            val oldNote = localDataSource.getById(note.id)
            val newNote = oldNote.copy(
                title = note.title,
                body = note.body
            )
            localDataSource.update(newNote)
        }
    }

    override fun archive(note: Note): Completable {
        return Completable.fromCallable {
            val oldNote = localDataSource.getById(note.id)
            val newNote = oldNote.copy(
                archived = !oldNote.archived
            )
            localDataSource.update(newNote)
        }
    }

    override fun getNoteData(intent: Intent): Note? {
        return sharedDataSource.getNoteData(intent)
    }

    override fun setNoteData(note: Note, intent: Intent) {
        sharedDataSource.setNoteData(note, intent)
    }
}