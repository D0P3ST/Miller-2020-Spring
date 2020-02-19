package com.example.classapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val user: UserModal = intent.getSerializableExtra("user") as UserModal

        val userTextView: TextView = findViewById(R.id.user1)
        val emailTextView: TextView = findViewById(R.id.email1)
        userTextView.text = user.Username
        emailTextView.text = user.Email
        val logout: Button = findViewById(R.id.action_button2)

        logout.setOnClickListener{

            val returnIntent: Intent = Intent()
            returnIntent.putExtra("returneduser", UserModal("asd", "asddd", "fgh", LoggedIn = false))
//            returnIntent.putExtra("returneduser", UserModal(user.Username, user.Email, user.Password, LoggedIn = false))

            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
