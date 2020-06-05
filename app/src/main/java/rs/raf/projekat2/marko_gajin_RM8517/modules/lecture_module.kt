package rs.raf.projekat2.marko_gajin_RM8517.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_gajin_RM8517.data.db.ScheduleDatabase
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.LectureRepository
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.LectureRepositoryImpl
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.MainViewModel

val lectureModule = module {

    viewModel { MainViewModel(get(), get()) }

    single<LectureRepository> { LectureRepositoryImpl(get()) }

    single { get<ScheduleDatabase>().getLectureDao() }
}