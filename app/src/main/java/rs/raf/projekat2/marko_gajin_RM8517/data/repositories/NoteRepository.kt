package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

interface NoteRepository {

    fun getAll(): Observable<List<Note>>
//    TODO get filtered
    fun insert(note: Note): Completable


}