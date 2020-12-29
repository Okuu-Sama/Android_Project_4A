package com.example.android_project_4a.presentation.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.android_project_4a.R
import com.example.android_project_4a.presentation.list.ListActivity
import com.example.android_project_4a.presentation.main.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.login_edit
import kotlinx.android.synthetic.main.activity_main.password_edit
import kotlinx.android.synthetic.main.signup_activity.*
import org.koin.android.ext.android.inject

class SignupActivity : AppCompatActivity() {

    val signupViewModel: SignupViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        signupViewModel.signupLiveData.observe(this, Observer {
            when(it)
            {
              is SignupSuccess -> {
                  val intent = Intent(this, ListActivity::class.java)
                  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                  startActivity(intent)
              }
              SignupError -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Account already exist")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }
            }
        })

        signup_button.setOnClickListener()
        {
            signupViewModel.onClickedSignup(login_edit.text.toString().trim(), password_edit.text.toString())
        }

    }
}
