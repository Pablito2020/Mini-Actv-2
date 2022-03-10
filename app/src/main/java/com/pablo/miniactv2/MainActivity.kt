package com.pablo.miniactv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

class MainActivity : AppCompatActivity() {

    private lateinit var messageTextView: TextView

    val getContent = registerForActivityResult(StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            val message = it.data?.getStringExtra(RESULT)
            messageTextView.text = message
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gotoByeScreenButton = findViewById<Button>(R.id.button)
        val textInputBye = findViewById<EditText>(R.id.textInputEditText)
        val numberInput = findViewById<EditText>(R.id.editTextNumber)

        messageTextView = findViewById(R.id.message)
        gotoByeScreenButton.setOnClickListener{
            val activity2 = Intent(this, Activity2::class.java)
            activity2.putExtra(TEXT, textInputBye.getText().toString())
            val number: Int = Integer.parseInt(numberInput.getText().toString())
            activity2.putExtra(NUMBER, number)
            getContent.launch(activity2)
        }
    }
}