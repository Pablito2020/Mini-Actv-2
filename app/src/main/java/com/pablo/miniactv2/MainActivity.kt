package com.pablo.miniactv2

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.pablo.miniactv2.databinding.ActivityMainBinding
import com.pablo.miniactv2.validator.IntNumberValidator
import com.pablo.miniactv2.validator.MessageValidator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val onResultLauncher = registerForActivityResult(StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            binding.message.text = it.data!!.getStringExtra(RESULT_KEY).toString()
            binding.textInputEditText.text!!.clear()
            binding.editTextNumber.text.clear()
            binding.textInputEditText.requestFocus()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textInputEditText.requestFocus()
        binding.button.setOnClickListener { validateParametersAndLaunchIntent() }
    }

    private fun validateParametersAndLaunchIntent() {
        val integerValidator = IntNumberValidator(binding.editTextNumber.text.toString(), this)
        val messageValidator = MessageValidator(binding.textInputEditText.text.toString(), this)
        if (integerValidator.getData().isValid && messageValidator.getData().isValid)
            startNewIntent()
        else
            printInputError(integerValidator, messageValidator)
    }

    private fun startNewIntent() {
        val activity2 = Intent(this, Activity2::class.java)
        activity2.putExtra(MESSAGE_KEY, binding.textInputEditText.text.toString())
        val number: Int = binding.editTextNumber.text.toString().toInt()
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