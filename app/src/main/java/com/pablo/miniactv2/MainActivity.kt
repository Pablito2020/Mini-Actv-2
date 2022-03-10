package com.pablo.miniactv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gotoByeScreenButton = findViewById<Button>(R.id.button)
        gotoByeScreenButton.setOnClickListener{
            val activity_2 = Intent(this, Activity2::class.java)
            startActivityForResult(activity_2, 2)
        }
    }
}