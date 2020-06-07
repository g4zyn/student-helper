package rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts

interface UserContract {

    interface ViewModel {

        fun isLogged(): Boolean
        fun login(username: String, password: String): Boolean
        fun logout()

    }

}