package com.pablo.miniactv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var messageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gotoByeScreenButton = findViewById<Button>(R.id.button)
        val textInputBye = findViewById<EditText>(R.id.textInputEditText)
        val numberInput = findViewById<EditText>(R.id.editTextNumber)

        messageTextView = findViewById(R.id.message)
        gotoByeScreenButton.setOnClickListener{
            val activity_2 = Intent(this, Activity2::class.java)
            // Put extra String and ints
            activity_2.putExtra("BYE_TEXT", textInputBye.getText().toString())
            val number: Int = Integer.parseInt(numberInput.getText().toString())
            activity_2.putExtra("NUMBER_BYE", number)
            startActivityForResult(activity_2, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==  2 && resultCode == RESULT_OK && data != null) {
            val message = data.getStringExtra("RESULT")
            messageTextView.setText(message)
        }

    }
}