package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.LectureContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.recycler.adapters.ScheduleAdapter
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.LecturesState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.LectureViewModel
import timber.log.Timber

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val lectureViewModel: LectureContract.ViewModel by sharedViewModel<LectureViewModel>()

    private lateinit var adapter: ScheduleAdapter

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
        adapter = ScheduleAdapter()
        listRv.adapter = adapter
    }

    private fun initListeners() {
//        TODO implement listeners
    }

    private fun initObservers() {

        lectureViewModel.lecturesState.observe(viewLifecycleOwner, Observer {
            Timber.e(it.toString())
            renderState(it)
        })

        lectureViewModel.fetchLectures()
        lectureViewModel.getLectures()
    }

    private fun renderState(state: LecturesState) {

        when (state) {
            is LecturesState.Success -> {
                showLoadingState(false)
                adapter.submitList(state.lectures)
            }
            is LecturesState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is  LecturesState.DataFetched -> {
                showLoadingState(false)
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_SHORT).show()
            }
            is LecturesState.Loading -> {
                showLoadingState(true)
                Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
//        TODO implement show loading state
    }

}