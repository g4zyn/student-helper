package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared.UserDataSource
import rs.raf.projekat2.marko_gajin_RM8517.data.models.User

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {

    override fun getUser(): User? {
        return userDataSource.getUser()
    }

    override fun setUser(user: User) {
        userDataSource.setUser(user)
    }

    override fun removeUser() {
        userDataSource.removeUser()
    }
}