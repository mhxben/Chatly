package com.example.chatly.ViewModel

import com.example.chatly.Model.User
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    var user by mutableStateOf(User("","",""))
    var confirmPassword by mutableStateOf("")

    fun validationOfInput() :String? {
        return when {
            user.fullName.isBlank()&&
            user.email.isBlank()&&
            user.password.isBlank()&&
            confirmPassword.isBlank() -> "Please fill all the fields"

            user.email.isBlank() -> "Please fill an email address"
            user.password.isBlank() -> "Please fill an password"
            confirmPassword.isBlank() -> "Please fill an confirmPassword"

            user.password != confirmPassword -> "Passwords do not match"
            else -> null

        }
    }

}