package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.sicampus.bootcamp2026.Navigation.Routes
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun AuthScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleHeader("Авторизация")

        Spacer(modifier = Modifier.height(50.dp))

        AuthField(
            label = "Электронная почта"
        ) {
            Text("example@gmail.com", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(25.dp))


        AuthField(
            label = "Пароль"
        ) {
            Text("")
        }
        Spacer(modifier = Modifier.height(50.dp))

        AuthButton("Войти") {

        }

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Text(
                text = "Нет аккаунта? ",
                fontSize = 16.sp
            )
            RefText(
                text = "Зарегистрируйтесь",
                onClick = {
                    navHostController.navigate(Routes.Registration.route)
                }
            )
        }
        


    }


}

@Composable
fun AuthField(
    label: String,
    placeholder: @Composable () -> Unit
) {
    var textState by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        shape = RoundedCornerShape(15.dp),
        label = {
            Text(
                text = label,
                fontSize = 16.sp
            )
        },
        placeholder = placeholder,
        singleLine = true

    )
}

@Composable
fun AuthButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(50.dp)
            .widthIn(min = 150.dp, max = 250.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text, fontSize = 16.sp)
    }
}

@Composable
fun SimpleHeader(
    text: String
) {
    Text(
        text = text,
        fontSize = 25.sp
    )
}

@Composable
fun RefText(fontSize: TextUnit = 16.sp, text: String, onClick: () -> Unit) {
    Text(
        text = text,
        fontSize = fontSize,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.clickable(
            onClick = onClick
        ),
        textDecoration = TextDecoration.Underline,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewAuthScreen() {
    AndroidBootcamp2026FrontendTheme {
//        AuthScreen()
    }
}
