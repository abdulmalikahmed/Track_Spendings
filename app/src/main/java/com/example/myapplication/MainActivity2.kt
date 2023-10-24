package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import android.widget.Toast
import android.widget.Toast.makeText

class MainActivity2 : AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var enterprise: EditText
    private lateinit var logoutButton: Button
    private lateinit var checkBalanceButton: Button
    private lateinit var addButton: Button
    private lateinit var spinner: Spinner
    private val dataArray = mutableListOf<String>()
    private val numericValues = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val classification = resources.getStringArray(R.array.Classification)

        spinner = findViewById(R.id.DDL)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, classification)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                makeText(this@MainActivity2, getString(R.string.selected_item) + " " + classification[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        tvName = findViewById(R.id.tvName)
        enterprise = findViewById(R.id.EnterPrinceText)
        enterprise.inputType = InputType.TYPE_CLASS_NUMBER
        logoutButton = findViewById(R.id.LoutButton)
        checkBalanceButton = findViewById(R.id.CheckButton)
        addButton = findViewById(R.id.AddButton)

        val bundle = intent.extras
        if (bundle != null) {
            tvName.text = "Welcome: ${bundle.getString("name")}"


        }
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
            addButton.setOnClickListener {
                val textViewValue = enterprise.text.toString()
                val spinnerValue = spinner.selectedItem.toString()
                try {
                    val numericValue = textViewValue.toInt()
                    numericValues.add(numericValue)
                    dataArray.add("  $$textViewValue                              $spinnerValue \n")
                } catch (e: NumberFormatException) {
                    // Handle invalid input (non-numeric)
                    Toast.makeText(this@MainActivity2, "Please enter a numeric value", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // If you want to store the entire list as a String:
                val dataString = dataArray.joinToString(",")
                val bundle = Bundle()
                bundle.putString("dataArray", dataString)
                enterprise.text=null
                makeText(this@MainActivity2, "You add the data successfully ", Toast.LENGTH_SHORT).show()
            }

            checkBalanceButton.setOnClickListener {
                val totalSum = numericValues.sum()
                val dataString = dataArray.joinToString(",")
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("dataArray", dataString)
                intent.putExtra("totalSum", totalSum)
                startActivity(intent)
            }
        }
    }
