package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_stats.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.NoteContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.NotesState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.NoteViewModel

class StatsFragment : Fragment(R.layout.fragment_stats) {

    private val noteViewModel: NoteContract.ViewModel by sharedViewModel<NoteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        noteViewModel.notesState.observe(viewLifecycleOwner, Observer {
            squareView.heightDivider = countSize(it)
            squareView.invalidate()
        })
    }

    private fun countSize(state: NotesState, count: Int = 0): Int {
        when(state){
            is NotesState.Success -> {
                return state.notes.size
            }
        }
        return count
    }

}