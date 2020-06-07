package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.UserContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.UserViewModel
import timber.log.Timber

class SplashActivity : AppCompatActivity() {

    private val userViewModel: UserContract.ViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        navigate()
    }

    private fun navigate() {

        if (userViewModel.isLogged()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        finish()
    }
}
