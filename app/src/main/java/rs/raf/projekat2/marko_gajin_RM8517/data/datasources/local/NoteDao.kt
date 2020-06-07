package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.models.NoteEntity

@Dao
abstract class NoteDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    abstract fun insert(entity: NoteEntity): Completable

    @Query("SELECT * FROM notes")
    abstract fun getAll(): Observable<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE title LIKE :search || '%' or body LIKE :search || '%'")
    abstract fun getBySearch(search: String): Observable<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE archived == 'true'")
    abstract fun getArchived(): Observable<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id == :id")
    abstract fun getById(id: Long): NoteEntity

    @Query("DELETE FROM notes WHERE id == :id")
    abstract fun delete(id: Long): Completable

    @Update
    abstract fun update(noteEntity: NoteEntity)

}