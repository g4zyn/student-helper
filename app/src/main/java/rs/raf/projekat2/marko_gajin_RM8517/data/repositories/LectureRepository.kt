package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.projekat2.marko_gajin_RM8517.data.models.entity.LectureEntity

interface LectureRepository {

    fun insertAll(lectureEntities: List<LectureEntity>): Single<List<Long>>

    fun getAll(): Observable<List<LectureEntity>>
}