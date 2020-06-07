package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared

import android.content.Intent
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note

class NoteIntentDataSource : NoteDataSource{

    companion object {
        const val NOTE_KEY = "noteKey"
    }

    override fun setNoteData(note: Note, intent: Intent) {
        intent.putExtra(NOTE_KEY, note)
    }

    override fun getNoteData(intent: Intent): Note? {
        return intent.getParcelableExtra(NOTE_KEY)
    }

}