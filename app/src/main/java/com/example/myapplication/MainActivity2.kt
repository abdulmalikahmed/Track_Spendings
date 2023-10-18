package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var tvName : TextView
    lateinit var enterprice : EditText
    lateinit var Logoutbtn : Button
    lateinit var CheckBalance : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val Classification =resources.getStringArray(R.array.Classification)

        val spinner=findViewById<Spinner>(R.id.DDL)
        if (spinner!= null){
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,Classification)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>,

                                            view: View, position: Int, id: Long) {

                    Toast.makeText(this@MainActivity2,

                        getString(R.string.selected_item) + " " +

                                "" + Classification[position], Toast.LENGTH_SHORT).show()

                }


                override fun onNothingSelected(parent: AdapterView<*>){

                }
            }
        }

        tvName = findViewById(R.id.tvName)
        val bundle = intent.extras
        if (bundle != null){

            tvName.text = "Welcome: ${bundle.getString("name")}"
            enterprice = findViewById(R.id.EnterPrinceText)
            Logoutbtn = findViewById(R.id.LoutButton)
            CheckBalance = findViewById(R.id.CheckButton)

            Logoutbtn.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            CheckBalance.setOnClickListener {
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }




        }
    }
}