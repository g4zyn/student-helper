package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
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

class ScheduleFragment : Fragment(R.layout.fragment_schedule), AdapterView.OnItemSelectedListener {

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
        initSpinner()
        initRecycler()
        initListeners()
    }

    private fun initRecycler() {
        listRv.layoutManager = LinearLayoutManager(context)
        adapter = ScheduleAdapter()
        listRv.adapter = adapter
    }

    private fun initListeners() {
        searchEt.doAfterTextChanged {
            val search = it.toString()
            lectureViewModel.searchLectures(search)
        }
    }

    private fun initSpinner() {
        val spinner: Spinner = day_spinner
        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.days_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
//        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selected = parent?.getItemAtPosition(position)
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