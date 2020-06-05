package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states

sealed class AddLectureState {

    object Success: AddLectureState()
    data class Error(val message: String): AddLectureState()
}