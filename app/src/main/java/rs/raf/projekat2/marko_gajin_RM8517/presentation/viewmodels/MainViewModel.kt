package rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.projekat2.marko_gajin_RM8517.data.models.LectureEntity
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Lecture
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.LectureRepository
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.MainContract
import timber.log.Timber

class MainViewModel(
    private val lectureRepository: LectureRepository
): ViewModel(), MainContract.ViewModel {

    override val schedule: MutableLiveData<List<Lecture>> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun fetchLectures() {
        val subscription = lectureRepository
            .fetchAll()
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

    override fun insertLectures(lectureEntities: List<LectureEntity>) {
        val subscription = lectureRepository
            .insertAll(lectureEntities)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("INSERTED LECTURES")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getLectures() {
        val subscription = lectureRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("$it")
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}