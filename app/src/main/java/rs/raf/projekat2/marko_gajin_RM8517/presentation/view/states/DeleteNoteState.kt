package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states

sealed class DeleteNoteState {
    object Success: DeleteNoteState()
    data class Error(val message: String): DeleteNoteState()
}