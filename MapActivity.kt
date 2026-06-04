package com.example.nammashasane

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_map)

        val listView = findViewById<ListView>(R.id.listView)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            DataSource.inscriptions
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra(
                "title",
                DataSource.inscriptions[position]
            )

            intent.putExtra(
                "description",
                DataSource.descriptions[position]
            )

            startActivity(intent)
        }
    }
}