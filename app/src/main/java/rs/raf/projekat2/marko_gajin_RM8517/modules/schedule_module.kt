package rs.raf.projekat2.marko_gajin_RM8517.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.ScheduleDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.ScheduleRepository
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.ScheduleRepositoryImpl
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.ScheduleViewModel

val scheduleModule = module {

    viewModel { ScheduleViewModel(get()) }

    single<ScheduleRepository> { ScheduleRepositoryImpl(get()) }

    single<ScheduleDataSource> { create(get()) }
}