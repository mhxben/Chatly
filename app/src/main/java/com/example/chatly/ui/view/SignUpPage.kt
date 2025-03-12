package com.example.chatly.ui.theme.View

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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatly.R
import com.example.chatly.View.component.*
import com.example.chatly.ui.theme.View.component.models.OutlinedTextFieldClass
import com.example.chatly.ViewModel.SignUpViewModel
import com.example.chatly.ui.theme.SpacerColumn
import com.example.chatly.ui.theme.View.component.*
import com.example.chatly.ui.theme.staticColumn

@Composable
fun SignUpPage(navigator : NavigationHelper, viewModel: SignUpViewModel = viewModel()) {

    val context = LocalContext.current

    Column(
        Modifier.staticColumn().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center) {

        AppImage(R.drawable.logo1, "App Logo" )

        SpacerColumn()

        PrimaryText("Create Account" , color = colorResource( id = R.color.primary))
        SpacerColumn()
        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Full Name",
                value = viewModel.user.fullName,
                onValueChange = { viewModel.user = viewModel.user.copy(fullName = it) },
                keyboardType = KeyboardType.Text
            )
        )
        SpacerColumn()

        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Email",
                value = viewModel.user.email,
                onValueChange = { viewModel.user = viewModel.user.copy(email = it) },
                keyboardType = KeyboardType.Email
            )
        )
        SpacerColumn()

        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Password",
                value = viewModel.user.password,
                onValueChange = { viewModel.user = viewModel.user.copy(password = it) },
                keyboardType = KeyboardType.Password
            )
        )
        SpacerColumn()
        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Confirm Password",
                value = viewModel.confirmPassword,
                onValueChange = { viewModel.confirmPassword = it },
                keyboardType = KeyboardType.Password
            )
        )
        SpacerColumn()

        AppButton("Create Account" , onClick = {
            val validationMessage = viewModel.validationOfInput()
            if (validationMessage != null) {
                Toast.makeText(context,validationMessage,Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(context,"Registration successful" , Toast.LENGTH_LONG).show()
                navigator.navigateToHomePage()
            }

        },)

        SpacerColumn()

        Row {
            SecondText("Have an account ?" , colorResource(id = R.color.black))
            SecondText(" Sign In" , colorResource(id = R.color.primary) , modifier = Modifier.clickable { navigator.navigateToLogin() })
        }
    }
}
