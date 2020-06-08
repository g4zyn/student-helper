package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

import rs.raf.projekat2.marko_gajin_RM8517.data.models.User

interface UserContract {

    interface ViewModel {

        fun isLogged(): Boolean
        fun getUser(): User?
        fun login(username: String, password: String): Boolean
        fun logout()

    }

}