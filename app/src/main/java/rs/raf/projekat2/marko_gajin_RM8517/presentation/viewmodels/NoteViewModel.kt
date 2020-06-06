package rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels

import androidx.lifecycle.ViewModel
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.NoteRepository
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.NoteContract

class NoteViewModel(
    private val noteRepository: NoteRepository
) : ViewModel(), NoteContract.ViewModel {
    
    override fun getNotes() {
        TODO("Not yet implemented")
    }

    override fun addNote(note: Note) {
        TODO("Not yet implemented")
    }
}