package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Course

interface ScheduleContract {

    interface ViewModel {
        val schedule: LiveData<List<Course>>
        val course: LiveData<Course>

        fun getSchedule()
    }
}