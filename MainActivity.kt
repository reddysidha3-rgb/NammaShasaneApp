package com.example.nammashasane

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {

        val shasanaList = mutableListOf(

            Shasana(
                1,
                "Hoysala Temple Donation",
                "Land donation by King Vishnuvardhana to a Shiva temple.",
                "Belur, Karnataka"
            ),

            Shasana(
                2,
                "Vijayanagara Land Grant",
                "Ancient education support inscription.",
                "Hampi, Karnataka"
            ),

            Shasana(
                3,
                "Chola Trade Record",
                "Stone inscription about trade agreements.",
                "Tamil Nadu"
            ),

            Shasana(
                4,
                "Kadamba Military Victory",
                "Describes battle victory and rewards.",
                "Banavasi, Karnataka"
            )
        )
    }

    lateinit var adapter: ArrayAdapter<String>

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // FULL SCREEN
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                )

        // ROOT LAYOUT
        val rootLayout = LinearLayout(this)

        rootLayout.orientation = LinearLayout.VERTICAL

        rootLayout.setPadding(35, 70, 35, 35)

        rootLayout.setBackgroundResource(R.drawable.gradient_bg)

        // TITLE
        val title = TextView(this)

        title.text = "🪨 Namma-Shasane"

        title.textSize = 34f

        title.gravity = Gravity.CENTER

        title.setTextColor(Color.WHITE)

        // SUBTITLE
        val subtitle = TextView(this)

        subtitle.text = "Explore & Preserve Ancient Inscriptions"

        subtitle.textSize = 17f

        subtitle.gravity = Gravity.CENTER

        subtitle.setTextColor(Color.parseColor("#D9E2EC"))

        // SPACE
        val space = Space(this)

        space.minimumHeight = 25

        // LISTVIEW
        listView = ListView(this)

        val names = shasanaList.map {

            "📜 ${it.title}\n📍 ${it.location}"
        }

        // CUSTOM ADAPTER
        adapter = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            names
        ) {

            override fun getView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {

                val view = super.getView(position, convertView, parent)

                val text = view.findViewById<TextView>(android.R.id.text1)

                text.setTextColor(Color.WHITE)

                text.textSize = 18f

                text.setPadding(35, 35, 35, 35)

                text.gravity = Gravity.START

                view.setBackgroundColor(
                    Color.parseColor("#243447")
                )

                return view
            }
        }

        listView.adapter = adapter

        listView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            0,
            1f
        )

        listView.dividerHeight = 8

        listView.setBackgroundColor(Color.TRANSPARENT)

        // CLICK ITEM
        listView.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra("id", shasanaList[position].id)

            startActivity(intent)
        }

        // ADD BUTTON
        val addButton = Button(this)

        addButton.text = "➕ Add New Inscription"

        addButton.textSize = 18f

        addButton.setTextColor(Color.WHITE)

        addButton.setBackgroundResource(R.drawable.button_style)

        addButton.setOnClickListener {

            startActivity(
                Intent(this, AddShasanaActivity::class.java)
            )
        }

        // SPACE 2
        val space2 = Space(this)

        space2.minimumHeight = 20

        // DAMAGE BUTTON
        val damageButton = Button(this)

        damageButton.text = "⚠ Report Damage"

        damageButton.textSize = 18f

        damageButton.setTextColor(Color.WHITE)

        damageButton.setBackgroundResource(R.drawable.button_style)

        damageButton.setOnClickListener {

            startActivity(
                Intent(this, ReportDamageActivity::class.java)
            )
        }

        // FOOTER
        val footer = TextView(this)

        footer.text = "\n🏛 Preserve Heritage Through Technology"

        footer.gravity = Gravity.CENTER

        footer.setTextColor(Color.parseColor("#B0BEC5"))

        footer.textSize = 14f

        // ADD VIEWS
        rootLayout.addView(title)

        rootLayout.addView(subtitle)

        rootLayout.addView(space)

        rootLayout.addView(listView)

        rootLayout.addView(addButton)

        rootLayout.addView(space2)

        rootLayout.addView(damageButton)

        rootLayout.addView(footer)

        setContentView(rootLayout)
    }

    override fun onRestart() {

        super.onRestart()

        val names = shasanaList.map {

            "📜 ${it.title}\n📍 ${it.location}"
        }

        adapter.clear()

        adapter.addAll(names)

        adapter.notifyDataSetChanged()
    }
}