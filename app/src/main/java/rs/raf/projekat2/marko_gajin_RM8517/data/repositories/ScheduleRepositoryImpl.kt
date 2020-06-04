package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import io.reactivex.Observable
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.ScheduleDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Course

class ScheduleRepositoryImpl(private val scheduleDataSource: ScheduleDataSource): ScheduleRepository {

    override fun getSchedule(): Observable<List<Course>> {

        return scheduleDataSource
            .getAll()
            .map {
                it.map {
                    Course(
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
    }

}