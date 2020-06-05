package rs.raf.projekat2.marko_gajin_RM8517.modules

import org.koin.dsl.module
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.ScheduleDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.ScheduleRepository
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.ScheduleRepositoryImpl

val scheduleModule = module {

    single<ScheduleRepository> { ScheduleRepositoryImpl(get()) }

    single<ScheduleDataSource> { create(get()) }

}