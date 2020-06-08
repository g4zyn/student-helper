package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.NoteContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities.NoteActivity
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.adapters.NoteAdapter
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.NotesState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.NoteViewModel
import timber.log.Timber

class NotesFragment : Fragment(R.layout.fragment_notes) {

    private val noteViewModel: NoteContract.ViewModel by sharedViewModel<NoteViewModel>()

    private lateinit var adapter: NoteAdapter

    private var switch = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initRecycler()
        initListeners()
    }

    private fun initRecycler() {
        listRv.layoutManager = LinearLayoutManager(context)
        adapter = NoteAdapter(
            { noteViewModel.deleteNote(it) },
            {
                val intent = Intent(context, NoteActivity::class.java)
                noteViewModel.setNoteData(it, intent)
                startActivity(intent)
            },
            { noteViewModel.archiveNote(it) }
        )
        listRv.adapter = adapter
    }

    private fun initListeners() {
        searchEt.doAfterTextChanged {
            val search = it.toString()
            noteViewModel.searchNotes(search)
        }
        addBtn.setOnClickListener {
            val intent = Intent(context, NoteActivity::class.java)
            startActivity(intent)
        }
        switchBtn.setOnClickListener {
            switch = !switch
            noteViewModel.getNotes(switch)
        }
    }

    private fun initObservers() {
        noteViewModel.notesState.observe(viewLifecycleOwner, Observer {
            Timber.e("Note - $it")
            renderState(it)
        })
        noteViewModel.getNotes()
    }

    private fun renderState(state: NotesState) {
        when (state) {
            is NotesState.Success -> {
                showLoadingState(false)
                adapter.submitList(state.notes)
            }
            is NotesState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is NotesState.Loading -> {
                showLoadingState(true)
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
//        TODO implement loading state
    }

}