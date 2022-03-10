package com.pablo.miniactv2.validator

class IntNumberValidator(val number: String): InputValidator {

    override fun getData(): ValidatorData {
        try {
            val number = Integer.parseInt(number)
            if (number <= 0)
                return ValidatorData(isValid = false, errorMessage = "Number should be higher than 0")
            return ValidatorData( isValid = true, errorMessage = "")
        } catch (ex: Exception) {
            return ValidatorData(isValid = false, errorMessage = "Number shouldn't be empty!")
        }
    }

}