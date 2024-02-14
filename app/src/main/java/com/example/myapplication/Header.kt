package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Row (modifier = Modifier
        .background(Color.Cyan)
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.Center
        ){
        Text(text = stringResource(R.string.weather_app), fontSize = 24.sp, color = Color.Black)
    }
}