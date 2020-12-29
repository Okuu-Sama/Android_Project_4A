package com.example.android_project_4a.presentation.main

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

    val mainViewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it)
            {
              is LoginSuccess -> {
                  val intent = Intent(this, ListActivity::class.java)
                  //intent.putExtra("elemnt", it.email)
                  intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                  startActivity(intent)
              }
              LoginError -> {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Unknown Account or Incorrect Password")
                    .setPositiveButton("OK") { dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }
            }
        })

        login_button.setOnClickListener()
        {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }

        create_account_button.setOnClickListener()
        {
            val intent = Intent(this, SignupActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}
