package com.example.chatly.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun loginValidation () : String? {
        return when {
            email.isBlank() && password.isBlank() -> "Please fill your fields"
            email.isBlank() -> "Please fill your email"
            password.isBlank() -> "Please fill your password"
            else -> null
        }
    }
}