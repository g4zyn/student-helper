package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import android.content.Intent
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

interface NoteRepository {

    fun getAll(): Observable<List<Note>>
    fun getArchived(): Observable<List<Note>>
    fun getBySearch(search: String): Observable<List<Note>>
    fun insert(note: Note): Completable
    fun delete(id: Long): Completable
    fun edit(note: Note): Completable
    fun archive(note: Note): Completable
    fun getNoteData(intent: Intent): Note?
    fun setNoteData(note: Note, intent: Intent)

}