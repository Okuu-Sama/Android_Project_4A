package com.example.android_project_4a.presentation.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.android_project_4a.R
import com.example.android_project_4a.presentation.list.ListActivity
import com.example.android_project_4a.presentation.signup.SignupActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it)
            {
              is LoginSuccess -> {
                  val intent = Intent(this, ListActivity::class.java)
                  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                  startActivity(intent)
                  finish()
              }
              is LoginError -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Unknown Account or Incorrect Password")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
              }
            }
        })

        login_button.setOnClickListener()
        {
            when
            {
                login_edit.text.toString() == "" -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Account field is empty!")
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
                password_edit.text.toString() == "" -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Password field is empty!")
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
                else -> {
                    mainViewModel.onClickedLogin(login_edit.text.toString().trim(),
                        password_edit.text.toString())
                }
            }
        }

        create_account_button.setOnClickListener()
        {
            val intent = Intent(this, SignupActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
