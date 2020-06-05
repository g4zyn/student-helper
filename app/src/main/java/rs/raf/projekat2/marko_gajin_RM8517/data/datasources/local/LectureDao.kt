package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity

@Dao
abstract class LectureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertLectures(lectureEntity: List<LectureEntity>): Completable

    @Query("SELECT * FROM lectures")
    abstract fun getAll(): Observable<List<LectureEntity>>

    @Query("DELETE FROM lectures")
    abstract fun deleteAll()

    @Transaction
    open fun deleteAndInsertAll(entities: List<LectureEntity>) {
        deleteAll()
        insertLectures(entities).blockingAwait()
    }

//    TODO get filtered
}