package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Course
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.MainContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.MainViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {

        mainViewModel.schedule.observe(this, Observer {
            Timber.e("Got schedule $it")
        })
        mainViewModel.getSchedule()
    }

}
