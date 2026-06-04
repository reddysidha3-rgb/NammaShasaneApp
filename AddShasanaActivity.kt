package com.example.nammashasane

import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddShasanaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)

        layout.orientation = LinearLayout.VERTICAL

        layout.setPadding(40, 60, 40, 40)

        layout.setBackgroundResource(R.drawable.gradient_bg)

        val title = TextView(this)

        title.text = "➕ Add New Inscription"

        title.textSize = 30f

        title.setTextColor(Color.WHITE)

        val titleInput = EditText(this)

        titleInput.hint = "Enter inscription title"

        titleInput.setTextColor(Color.WHITE)

        titleInput.setHintTextColor(Color.LTGRAY)

        val descInput = EditText(this)

        descInput.hint = "Enter description"

        descInput.setTextColor(Color.WHITE)

        descInput.setHintTextColor(Color.LTGRAY)

        val locationInput = EditText(this)

        locationInput.hint = "Enter location manually"

        locationInput.setTextColor(Color.WHITE)

        locationInput.setHintTextColor(Color.LTGRAY)

        val saveButton = Button(this)

        saveButton.text = "💾 Save Inscription"

        saveButton.setTextColor(Color.WHITE)

        saveButton.setBackgroundResource(R.drawable.button_style)

        val message = TextView(this)

        message.setTextColor(Color.WHITE)

        saveButton.setOnClickListener {

            val titleText = titleInput.text.toString()

            val descText = descInput.text.toString()

            val locationText = locationInput.text.toString()

            if (titleText.isEmpty()
                || descText.isEmpty()
                || locationText.isEmpty()
            ) {

                message.text = "❌ Fill all fields"

            } else {

                val newItem = Shasana(
                    MainActivity.shasanaList.size + 1,
                    titleText,
                    descText,
                    locationText
                )

                MainActivity.shasanaList.add(newItem)

                message.text = "✅ Inscription Saved Successfully"

                titleInput.text.clear()

                descInput.text.clear()

                locationInput.text.clear()
            }
        }

        layout.addView(title)

        layout.addView(titleInput)

        layout.addView(descInput)

        layout.addView(locationInput)

        layout.addView(saveButton)

        layout.addView(message)

        setContentView(layout)
    }
}