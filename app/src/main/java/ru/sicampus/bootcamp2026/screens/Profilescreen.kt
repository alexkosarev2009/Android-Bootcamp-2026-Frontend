package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.components.ProfileField

import ru.sicampus.bootcamp2026.Navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val cyanColor = Color(0xFF80F9F9)
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
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад", modifier = Modifier.size(32.dp))
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
                containerColor = Color(0xFFE0E0E0),
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Routes.Invitations.route) },
                    icon = { Icon(Icons.Default.Mail, contentDescription = null) },
                    label = { Text("Приглашения") }
                )
                NavigationBarItem(
                    selected = true,
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
            Spacer(modifier = Modifier.height(20.dp))
            
            Text(
                text = "Профиль",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(4.dp, blueColor, CircleShape)
                        .background(Color.LightGray)
                )
                
                Surface(
                    modifier = Modifier
                        .size(60.dp)
                        .offset(x = (-10).dp, y = (-10).dp),
                    shape = RoundedCornerShape(15.dp),
                    color = cyanColor
                ) {
                    IconButton(onClick = { /* Смена фото */ }) {
                        Icon(Icons.Default.CameraAlt, contentDescription = null, modifier = Modifier.size(35.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(45.dp),
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(1.dp, Color.Black),
                color = Color(0xFFE0E0E0)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Иванов Иван Иванович", fontSize = 16.sp)
                    Icon(Icons.Default.Edit, contentDescription = null, modifier = Modifier.size(20.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                Text("Электронная почта", color = Color.Gray, fontSize = 14.sp)
                Text("noname@design.domen", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(40.dp))
                
                Button(
                    onClick = { /* Сохранить */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = cyanColor),
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Text("Сохранить", color = Color.Black, fontSize = 18.sp)
                }
            }
            
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Preview
@Composable
fun f(){
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}