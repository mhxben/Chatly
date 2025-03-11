package com.example.chatly.View.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.chatly.View.component.models.OutlinedTextFieldClass

@Composable
fun MainOutlinedTextField(params : OutlinedTextFieldClass) {
    OutlinedTextField(
        value = params.value,
        onValueChange = {params.onValueChange(it)},
        label = { Text(text = params.label) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = params.keyboardType),
        visualTransformation = if (params.keyboardType == KeyboardType.Password)
            PasswordVisualTransformation()
        else
            VisualTransformation.None
    )
}
