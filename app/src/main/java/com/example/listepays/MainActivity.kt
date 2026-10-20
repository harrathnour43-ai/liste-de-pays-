package com.example.listepays

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listViewPays = findViewById<ListView>(R.id.listViewPays)
        val countries = resources.getStringArray(R.array.countries)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries
        )

        listViewPays.adapter = adapter

        listViewPays.setOnItemClickListener { _, _, position, _ ->
            val selectedCountry = countries[position]
            Toast.makeText(
                this,
                "Pays sélectionné : $selectedCountry",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}