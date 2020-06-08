package rs.raf.projekat2.marko_gajin_RM8517.presentation.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_gajin_RM8517.R
import rs.raf.projekat2.marko_gajin_RM8517.presentation.contracts.UserContract
import rs.raf.projekat2.marko_gajin_RM8517.presentation.view.activities.LoginActivity
import rs.raf.projekat2.marko_gajin_RM8517.presentation.viewmodels.UserViewModel

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val userViewModel: UserContract.ViewModel by viewModel<UserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initListeners()
    }

    private fun initUi() {
        val user = userViewModel.getUser()
        usernameTv.setText(user?.username)
    }

    private fun initListeners() {
        logoutBtn.setOnClickListener {
            userViewModel.logout()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}