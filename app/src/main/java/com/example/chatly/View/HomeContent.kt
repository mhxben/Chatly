package com.example.chatly.View

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.chatly.View.component.MainOutlinedTextField
import com.example.chatly.View.component.PrimaryText
import com.example.chatly.View.component.models.OutlinedTextFieldClass
import com.example.chatly.ui.theme.SpacerColumn
import com.example.chatly.ui.theme.staticColumn
import com.example.chatly.R

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }

    Column(modifier = modifier.staticColumn()){

        MainOutlinedTextField(
            params = OutlinedTextFieldClass(
                label = "Search...",
                value = searchText,
                onValueChange = { searchText = it },
                keyboardType = KeyboardType.Text
            )
        )

        SpacerColumn()

        PrimaryText("Chat" , colorResource(id = R.color.primary))

    }
}