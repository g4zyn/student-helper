package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local.NoteDao
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

class NoteRepositoryImpl(private val localStorage: NoteDao) : NoteRepository {

    override fun getAll(): Observable<List<Note>> {
        TODO("Not yet implemented")
    }

    override fun insert(note: Note): Completable {
        TODO("Not yet implemented")
    }
}