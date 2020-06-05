package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity

@Dao
abstract class LectureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertLectures(lectureEntity: List<LectureEntity>): Single<List<Long>>

    @Query("SELECT * FROM lectures")
    abstract fun getAll(): Observable<List<LectureEntity>>

}