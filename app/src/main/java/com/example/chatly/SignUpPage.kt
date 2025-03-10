package com.example.chatly

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatly.component.*
import com.example.chatly.component.models.OutlinedTextFieldClass
import com.example.chatly.ui.theme.SpacerColumn
import com.example.chatly.ui.theme.staticColumn

@Composable
fun SignUpPage(navigator : NavigationHelper) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var context = LocalContext.current

    Column(
        Modifier.staticColumn().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center) {

        AppImage(R.drawable.logo1 , "App Logo" )

        SpacerColumn()

        PrimaryText("Create Account" , color = colorResource( id = R.color.primary ))
        SpacerColumn()
        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Full Name",
                value = fullName,
                onValueChange = { fullName = it },
                keyboardType = KeyboardType.Text
            )
        )
        SpacerColumn()

        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email
            )
        )
        SpacerColumn()

        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                keyboardType = KeyboardType.Password
            )
        )
        SpacerColumn()
        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Confirm Password",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                keyboardType = KeyboardType.Password
            )
        )
        SpacerColumn()

        AppButton("Create Account" , onClick = {
            when {
                fullName.isEmpty() && email.isEmpty() && password.isEmpty() && confirmPassword.isEmpty() ->
                    Toast.makeText(context, "All fields are empty, please fill them", Toast.LENGTH_LONG).show()

                fullName.isEmpty() ->
                    Toast.makeText(context, "Enter your full name", Toast.LENGTH_LONG).show()

                email.isEmpty() ->
                    Toast.makeText(context, "Enter email", Toast.LENGTH_LONG).show()

                password.isEmpty() ->
                    Toast.makeText(context, "Enter your password", Toast.LENGTH_LONG).show()

                confirmPassword.isEmpty() ->
                    Toast.makeText(context, "Confirm your password", Toast.LENGTH_LONG).show()

                password != confirmPassword ->
                    Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG).show()

                else ->
                    Toast.makeText(context, "Registration successful", Toast.LENGTH_LONG).show()
            }

        },)

        SpacerColumn()

        Row {
            SecondText("Have an account ?" , colorResource(id = R.color.black))
            SecondText(" Sign In" , colorResource(id = R.color.primary) , modifier = Modifier.clickable { navigator.navigateToLogin() })
        }
    }
}
