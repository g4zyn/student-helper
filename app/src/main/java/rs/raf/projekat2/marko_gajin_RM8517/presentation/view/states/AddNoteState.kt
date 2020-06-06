package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states

sealed class AddNoteState {

    object Success: AddNoteState()
    data class Error(val message: String): AddNoteState()
}