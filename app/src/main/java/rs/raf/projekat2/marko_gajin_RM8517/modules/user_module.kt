package rs.raf.projekat2.marko_gajin_RM8517.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared.UserDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared.UserSharedPreference
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.UserRepository
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.UserRepositoryImpl
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.UserViewModel

val userModule = module {

    viewModel { UserViewModel(get()) }

    single<UserRepository> { UserRepositoryImpl(get()) }

    single<UserDataSource> { UserSharedPreference(sharedPreference = get()) }

}