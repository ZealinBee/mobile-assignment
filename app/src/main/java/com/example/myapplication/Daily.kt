package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import java.util.Locale

@Composable
fun Daily(navController: NavHostController) {
    val daysOfWeek = listOf(stringResource(R.string.monday),
        stringResource(R.string.tuesday),
        stringResource(R.string.wednesday),
        stringResource(R.string.thursday), stringResource(R.string.friday),
        stringResource(R.string.saturday), stringResource(R.string.sunday)
    )
    val weatherItemList = mutableListOf<WeatherItem>()
    val temperatures = listOf(25.55, 21.55, 23.55, 21.50, 23.40, 20.25, 21.50)
    val descriptions = listOf("Sunny", "Sunny", "Cloudy", "Sunny", "Cloudy", "Sunny", "Cloudy")
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .background(Color.LightGray),
        horizontalAlignment =  Alignment.CenterHorizontally

    ) {
        Header()
        for (i in daysOfWeek.indices) {
            val day = daysOfWeek[i]
            val temperature = temperatures[i]
            val description = descriptions[i]
            val weatherItem = WeatherItem(temperature, description, 92, day)
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
    val painter = painterResource(
        id =
        if (weatherItem.description.toLowerCase(Locale.getDefault()) == "sunny") {
            R.drawable.images
        } else {
            R.drawable.cloudy
        }
    )

    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = weatherItem.dayOfWeek,
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
