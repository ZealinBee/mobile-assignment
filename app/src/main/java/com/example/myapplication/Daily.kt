package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

@Composable
fun Daily(navController: NavHostController) {
    val daysOfWeek = listOf(stringResource(R.string.monday),
        stringResource(R.string.tuesday),
        stringResource(R.string.wednesday),
        stringResource(R.string.thursday), stringResource(R.string.friday),
        stringResource(R.string.saturday), stringResource(R.string.sunday)
    )
    val weatherItemList = mutableListOf<WeatherItem>()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .background(Color.LightGray),
        horizontalAlignment =  Alignment.CenterHorizontally

    ) {
        Header()

        for (day in daysOfWeek) {

            val weatherItem = WeatherItem(25.55, "$day", 92)
            weatherItemList.add(weatherItem)
        }
        LazyColumn(
            modifier = Modifier.weight(1f),
            content = {
                itemsIndexed(weatherItemList) { index, weatherItem ->
                    WeatherItemRow(weatherItem = weatherItem)
                }
            }
        )


        Button(onClick = { navController.navigate("greeting") }) {
            Text(text = stringResource(R.string.button))
        }
        

    }
}

@Composable
fun WeatherItemRow(weatherItem: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = weatherItem.description,
            modifier = Modifier.weight(1f),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${weatherItem.temperature}°C",
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}
