package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.UserContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.UserViewModel

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private val userViewModel: UserContract.ViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        loginBtn.setOnClickListener {
            val username = usernameEt.text.toString()
            val password = passwordEt.text.toString()

            if (isInputValid(username, password)) {
                if (userViewModel.login(username, password)) {
                    login()
                } else {
                    Toast.makeText(applicationContext, "Wrong password!", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun isInputValid(username: String, password: String): Boolean {
        when {
            username == "" -> {
                Toast.makeText(applicationContext, "Username can't be empty!", Toast.LENGTH_SHORT).show()
            }
            password == "" -> {
                Toast.makeText(applicationContext, "Password can't be empty!", Toast.LENGTH_SHORT).show()
            }
            else -> return true
        }

        return false
    }

    private fun login() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}