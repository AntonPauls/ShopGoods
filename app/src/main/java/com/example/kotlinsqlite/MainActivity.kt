package com.example.kotlinsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPassword: EditText = findViewById(R.id.user_password)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.linkToAuth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }


        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if(login == "" || email == "" || pass == ""){
                Toast.makeText(this, "Someone field is null!", Toast.LENGTH_SHORT).show()
            }else{
                val user = User(login, email, pass)

                val db = DBHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Person with login - ${login} added", Toast.LENGTH_SHORT).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }
        }
    }
}