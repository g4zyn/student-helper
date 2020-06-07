package rs.raf.projekat2.marko_gajin_RM8517.data.datasources.shared

import android.content.SharedPreferences
import rs.raf.projekat2.marko_gajin_RM8517.data.models.User

class UserSharedPreference(private val sharedPreference: SharedPreferences) : UserDataSource {

    companion object {
        const val USER_KEY = "userKey"
    }

    override fun getUser(): User? {
        val username = sharedPreference.getString(USER_KEY, "") ?: ""
        return User(username)
    }

    override fun setUser(user: User) {
        val editor = sharedPreference.edit()
        editor.putString(USER_KEY, user.username)
        editor.commit()
    }

    override fun removeUser() {
        val editor =  sharedPreference.edit()
        editor.putString(USER_KEY, "")
        editor.apply()
    }
}