package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local.NoteDao
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.data.models.NoteEntity

class NoteRepositoryImpl(private val localDataSource: NoteDao) : NoteRepository {

    override fun getAll(): Observable<List<Note>> {
        return localDataSource
            .getAll()
            .map {
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.body
                    )
                }
            }
    }

    override fun getByTitle(title: String): Observable<List<Note>> {
        return localDataSource
            .getByTitle(title)
            .map {
                it.map {
                    Note(
                        it.id,
                        it.title,
                        it.body
                    )
                }
            }
    }

    override fun insert(note: Note): Completable {
        val noteEntity = NoteEntity(note.id, note.title, note.body)

        return localDataSource.insert(noteEntity)
    }

    override fun delete(id: Long): Completable {
        return localDataSource.delete(id)
    }
}