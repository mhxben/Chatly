package com.example.chatly

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.chatly.component.*
import com.example.chatly.ui.theme.SpacerColumn
import com.example.chatly.ui.theme.staticColumn
import com.example.chatly.component.models.OutlinedTextFieldClass

@Composable
fun LoginPage(navigator: NavigationHelper) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var context = LocalContext.current

    Column(Modifier.staticColumn(),
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center) {

        AppImage(R.drawable.logo1 , "App Logo" )

        SpacerColumn()

        PrimaryText("Welcome to Chatly" , color = colorResource( id = R.color.primary ))

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

        AppButton("Login" , onClick = {
            when {
                email.isEmpty() && password.isEmpty() ->
                    Toast.makeText(context, "All fields are empty, please fill them", Toast.LENGTH_LONG).show()

                email.isEmpty() ->
                    Toast.makeText(context, "Enter email", Toast.LENGTH_LONG).show()

                password.isEmpty() ->
                    Toast.makeText(context, "Enter your password", Toast.LENGTH_LONG).show()
            }
        },)

        SpacerColumn()

        Row {
            SecondText("Don't have an account ?" , colorResource(id = R.color.black))
            SecondText(" Sign Up" , colorResource(id = R.color.primary) , modifier = Modifier.clickable {navigator.navigateToSignUp()})
        }
    }
}

