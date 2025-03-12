package com.example.chatly.ViewModel

import com.example.chatly.Model.LoginUser
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var loginUser by mutableStateOf(LoginUser("",""))

    fun loginValidation () : String? {
        return when {
            loginUser.email.isBlank() && loginUser.password.isBlank() -> "Please fill your fields"
            loginUser.email.isBlank() -> "Please fill your email"
            loginUser.password.isBlank() -> "Please fill your password"
            else -> null
        }
    }
}