package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.ScheduleDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Lecture

class ScheduleRepositoryImpl(private val scheduleDataSource: ScheduleDataSource): ScheduleRepository {

    override fun getSchedule(): Observable<List<Lecture>> {

        return scheduleDataSource
            .getAll()
            .map {
                it.data.map {
                    Lecture(
                        it.name,
                        it.type,
                        it.professor,
                        it.groups,
                        it.time,
                        it.classroom
                    )
                }
            }
    }


}