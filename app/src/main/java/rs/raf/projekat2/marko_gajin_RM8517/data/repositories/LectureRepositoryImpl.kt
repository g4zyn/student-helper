package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.local.LectureDao
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.remote.LectureService
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Resource
import timber.log.Timber

class LectureRepositoryImpl(
    private val localDataSource: LectureDao,
    private val remoteDataSource: LectureService
): LectureRepository {

    private val lectureMap = { entities: List<LectureEntity> ->
         entities.map {
            Lecture(
                it.id,
                it.name,
                it.type,
                it.professor,
                it.groups,
                it.day,
                it.time,
                it.classroom
            )
         }
    }

    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource
            .getAll()
            .doOnNext {
                Timber.e("ADDING TO DATABASE")
                val entities = it.map {
                    LectureEntity(
                        0,
                        it.name,
                        it.type,
                        it.professor,
                        it.groups,
                        it.day,
                        it.time,
                        it.classroom
                    )
                }
                localDataSource.deleteAndInsertAll(entities)
            }
            .map {
                Resource.Success(Unit)
            }
    }

    override fun getAll(): Observable<List<Lecture>> {
        return localDataSource
            .getAll()
            .map {
                lectureMap(it)
            }
    }

    override fun getFiltered(): Observable<List<Lecture>> {
        TODO("Not yet implemented")
    }

    override fun getBySearch(search: String): Observable<List<Lecture>> {
        return localDataSource
            .getBySearch(search)
            .map {
                lectureMap(it)
            }
    }

    override fun getByDay(day: String): Observable<List<Lecture>> {
        return localDataSource
            .getByDay(day)
            .map {
                lectureMap(it)
            }
    }

    override fun getByGroups(groups: String): Observable<List<Lecture>> {
        return localDataSource
            .getByGroups(groups)
            .map {
                lectureMap(it)
            }
    }
}
