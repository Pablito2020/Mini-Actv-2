package com.pablo.miniactv2.validator

import android.content.Context
import com.pablo.miniactv2.R

class IntNumberValidator(val number: String, val context: Context): InputValidator {

    override fun getData(): ValidatorData {
        try {
            val number = Integer.parseInt(number)
            if (number <= 0)
                return ValidatorData(isValid = false, errorMessage = context.getString(R.string.error_number_0))
            return ValidatorData( isValid = true, errorMessage = "")
        } catch (ex: Exception) {
            return ValidatorData(isValid = false, errorMessage = context.getString(R.string.error_number_empty))
        }
    }

}