package com.example.classapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

            val submit: Button = findViewById(R.id.action_button)
            val register: Button = findViewById(R.id.reg_button)
            val nameEditText: EditText = findViewById(R.id.name)
            val emailEditText: EditText = findViewById(R.id.email)
            val passwordEditText: EditText = findViewById(R.id.password)

            submit.setOnClickListener{
                val user: UserModal = UserModal(nameEditText.text.toString(), emailEditText.text.toString(), passwordEditText.text.toString(), LoggedIn = true)
                if(ProfileRepository.loginUser(user)) {
                    val intent: Intent = Intent(this, Main2Activity::class.java)
                    intent.putExtra("user", user)
                    startActivityForResult(intent, 12)
                }
            }

            register.setOnClickListener{
                ProfileRepository.addUser(UserModal(nameEditText.text.toString(), emailEditText.text.toString(), passwordEditText.text.toString(), LoggedIn = false))
//                nameEditText.text.clear()
//                emailEditText.text.clear()
//                passwordEditText.text.clear()
            }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (resultCode == Activity.RESULT_OK) {
                val returneduser = data?.getSerializableExtra("returneduser")
                Log.d("bsu", returneduser.toString())
                //ProfileRepository.logoutUser(returneduser)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
