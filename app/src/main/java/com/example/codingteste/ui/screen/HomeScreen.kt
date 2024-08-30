package com.example.codingteste.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    appUiState: AppUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (appUiState) {
        is AppUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AppUiState.Success -> ResultScreen(
            mutableListOf(appUiState),
            modifier = modifier.fillMaxWidth(),


        )

        is AppUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())


    }
}