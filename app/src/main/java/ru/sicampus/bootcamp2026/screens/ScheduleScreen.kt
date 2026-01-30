package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.Navigation.NavBar

@Composable
fun ScheduleScreen(navController: NavHostController) {

    var selectedTab by remember { mutableStateOf("неделя") }

    Scaffold(
        bottomBar = {
            NavBar(navController = navController)
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
                    text = "Расписание",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(20.dp))

                // Табы
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TabItem("день", selectedTab == "день") { selectedTab = "день" }
                    TabItem("неделя", selectedTab == "неделя") { selectedTab = "неделя" }
                    TabItem("месяц", selectedTab == "месяц") { selectedTab = "месяц" }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Серая область со списком
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ScheduleCard("Название1", "Организатор1", "17.08.2026", "17:00")
                ScheduleCard("Название2", "Организатор2", "17.08.2026", "18:00")
                ScheduleCard("Название3", "Организатор3", "18.08.2026", "12:00")
                
                if (selectedTab != "день") {
                    ScheduleCard("Название4", "Организатор4", "19.08.2026", "18:00")
                    ScheduleCard("Название5", "Организатор5", "20.08.2026", "14:00")
                    ScheduleCard("Название6", "Организатор6", "21.08.2026", "16:00")
                }
                
                if (selectedTab == "месяц") {
                    ScheduleCard("Название7", "Организатор7", "25.08.2026", "10:00")
                    ScheduleCard("Название8", "Организатор8", "27.08.2026", "11:00")
                    ScheduleCard("Название9", "Организатор9", "30.08.2026", "15:00")
                }
                
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun TabItem(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp),
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
    )
}

@Composable
fun ScheduleCard(title: String, organizer: String, date: String, time: String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title, 
                fontSize = 20.sp, 
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(text = "Организатор: $organizer", fontSize = 14.sp)
            Text(text = "Дата: $date", fontSize = 14.sp)
            Text(text = "Время: $time", fontSize = 14.sp)


        }
    }
}

@Preview
@Composable
fun ScheduleScreenPreview() {
    ScheduleScreen(rememberNavController())
}
