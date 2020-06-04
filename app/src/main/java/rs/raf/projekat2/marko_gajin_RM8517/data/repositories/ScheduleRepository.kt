package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Lecture

interface ScheduleRepository {

    fun getSchedule(): Observable<List<Lecture>>

//    fun getLecture(name: String): Observable<Lecture>

}