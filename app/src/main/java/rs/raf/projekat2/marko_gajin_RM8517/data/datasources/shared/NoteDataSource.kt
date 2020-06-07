package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared

import android.content.Intent
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

interface NoteDataSource {

    fun setNoteData(note: Note, intent: Intent)
    fun getNoteData(intent: Intent): Note?

}