package com.example.androidproject

import java.util.regex.Pattern

fun isNameValid(text: String): ValidResult {
    return when {
        text.isBlank() -> ValidResult.Invalid(R.string.error_empty_text)
        text.length < 3 || text.length > 255 -> ValidResult.Invalid(R.string.error_length_text)
        else -> ValidResult.Valid
    }
}

fun isValidPassword(passwordString: String): ValidResult {
    val patternPassword = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$")
    return when {

        passwordString.isBlank() -> ValidResult.Invalid(R.string.error_empty_text)
        passwordString.length < 3 || passwordString.length > 255 -> ValidResult.Invalid(R.string.error_length_text)
        patternPassword.matcher(passwordString)
            .matches() -> ValidResult.Invalid(R.string.error_symbols_text)

        else -> ValidResult.Valid
    }
}

fun isEmailValid(emailString: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(emailString).matches()
}

sealed class ValidResult {

    data object Valid : ValidResult()
    data class Invalid(val errorRes: Int) : ValidResult()

}