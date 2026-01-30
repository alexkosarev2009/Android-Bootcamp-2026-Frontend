package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.Navigation.NavBar
import ru.sicampus.bootcamp2026.Navigation.Routes
import ru.sicampus.bootcamp2026.components.SimpleButton
import ru.sicampus.bootcamp2026.components.SimpleTextField

@Composable
fun MainScreen(navController: NavHostController) {
    val cyanColor = Color(0xFF80F9F9)
    val lightGray = Color(0xFFE0E0E0)

    Scaffold(
        bottomBar = {
            NavBar(navController = navController)
        },
        modifier = Modifier
            .statusBarsPadding()
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Создание встречи",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(20.dp))

            SimpleTextField(
                label = "Название встречи",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier) {
                SimpleTextField(
                    label = "Дата встречи",
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = ""
                        )
                    }
                )
                SimpleTextField(
                    label = "Время встречи",
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Приглашения",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(12.dp))

            SimpleTextField(
                label = "Поиск",
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Список приглашённых", fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp, bottom = 4.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(lightGray, RoundedCornerShape(15.dp))
                        .border(1.dp, Color.Black, RoundedCornerShape(15.dp))
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            SimpleButton(
                text = "Отправить приглашения"
            ) {

            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController())
}
