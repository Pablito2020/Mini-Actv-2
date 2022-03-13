package com.pablo.miniactv2.validator

import android.content.Context
import com.pablo.miniactv2.R

class MessageValidator(val message: String, val context: Context): InputValidator {

    private val BYE_KEYWORD = context.getString(R.string.bye_keyword)

    override fun getData(): ValidatorData {
        if (message.isEmpty())
            return ValidatorData(isValid = false, errorMessage = context.getString(R.string.error_message_empty))
        if (!message.lowercase().contains(BYE_KEYWORD))
            return ValidatorData(isValid = false, errorMessage = context.getString(R.string.error_message_include_bye))
        return ValidatorData(isValid = true, errorMessage = "")
    }

}