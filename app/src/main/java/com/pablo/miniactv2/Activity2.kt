package com.pablo.miniactv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        execute()
    }

    private fun execute() {
        val result = getResultFromIntent()
        setUpButton(result)
        setUpTextView(result)
    }

    private fun getResultFromIntent(): String {
        val number = intent.getIntExtra(NUMBER_KEY, DEFAULT_NUMBER)
        var textValue = intent.getStringExtra(TEXT_KEY)
        textValue = textValue!!.repeat(number)
        textValue = textValue.take(MAX_LENGTH_RESULT)
        return textValue
    }

    private fun setUpButton(result: String) {
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra(RESULT_KEY, result)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun setUpTextView(result: String) {
        val textView = findViewById<TextView>(R.id.result)
        textView.text = result
    }

}