package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.LectureContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.viewpagers.NavigationAdapter
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.LectureViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val lectureViewModel: LectureContract.ViewModel by viewModel<LectureViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
//        initObservers()
    }

    private fun initViewPager() {
        viewPager.adapter = NavigationAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.scheduleNav -> {
                    viewPager.setCurrentItem(NavigationAdapter.FRAGMENT_SCHEDULE, false)
                }
                R.id.notesNav -> {
                    viewPager.setCurrentItem(NavigationAdapter.FRAGMENT_NOTES, false)
                }
                R.id.profileNav -> {
                    viewPager.setCurrentItem(NavigationAdapter.FRAGMENT_PROFILE, false)
                }
            }
            true
        }
    }

    private fun initObservers() {

        lectureViewModel.lecturesState.observe(this, Observer {
            Timber.e(it.toString())
        })

        lectureViewModel.fetchLectures()
        lectureViewModel.getLectures()
    }

}
