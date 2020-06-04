package rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekat2.marko_gajin_RM8517.data.models.ui.Course
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.ScheduleRepository
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.ScheduleContract
import timber.log.Timber

class MainViewModel(private val scheduleRepository: ScheduleRepository): ViewModel(), ScheduleContract.ViewModel {

    override val schedule: MutableLiveData<List<Course>> = MutableLiveData()
    override val course: MutableLiveData<Course> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

//    Get lecture schedule
    override fun getSchedule() {
        val subscription = scheduleRepository
            .getSchedule()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    schedule.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}