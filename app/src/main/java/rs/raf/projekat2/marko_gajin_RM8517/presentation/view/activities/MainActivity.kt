package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.ScheduleContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.ScheduleViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val scheduleViewModel: ScheduleContract.ViewModel by viewModel<ScheduleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {

        scheduleViewModel.schedule.observe(this, Observer {
            Timber.e("Got schedule $it")
        })
        scheduleViewModel.getSchedule()

    }

}
