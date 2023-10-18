package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
           lateinit var username : EditText
           lateinit var logbtn : Button



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.UsernameText)
        logbtn = findViewById(R.id.Loginbtn)

      logbtn.setOnClickListener {

          val bundle = Bundle()
          bundle.putString("name", username.text.toString())

          val intent = Intent(this, MainActivity2::class.java)
          intent.putExtras(bundle)
          startActivity(intent)
      }


    }


}