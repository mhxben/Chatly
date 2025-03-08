package com.example.chatly.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatly.component.models.OutlinedTextFieldClass

@Composable
fun MainOutlinedTextField(params : OutlinedTextFieldClass) {
    OutlinedTextField(
        value = params.value,
        onValueChange = {params.onValueChange(it)},
        label = { Text(text = params.label) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = params.keyboardType)
    )
}
