package com.example.prootp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class SignupPage : AppCompatActivity() {

    lateinit var dateEdt: EditText

    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val signupButton = findViewById<Button>(R.id.signUpbtn)
        val etname = findViewById<EditText>(R.id.etname)
        val etbday = findViewById<EditText>(R.id.etbday)
        val etphone = findViewById<EditText>(R.id.etphone)
        val etmail = findViewById<EditText>(R.id.etmail)


        signupButton.setOnClickListener {
            val name = etname.text.toString()
            val bday = etbday.text.toString()
            val phone = etphone.text.toString()
            val mail = etmail.text.toString()

            val user = User(name,bday,phone,mail)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(phone).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                etbday.text?.clear()
                etphone.text?.clear()
                etmail.text?.clear()
                Toast.makeText(this,"User Registered", Toast.LENGTH_SHORT).show()

                val intent = Intent(this,HomeAvtivity::class.java)
                startActivity(intent)

            }.addOnSuccessListener {
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }



        dateEdt = findViewById(R.id.etbday)
        dateEdt.setOnClickListener {

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(

                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dateEdt.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
}