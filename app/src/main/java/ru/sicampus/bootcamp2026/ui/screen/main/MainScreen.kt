package ru.sicampus.bootcamp2026.ui.screen.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.navigation.NavBar
import ru.sicampus.bootcamp2026.navigation.Routes
import ru.sicampus.bootcamp2026.components.SimpleButton
import ru.sicampus.bootcamp2026.components.SimpleTextField

import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MainStateModel = viewModel<MainStateModel>()
) {
    val state by viewModel.uiState.collectAsState()
    
    MainScreenContent(
        state = state,
        navController = navController,
        onMeetingNameChange = viewModel::onMeetingNameChange,
        onMeetingDateChange = viewModel::onMeetingDateChange,
        onMeetingTimeChange = viewModel::onMeetingTimeChange,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onCreateMeetingClick = viewModel::onCreateMeetingClick,
        onRefresh = { viewModel.getData() }
    )
}

@Composable
private fun MainScreenContent(
    state: MainState,
    navController: NavHostController,
    onMeetingNameChange: (String) -> Unit,
    onMeetingDateChange: (String) -> Unit,
    onMeetingTimeChange: (String) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onCreateMeetingClick: () -> Unit,
    onRefresh: () -> Unit
) {
    Scaffold(
        bottomBar = {
            NavBar(navController = navController)
        },
        modifier = Modifier
            .statusBarsPadding()
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Создание встречи",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(30.dp))

                SimpleTextField(
                    value = state.meetingName,
                    onValueChange = onMeetingNameChange,
                    label = "Название встречи",
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    SimpleTextField(
                        value = state.meetingDate,
                        onValueChange = onMeetingDateChange,
                        label = "Дата встречи",
                        modifier = Modifier.fillMaxWidth(),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    SimpleTextField(
                        value = state.meetingTime,
                        onValueChange = onMeetingTimeChange,
                        label = "Время встречи",
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Приглашения",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(16.dp))

                SimpleTextField(
                    value = state.searchQuery,
                    onValueChange = onSearchQueryChange,
                    label = "Поиск",
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                SimpleButton("Создать встречу") {
                    onCreateMeetingClick()
                }
                
                Spacer(modifier = Modifier.height(24.dp))
            }

            IconButton(
                onClick = { 
                    navController.navigate(Routes.Auth.route) {
                        popUpTo(navController.graph.id) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Выход",
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(28.dp)
                )
            }

            if (state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            if (state.error != null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Ошибка: ${state.error}", color = MaterialTheme.colorScheme.error)
                        Spacer(modifier = Modifier.height(16.dp))
                        SimpleButton("Повторить") {
                            onRefresh()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreenContent(
        state = MainState(),
        navController = rememberNavController(),
        onMeetingNameChange = {},
        onMeetingDateChange = {},
        onMeetingTimeChange = {},
        onSearchQueryChange = {},
        onCreateMeetingClick = {},
        onRefresh = {}
    )
}
