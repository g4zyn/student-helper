package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Resource

interface LectureRepository {

    fun fetchAll(): Observable<Resource<Unit>>
    fun getFiltered(search: String, groups: String, day: String): Observable<List<Lecture>>
    fun getBySearch(search: String): Observable<List<Lecture>>

//    fun getByDay(day: String): Observable<List<Lecture>>
//    fun getAll(): Observable<List<Lecture>>
//    fun getByGroups(groups: String): Observable<List<Lecture>>
}