package com.example.chatly.View

import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatly.R
import com.example.chatly.View.component.*
import com.example.chatly.ui.theme.SpacerColumn
import com.example.chatly.ui.theme.staticColumn
import com.example.chatly.View.component.models.OutlinedTextFieldClass
import com.example.chatly.ViewModel.LoginViewModel

@Composable
fun LoginPage(navigator: NavigationHelper , viewModel : LoginViewModel = viewModel()) {

    var context = LocalContext.current

    Column(Modifier.staticColumn(),
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center) {

        AppImage(R.drawable.logo1, "App Logo" )

        SpacerColumn()

        PrimaryText("Welcome to Chatly" , color = colorResource( id = R.color.primary))

        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Email",
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                keyboardType = KeyboardType.Email
            )
        )
        SpacerColumn()
        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Password",
                value = viewModel.password,
                onValueChange = { viewModel.password = it },
                keyboardType = KeyboardType.Password
            )
        )
        SpacerColumn()

        AppButton("Login" , onClick = {
            val loginValidationMessage = viewModel.loginValidation()
            if (loginValidationMessage != null) {
                Toast.makeText(context, loginValidationMessage, Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "Login successful", Toast.LENGTH_LONG).show()
                navigator.navigateToHomePage()
            }
        },)

        SpacerColumn()

        Row {
            SecondText("Don't have an account ?" , colorResource(id = R.color.black))
            SecondText(" Sign Up" , colorResource(id = R.color.primary) , modifier = Modifier.clickable {navigator.navigateToSignUp()})
        }
    }
}

