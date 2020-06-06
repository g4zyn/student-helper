package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.LectureContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.LectureViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val lectureViewModel: LectureContract.ViewModel by viewModel<LectureViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {

        lectureViewModel.lecturesState.observe(this, Observer {
            Timber.e(it.toString())
        })

        lectureViewModel.fetchLectures()
        lectureViewModel.getLectures()
    }

}
