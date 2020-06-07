package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_note.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Note
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.NoteContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.NoteViewModel

class NoteActivity : AppCompatActivity(R.layout.activity_note) {

    private val noteViewModel: NoteContract.ViewModel by viewModel<NoteViewModel>()

    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initListeners()
    }

    private fun initUi() {
        intent.let {
            note = noteViewModel.getNoteData(it)
            titleEt.setText(note?.title)
            bodyEt.setText(note?.body)
        }
    }

    private fun initListeners() {
        cancelBtn.setOnClickListener {
            finish()
        }
        saveBtn.setOnClickListener {
            val newNote = Note(0, titleEt.text.toString(), bodyEt.text.toString())
            if (note == null) {
                noteViewModel.addNote(newNote)
            } else {
//                noteViewModel.editNote(newNote)
            }
            finish()
        }
    }
}