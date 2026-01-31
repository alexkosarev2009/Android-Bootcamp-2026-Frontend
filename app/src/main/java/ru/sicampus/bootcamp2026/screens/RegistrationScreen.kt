package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.Navigation.Routes
import ru.sicampus.bootcamp2026.components.SimpleButton
import ru.sicampus.bootcamp2026.components.SimpleTextField
import ru.sicampus.bootcamp2026.components.RefText
import ru.sicampus.bootcamp2026.components.SimpleHeader
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun RegistrationScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Регистрация",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(50.dp))

        SimpleTextField("ФИО",
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(MaterialTheme
                        .colorScheme
                        .onBackground)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii)
        )

        Spacer(modifier = Modifier.height(25.dp))

        SimpleTextField("Электронная почта",
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(MaterialTheme
                        .colorScheme
                        .onBackground)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(25.dp))

        SimpleTextField("Пароль",
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(MaterialTheme
                        .colorScheme
                        .onBackground)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(50.dp))

        SimpleButton("Создать аккаунт") {
            navHostController.navigate(Routes.Home.route) {
                popUpTo(Routes.Auth.route) { inclusive = true }
            }
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
                        popUpTo(Routes.Registration.route) { inclusive = true }
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
        RegistrationScreen(rememberNavController())
    }
}