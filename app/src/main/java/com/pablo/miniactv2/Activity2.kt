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
        setUpComponents()
    }

    private fun setUpComponents() {
        val result = getResultFromIntent()
        setUpButton(result)
        setUpTextView(result)
    }

    private fun getResultFromIntent(): String {
        val number = intent.getIntExtra(NUMBER_KEY, DEFAULT_NUMBER)
        val textValue = intent.getStringExtra(MESSAGE_KEY)
        return textValue!!.repeat(number)
    }

    private fun setUpButton(result: String) {
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            createIntentAndFinish(result)
        }
    }

    private fun setUpTextView(result: String) {
        val textView = findViewById<TextView>(R.id.result)
        textView.text = result
    }

    private fun createIntentAndFinish(result: String) {
        val resultIntent = Intent()
        resultIntent.putExtra(RESULT_KEY, result)
        setResult(RESULT_OK, resultIntent)
        finish()
    }

}