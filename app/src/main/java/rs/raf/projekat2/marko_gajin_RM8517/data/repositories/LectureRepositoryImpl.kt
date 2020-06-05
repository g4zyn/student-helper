package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import io.reactivex.Single
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.LectureDao
import rs.raf.projekat2.marko_gajin_RM8517.data.models.entity.LectureEntity

class LectureRepositoryImpl(private val lectureDao: LectureDao): LectureRepository {

    override fun insertAll(lectureEntities: List<LectureEntity>): Single<List<Long>> {
        return lectureDao.insertLectures(lectureEntities)
    }

    override fun getAll(): Observable<List<LectureEntity>> {
        return lectureDao.getAll()
    }

}