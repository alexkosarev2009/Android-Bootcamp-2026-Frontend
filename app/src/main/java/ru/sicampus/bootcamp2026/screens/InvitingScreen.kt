package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.Navigation.Routes
import ru.sicampus.bootcamp2026.components.MainField

@Composable
fun InvitingScreen(navController: NavController) {
    val cyanColor = Color(0xFF80F9F9)
    val lightGray = Color(0xFFE0E0E0)
    val redColor = Color(0xFFF96060)
    val blueColor = Color(0xFF00C2FF)

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
                    selected = true,
                    onClick = {},
                    icon = { Icon(Icons.Default.Mail, contentDescription = null, tint = blueColor) },
                    label = { Text("Приглашения", color = blueColor) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Routes.Home.route) },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text("Главная") }
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
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "У вас новые приглашения",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(24.dp))
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(lightGray, RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                InvitationCard(
                    title = "Название1",
                    organizer = "Организатор1",
                    date = "17.08.2026",
                    time = "17:00",
                    cyanColor = cyanColor,
                    redColor = redColor
                )
                
                InvitationCard(
                    title = "Название2",
                    organizer = "Организатор2",
                    date = "17.08.2026",
                    time = "18:00",
                    cyanColor = cyanColor,
                    redColor = redColor
                )

                InvitationCard(
                    title = "Название3",
                    organizer = "Организатор3",
                    date = "18.08.2026",
                    time = "10:00",
                    cyanColor = cyanColor,
                    redColor = redColor
                )

                InvitationCard(
                    title = "Название4",
                    organizer = "Организатор4",
                    date = "19.08.2026",
                    time = "14:00",
                    cyanColor = cyanColor,
                    redColor = redColor
                )
                
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun InvitationCard(
    title: String,
    organizer: String,
    date: String,
    time: String,
    cyanColor: Color,
    redColor: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Medium)
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Организатор: $organizer", fontSize = 14.sp)
                Text(text = "Дата: $date", fontSize = 14.sp)
                Text(text = "Время: $time", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { /* Принять */ },
                    modifier = Modifier.weight(1f).height(45.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = cyanColor),
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text("Принять", color = Color.Black)
                }
                
                Button(
                    onClick = { /* Отклонить */ },
                    modifier = Modifier.weight(1f).height(45.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = redColor),
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text("Отклонить", color = Color.Black)
                }
            }
        }
    }
}

@Preview
@Composable
fun InvitingScreenPreview() {
    InvitingScreen(rememberNavController())
}
