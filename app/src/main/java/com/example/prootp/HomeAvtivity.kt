package com.example.prootp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HomeAvtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_avtivity)

        val btnperson = findViewById<ImageView>(R.id.imageView3)
        val btnhome = findViewById<ImageView>(R.id.imageView4)
        val btnslots = findViewById<ImageView>(R.id.imageView5)
        val btninsta = findViewById<ImageView>(R.id.insta)
        val btnlinkedin = findViewById<ImageView>(R.id.linkedin)

        btnperson.setOnClickListener {
            val btnper = Intent(this,Person::class.java)
            startActivity(btnper)
        }

        btnslots.setOnClickListener {
            val btnslo = Intent(this,Booking::class.java)
            startActivity(btnslo)
        }

        btninsta.setOnClickListener {
            val uri: Uri =
                Uri.parse("https://www.instagram.com/cristiano/") // missing 'http://' will cause crashed

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnlinkedin.setOnClickListener {
            val uri = Uri.parse("https://www.linkedin.com/in/pratik-patil-a35117228") // missing 'http://' will cause crashed

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}