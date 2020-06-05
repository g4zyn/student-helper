package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_gajin_RM8517.data.models.entity.LectureEntity
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Course

interface MainContract {

    interface ViewModel {
        val schedule: LiveData<List<Course>>

        fun getSchedule()
        fun insertLectures(lectureEntities: List<LectureEntity>)
        fun getAllLectures()
    }
}