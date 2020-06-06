package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states

import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

sealed class NotesState {

    object Loading: NotesState()
    data class Success(val notes: List<Note>): NotesState()
    data class Error(val message: String): NotesState()
}