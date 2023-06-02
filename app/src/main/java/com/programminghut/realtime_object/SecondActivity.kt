package com.programminghut.realtime_object

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)

        val button1 = findViewById<Button>(R.id.butt)
        button1.setOnClickListener {
            val intent =  Intent(this, Detection::class.java)
            startActivity(intent)
        }
        val button2 =findViewById<Button>(R.id.button3)
        button2.setOnClickListener {
            val intent2 = Intent(this,ScanningActivity::class.java)
            startActivity(intent2)
        }
    }
}
