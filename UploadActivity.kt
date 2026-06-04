package com.example.nammashasane

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UploadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_upload)

        val editTitle = findViewById<EditText>(R.id.editTitle)
        val editLocation = findViewById<EditText>(R.id.editLocation)
        val editDescription = findViewById<EditText>(R.id.editDescription)

        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {

            val title = editTitle.text.toString()
            val location = editLocation.text.toString()
            val description = editDescription.text.toString()

            if (title.isEmpty() ||
                location.isEmpty() ||
                description.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val newInscription = "$title - $location"

                DataSource.inscriptions.add(newInscription)

                DataSource.descriptions.add(description)

                Toast.makeText(
                    this,
                    "Inscription Saved Successfully",
                    Toast.LENGTH_LONG
                ).show()

                editTitle.text.clear()
                editLocation.text.clear()
                editDescription.text.clear()
            }
        }
    }
}