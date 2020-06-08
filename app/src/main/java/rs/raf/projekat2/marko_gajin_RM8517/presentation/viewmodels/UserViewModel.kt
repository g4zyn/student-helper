package rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels

import androidx.lifecycle.ViewModel
import rs.raf.projekat2.marko_gajin_RM8517.data.models.User
import rs.raf.projekat2.marko_gajin_RM8517.data.repositories.UserRepository
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.UserContract

class UserViewModel(
    private val userRepository: UserRepository
) : ViewModel(), UserContract.ViewModel {

    override fun isLogged(): Boolean {
        return (userRepository.getUser() != null)
    }

    override fun getUser(): User? {
        return userRepository.getUser()
    }

    override fun login(username: String, password: String): Boolean {
        val user = User(username)
        if (user.password == password) {
            userRepository.setUser(user)
            return true
        }
        return false
    }

    override fun logout() {
        userRepository.removeUser()
    }

}