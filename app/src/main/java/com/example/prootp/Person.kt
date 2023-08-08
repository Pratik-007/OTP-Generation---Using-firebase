package com.example.prootp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Person : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        //val btnarrow = findViewById<ImageView>(R.id.arrows)
        val btnslot = findViewById<TextView>(R.id.textView2)
        val btnterm = findViewById<TextView>(R.id.textView3)
        val btnprofile = findViewById<TextView>(R.id.textView)
        val btnlogout = findViewById<TextView>(R.id.textView4)

//        btnarrow.setOnClickListener {
//            val arr  = Intent(this,MainActivity::class.java)
//            startActivity(arr)
//        }

        btnslot.setOnClickListener {
            val btnslots = Intent(this,Booking::class.java)
            startActivity(btnslots)
        }

        btnterm.setOnClickListener {
            val btnterms = Intent(this,Terms_and_conditions::class.java)
            startActivity(btnterms)
        }

        btnprofile.setOnClickListener {

            val intent = Intent(this,User_Profile::class.java)
            startActivity(intent)

        }

        btnlogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}