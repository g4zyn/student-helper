package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Lecture

interface ScheduleContract {

    interface ViewModel {
        val schedule: LiveData<List<Lecture>>
        val lecture: LiveData<Lecture>

        fun getSchedule()
    }
}