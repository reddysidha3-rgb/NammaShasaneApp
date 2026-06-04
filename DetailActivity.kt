package com.example.nammashasane

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("id", 0)

        val item = MainActivity.shasanaList.find {

            it.id == id
        }

        val textView = TextView(this)

        textView.setPadding(50, 60, 50, 50)

        textView.textSize = 22f

        textView.setTextColor(Color.WHITE)

        textView.setBackgroundResource(R.drawable.gradient_bg)

        if (item != null) {

            textView.text = """
🪨 INSCRIPTION DETAILS

📌 Title:
${item.title}

📜 Description:
${item.description}

📍 Location:
${item.location}

🏛 Heritage Category:
Ancient South Indian Inscription
            """.trimIndent()
        }

        setContentView(textView)
    }
}