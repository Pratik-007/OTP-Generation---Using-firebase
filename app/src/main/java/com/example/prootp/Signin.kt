package com.example.prootp
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//
//class Signin : AppCompatActivity() {
//
//    private lateinit var databaseReference: DatabaseReference
//    companion object{
//        const val KEY1 = "com.example.prootp.Signin.name"
//        const val KEY2 = "com.example.prootp.Signin.birthdate"
//        const val KEY3 = "com.example.prootp.Signin.phoneno"
//        const val KEY4 = "com.example.prootp.Signin.mail"
//    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_signin)
//
//        val signInButton = findViewById<Button>(R.id.signinbtn)
//        val etphone = findViewById<EditText>(R.id.editTextPhone)
//
//
//        signInButton.setOnClickListener {
//
//            val etphoneString = etphone.text.toString()
//            if (etphoneString.isNotEmpty()){
//                readData(etphoneString)
//
//                val intent = Intent(this,HomeAvtivity::class.java)
//                startActivity(intent)
//            }else{
//                Toast.makeText(this,"Please Enter Phone No", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//
//    }
//
//private fun readData(etphoneString: String) {
//    databaseReference = FirebaseDatabase.getInstance().getReference("Users")
//    databaseReference.child(etphoneString).get().addOnSuccessListener { dataSnapshot ->
//        if (dataSnapshot.exists()) {
//            val name = dataSnapshot.child("name").value
//            val birthdate = dataSnapshot.child("bday").value
//            val phoneno = dataSnapshot.child("phone").value
//            val mail = dataSnapshot.child("mail").value
//
//            val intentwelcome = Intent(this, User_Profile::class.java)
//            intentwelcome.putExtra(KEY1, name.toString())
//            intentwelcome.putExtra(KEY2, birthdate.toString())
//            intentwelcome.putExtra(KEY3, phoneno.toString())
//            intentwelcome.putExtra(KEY4, mail.toString())
//
//            startActivity(intentwelcome) // Start the Profile activity here
//        } else {
//            Toast.makeText(this, "Please Sign in", Toast.LENGTH_SHORT).show()
//        }
//    }.addOnFailureListener {
//        Toast.makeText(this, "Failed, Error in Database", Toast.LENGTH_SHORT).show()
//    }
//}
//
//}

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Signin : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference

//    companion object {
//        const val KEY1 = "com.example.prootp.Signin.name"
//        const val KEY2 = "com.example.prootp.Signin.birthdate"
//        const val KEY3 = "com.example.prootp.Signin.phoneno"
//        const val KEY4 = "com.example.prootp.Signin.mail"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val signInButton = findViewById<Button>(R.id.signinbtn)
        val etphone = findViewById<EditText>(R.id.editTextPhone)

        signInButton.setOnClickListener {
            val etphoneString = etphone.text.toString()
            if (etphoneString.isNotEmpty()) {
                readData(etphoneString)
                val intent = Intent(this,HomeAvtivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please Enter Phone No", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(etphoneString: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(etphoneString)

        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val name = dataSnapshot.child("name").getValue(String::class.java)
                    val birthdate = dataSnapshot.child("bday").getValue(String::class.java)
                    val phoneno = dataSnapshot.child("phone").getValue(String::class.java)
                    val mail = dataSnapshot.child("mail").getValue(String::class.java)

//                    val intentWelcome = Intent(this@Signin, User_Profile::class.java)
//                    intentWelcome.putExtra(KEY1, name)
//                    intentWelcome.putExtra(KEY2, birthdate)
//                    intentWelcome.putExtra(KEY3, phoneno)
//                    intentWelcome.putExtra(KEY4, mail)
//                    startActivity(intentWelcome)
                } else {
                    Toast.makeText(this@Signin, "Please Sign in", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@Signin, "Failed, Error in Database", Toast.LENGTH_SHORT).show()
            }
        }

        databaseReference.addListenerForSingleValueEvent(valueEventListener)
    }
}
