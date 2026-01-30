package ru.sicampus.bootcamp2026.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp

import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ProfileField(
    label: String,
    value: String,
    isEdistable: Boolean,
    leadingIcon: ImageVector? = null
){
    var text by remember { mutableStateOf(value) }
    OutlinedTextField(
        value = text,
        onValueChange =  {text = it},
        label = {
            Text(label)
        },
        leadingIcon = if (leadingIcon != null) {
            {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        } else null,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Black,
            unfocusedTextColor = Black,
            disabledTextColor = Black,
            disabledContainerColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = if (isEdistable) Color.Blue else Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
            ),
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    )

}
