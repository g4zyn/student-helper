package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states

import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture

sealed class LecturesState{

    object Loading: LecturesState()
    object DataFetched: LecturesState()
    data class Success(val lectures: List<Lecture>): LecturesState()
    data class Error(val message: String): LecturesState()
}