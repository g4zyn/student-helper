package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

interface NoteContract {

    interface ViewModel {

        fun getNotes()
        fun addNote(note: Note)

    }

}