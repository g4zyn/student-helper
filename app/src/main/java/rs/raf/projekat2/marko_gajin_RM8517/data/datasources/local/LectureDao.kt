package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity

@Dao
abstract class LectureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertLectures(lectureEntity: List<LectureEntity>): Completable

    @Query("SELECT * FROM lectures")
    abstract fun getAll(): Observable<List<LectureEntity>>

    @Query("SELECT * FROM lectures WHERE name LIKE :search || '%' or professor LIKE :search || '%'")
    abstract fun getBySearch(search: String): Observable<List<LectureEntity>>

    @Query("SELECT * FROM lectures WHERE day == :day")
    abstract fun getByDay(day: String): Observable<List<LectureEntity>>

    @Query("SELECT * FROM lectures WHERE groups LIKE '%' || :groups or groups LIKE :groups || '%'")
    abstract fun getByGroups(groups: String): Observable<List<LectureEntity>>

    @Query("DELETE FROM lectures")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsertAll(entities: List<LectureEntity>) {
        deleteAll()
        insertLectures(entities).blockingAwait()
    }

}