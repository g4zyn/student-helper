package rs.raf.projekat2.marko_gajin_RM8517.data.repositories

import rs.raf.projekat2.marko_gajin_RM8517.data.models.User

interface UserRepository {

    fun getUser(): User?
    fun setUser(user: User)
    fun removeUser()
}