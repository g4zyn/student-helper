package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import androidx.lifecycle.LiveData
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.AddNoteState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.DeleteNoteState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.NotesState

interface NoteContract {

    interface ViewModel {

        val notesState: LiveData<NotesState>
        val addDone: LiveData<AddNoteState>
        val deleteDone: LiveData<DeleteNoteState>

        fun getNotes()
        fun addNote(note: Note)
        fun deleteNote(note: Note)
    }

}