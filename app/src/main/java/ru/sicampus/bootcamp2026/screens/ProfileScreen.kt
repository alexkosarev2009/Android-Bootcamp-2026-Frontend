package ru.sicampus.bootcamp2026.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.Navigation.NavBar
import ru.sicampus.bootcamp2026.components.ChangePFP
import ru.sicampus.bootcamp2026.components.EditableField
import ru.sicampus.bootcamp2026.components.ProfilePicture
import ru.sicampus.bootcamp2026.components.SimpleButton
import ru.sicampus.bootcamp2026.components.SimpleHeader

@Composable
fun ProfileScreen(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            NavBar(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .systemBarsPadding()
                .imePadding()
                .padding(horizontal = 24.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleHeader("Профиль")

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                ProfilePicture(imageVector = Icons.Filled.Person)
                ChangePFP()

            }

            Spacer(modifier = Modifier.height(30.dp))

            EditableField(label = "ФИО", modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(25.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                Text("Электронная почта", color = Color.Gray)

                Spacer(Modifier.height(10.dp))

                Text("example@gmail.com")
            }

            Spacer(Modifier.height(50.dp))

            SimpleButton("Сохранить изменения") {

            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewProfileScreen(
) {
    ProfileScreen(rememberNavController())
}