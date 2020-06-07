package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared

import rs.raf.projekat2.marko_gajin_RM8517.data.models.User

interface UserDataSource {

    fun getUser(): User?
    fun setUser(user: User)
    fun removeUser()

}