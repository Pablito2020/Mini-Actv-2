package com.pablo.miniactv2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pablo.miniactv2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpComponents()
    }

    private fun setUpComponents() {
        val result = getResultFromIntent()
        binding.button.setOnClickListener { createIntentAndFinish(result) }
        binding.result.text = result
    }

    private fun getResultFromIntent(): String {
        val number = intent.getIntExtra(NUMBER_KEY, DEFAULT_NUMBER)
        val textValue = intent.getStringExtra(MESSAGE_KEY)
        return textValue!!.repeat(number)
    }

    private fun createIntentAndFinish(result: String) {
        val resultIntent = Intent()
        resultIntent.putExtra(RESULT_KEY, result)
        setResult(RESULT_OK, resultIntent)
        finish()
    }

}