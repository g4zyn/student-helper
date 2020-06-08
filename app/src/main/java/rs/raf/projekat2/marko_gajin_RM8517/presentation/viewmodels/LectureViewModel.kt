package rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import rs.raf.projekat2.marko_gajin_RM8517.data.models.Resource
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.LectureRepository
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.LectureContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.AddLectureState
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.states.LecturesState
import timber.log.Timber
import java.util.concurrent.TimeUnit

class LectureViewModel(
    private val lectureRepository: LectureRepository
): ViewModel(), LectureContract.ViewModel {

    private val subscriptions = CompositeDisposable()
    override val lecturesState: MutableLiveData<LecturesState> = MutableLiveData()
    override val addDone: MutableLiveData<AddLectureState> = MutableLiveData()

    private val publishSubject: PublishSubject<String> = PublishSubject.create()

    init {
        val subscription = publishSubject
            .debounce(200, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap {
                lectureRepository
                    .getBySearch(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError {
                        Timber.e("Error in publish subject")
                        Timber.e(it)
                    }
            }
            .subscribe(
                {
                    lecturesState.value = LecturesState.Success(it)
                },
                {
                    lecturesState.value = LecturesState.Error("Error happened while fetching data from database")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun fetchLectures() {
        val subscription = lectureRepository
            .fetchAll()
            .startWith(Resource.Loading())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    when (it) {
                        is Resource.Loading -> lecturesState.value = LecturesState.Loading
                        is Resource.Success -> lecturesState.value = LecturesState.DataFetched
                        is Resource.Error -> lecturesState.value = LecturesState.Error("Error happened while fetching data from server")
                    }
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getLectures(search: String, groups: String, day: String) {
        val subscription = lectureRepository
            .getFiltered(search, groups, day)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    lecturesState.value = LecturesState.Success(it)
                },
                {
                    lecturesState.value = LecturesState.Error("Error happened while fetching data from database")
                }
            )
        subscriptions.add(subscription)
    }

    override fun searchLectures(search: String) {
        publishSubject.onNext(search)
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}