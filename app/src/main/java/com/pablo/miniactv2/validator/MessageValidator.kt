package com.pablo.miniactv2.validator

class MessageValidator(val message: String): InputValidator {

    private val BYE_KEYWORD = "bye"

    override fun getData(): ValidatorData {
        if (message.isEmpty())
            return ValidatorData(isValid = false, errorMessage = "Message can't be empty!")
        if (!message.lowercase().contains(BYE_KEYWORD))
            return ValidatorData(isValid = false, errorMessage = "Message should include bye!")
        return ValidatorData(isValid = true, errorMessage = "")
    }

}