package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.AddLectureState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.LecturesState

interface LectureContract {

    interface ViewModel {

        val lecturesState: LiveData<LecturesState>
        val addDone: LiveData<AddLectureState>

        fun fetchLectures()
        fun getLectures()
        fun searchLectures(search: String)
        fun getByDay(day: String)
        fun getByGroups(classroom: String)

    }
}