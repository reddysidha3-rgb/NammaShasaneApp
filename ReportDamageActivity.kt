package com.example.nammashasane

import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ReportDamageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)

        layout.orientation = LinearLayout.VERTICAL

        layout.setPadding(40, 60, 40, 40)

        layout.setBackgroundResource(R.drawable.gradient_bg)

        val title = TextView(this)

        title.text = "⚠ Report Damaged Inscription"

        title.textSize = 28f

        title.setTextColor(Color.WHITE)

        val input = EditText(this)

        input.hint = "Enter damaged inscription details"

        input.setTextColor(Color.WHITE)

        input.setHintTextColor(Color.LTGRAY)

        val button = Button(this)

        button.text = "Submit Report"

        button.setTextColor(Color.WHITE)

        button.setBackgroundResource(R.drawable.button_style)

        val result = TextView(this)

        result.setTextColor(Color.WHITE)

        button.setOnClickListener {

            result.text = "✅ Damage Report Submitted"
        }

        layout.addView(title)

        layout.addView(input)

        layout.addView(button)

        layout.addView(result)

        setContentView(layout)
    }
}