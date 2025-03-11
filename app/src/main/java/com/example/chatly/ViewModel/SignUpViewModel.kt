package com.example.chatly.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    var fullName by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")

    fun validationOfInput() :String? {
        return when {
            fullName.isBlank()&&
            email.isBlank()&&
            password.isBlank()&&
            confirmPassword.isBlank() -> "Please fill all the fields"

            email.isBlank() -> "Please fill an email address"
            password.isBlank() -> "Please fill an password"
            confirmPassword.isBlank() -> "Please fill an confirmPassword"

            password != confirmPassword -> "Passwords do not match"
            else -> null

        }
    }

}