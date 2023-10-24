package com.example.myapplication

import DataAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlin.text.split
import kotlin.text.trim

class MainActivity3 : AppCompatActivity() {
    private lateinit var BackToHomePage: Button
    private lateinit var recyclerView: RecyclerView
    private val dataArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val totalSum = intent.getIntExtra("totalSum", 0) // Default value is 0
        val totalSumTextView = findViewById<TextView>(R.id.TotalSum)
        totalSumTextView.text = " Total spending : $$totalSum"
        BackToHomePage = findViewById(R.id.BTHPButton)
        recyclerView = findViewById(R.id.recyclerView)

        val dataString = intent.getStringExtra("dataArray")
        val trimmedArray = dataString?.split(",")?.map { it.trim() } ?: emptyList()
        dataArray.addAll(trimmedArray)

        // Create an adapter to display the data in the RecyclerView
        val adapter = DataAdapter(dataArray)

        // Use a GridLayoutManager to create a table-like layout with two columns
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        BackToHomePage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
