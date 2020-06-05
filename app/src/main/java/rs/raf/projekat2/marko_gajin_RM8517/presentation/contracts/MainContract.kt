package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture

interface MainContract {

    interface ViewModel {
        val schedule: LiveData<List<Lecture>>

        fun fetchLectures()
        fun insertLectures(lectureEntities: List<LectureEntity>)
        fun getLectures()
    }
}