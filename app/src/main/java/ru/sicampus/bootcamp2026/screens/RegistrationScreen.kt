package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.sicampus.bootcamp2026.Navigation.Routes
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun RegistrationScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleHeader("Регистрация")

        Spacer(modifier = Modifier.height(50.dp))

        AuthField("ФИО") {
            Text("Иванов Иван Иванович", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(25.dp))

        AuthField("Электронная почта") {
            Text("example@gmail.com", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(25.dp))

        AuthField("Пароль") {

        }

        Spacer(modifier = Modifier.height(50.dp))

        AuthButton("Зарегистрироваться") {

        }

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Text(
                text = "Уже есть аккаунт? ",
                fontSize = 16.sp
            )
            RefText(
                text = "Авторизуйтесь",
                onClick = {
                    navHostController.navigate(Routes.Auth.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    AndroidBootcamp2026FrontendTheme {
//        RegistrationScreen()
    }
}