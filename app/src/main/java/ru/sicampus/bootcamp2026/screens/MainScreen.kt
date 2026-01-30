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
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.Navigation.Routes
import ru.sicampus.bootcamp2026.components.MainField

@Composable
fun MainScreen(navController: NavController) {
    val cyanColor = Color(0xFF80F9F9)
    val lightGray = Color(0xFFE0E0E0)

    var meetingName by remember { mutableStateOf("") }
    var meetingDate by remember { mutableStateOf("") }
    var meetingTime by remember { mutableStateOf("") }
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(cyanColor)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = { navController.navigate(Routes.Profile.route) },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Профиль", modifier = Modifier.size(32.dp))
                }
                IconButton(
                    onClick = {
                        navController.navigate(Routes.Auth.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Icon(Icons.Default.Logout, contentDescription = "Выход", modifier = Modifier.size(32.dp))
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = lightGray,
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Routes.Invitations.route) },
                    icon = { Icon(Icons.Default.Mail, contentDescription = null) },
                    label = { Text("Приглашения") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color(0xFF00C2FF)) },
                    label = { Text("Главная", color = Color(0xFF00C2FF)) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Routes.Schedule.route) },
                    icon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                    label = { Text("Расписание") }
                )
            }
        }
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

            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Название встречи", fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp, bottom = 4.dp))
                MainField(
                    value = meetingName,
                    onValueChange = { meetingName = it },
                    placeholder = ""
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Дата встречи", fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp, bottom = 4.dp))
                    MainField(
                        value = meetingDate,
                        onValueChange = { meetingDate = it },
                        trailingIcon = Icons.Default.DateRange
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Время встречи", fontSize = 14.sp, modifier = Modifier.padding(start = 12.dp, bottom = 4.dp))
                    MainField(
                        value = meetingTime,
                        onValueChange = { meetingTime = it },
                        placeholder = "HH:OO"
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Приглашения",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(12.dp))

            MainField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = "Поиск",
                trailingIcon = Icons.Default.Search
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

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = cyanColor),
                shape = RoundedCornerShape(15.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color.Black)
            ) {
                Text("Отправить приглашения", color = Color.Black, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController())
}
