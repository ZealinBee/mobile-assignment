package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController

@Composable
fun Daily(navController: NavHostController) {
    val daysOfWeek = listOf(stringResource(R.string.monday),
        stringResource(R.string.tuesday),
        stringResource(R.string.wednesday),
        stringResource(R.string.thursday), stringResource(R.string.friday),
        stringResource(R.string.saturday), stringResource(R.string.sunday)
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .background(Color.LightGray),
        horizontalAlignment =  Alignment.CenterHorizontally

    ) {
        Header()
        for (day in daysOfWeek) {
            Row {
                Text(text = "$day ", color = Color.Black)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "28C", color = Color.Black)
            }
        }
        Button(onClick = { navController.navigate("greeting") }) {
            Text(text = stringResource(R.string.button))
        }
    }
}