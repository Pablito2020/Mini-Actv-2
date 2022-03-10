package com.pablo.miniactv2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.pablo.miniactv2.databinding.ActivityMainBinding
import com.pablo.miniactv2.validator.IntNumberValidator
import com.pablo.miniactv2.validator.MessageValidator

class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var messageInput: TextView
    private lateinit var numberInput: TextView
    private lateinit var binding: ActivityMainBinding
    private val onResultLauncher = registerForActivityResult(StartActivityForResult()) {
        if (it.resultCode == RESULT_OK)
            resultText.text = it.data!!.getStringExtra(RESULT_KEY).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTextViews()
        setUpButton()
    }

    private fun setUpTextViews() {
        messageInput = findViewById<EditText>(R.id.textInputEditText)
        numberInput = findViewById<EditText>(R.id.editTextNumber)
        resultText = findViewById(R.id.message)
        messageInput.requestFocus()
    }

    private fun setUpButton() {
        val gotoByeScreenButton = findViewById<Button>(R.id.button)
        gotoByeScreenButton.setOnClickListener { validateParametersAndLaunchIntent() }
    }

    private fun validateParametersAndLaunchIntent() {
        val integerValidator = IntNumberValidator(numberInput.text.toString())
        val messageValidator = MessageValidator(messageInput.text.toString())
        if (integerValidator.getData().isValid && messageValidator.getData().isValid)
            startNewIntent()
        else
            printInputError(integerValidator, messageValidator)
    }

    private fun startNewIntent() {
        val activity2 = Intent(this, Activity2::class.java)
        activity2.putExtra(MESSAGE_KEY, messageInput.text.toString())
        val number: Int = Integer.parseInt(numberInput.text.toString())
        activity2.putExtra(NUMBER_KEY, number)
        onResultLauncher.launch(activity2)
    }

    private fun printInputError(
        numberValidator: IntNumberValidator,
        messageValidator: MessageValidator
    ) {
        binding.editTextNumber.error =
            if (!numberValidator.getData().isValid) numberValidator.getData().errorMessage else null
        binding.textInputEditText.error =
            if (!messageValidator.getData().isValid) messageValidator.getData().errorMessage else null
    }

}