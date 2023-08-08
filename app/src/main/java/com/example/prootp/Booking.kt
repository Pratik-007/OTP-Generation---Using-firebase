package com.example.prootp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Booking : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var slotArrayList: ArrayList<Slots>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)


        myRecyclerView = findViewById(R.id.recycler)
        val btncall = findViewById<Button>(R.id.call)

        btncall.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+91 8010908425")
            startActivity(intent)

        }

        val slotsArray = arrayOf(
            "10:00 AM TO 11:00 AM",
            "11:15 AM TO 12:15 PM",
            "12:30 PM TO 01:30 PM",
            "01:45 PM TO 02:45 PM",
            "03:00 PM TO 04:00 PM",
            "04:15 PM TO 05:15 PM",
            "05:30 PM TO 06:30 PM",
            "06:45 PM TO 07:45 PM"
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        slotArrayList = arrayListOf<Slots>()

        for(index in slotsArray.indices){
            val slot = Slots(slotsArray[index])
            slotArrayList.add(slot)
        }

        myRecyclerView.adapter = MyAdapter(slotArrayList)
    }
}