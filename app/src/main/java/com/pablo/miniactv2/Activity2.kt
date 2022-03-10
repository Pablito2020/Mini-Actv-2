package com.pablo.miniactv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val number = intent.getIntExtra(NUMBER, 1)
        val byeValue = intent.getStringExtra(TEXT)
        var result = ""
        if (byeValue != null) {
            result = byeValue.repeat(number)
        }
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(RESULT, result)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
        val textView = findViewById<TextView>(R.id.result)
        textView.text = result
    }
}