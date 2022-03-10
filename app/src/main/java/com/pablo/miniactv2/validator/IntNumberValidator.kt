package com.pablo.miniactv2.validator

class IntNumberValidator(val number: String): InputValidator {

    override fun getData(): ValidatorData {
        try {
            Integer.parseInt(number)
            return ValidatorData( isValid = true, errorMessage = "")
        } catch (ex: Exception) {
            return ValidatorData(isValid = false, errorMessage = "Number shouldn't be empty!")
        }
    }

}