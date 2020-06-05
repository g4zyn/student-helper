package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Resource

interface LectureRepository {

    fun fetchAll(): Observable<Resource<Unit>>
    fun getAll(): Observable<List<Lecture>>
//    TODO addLecture method
}