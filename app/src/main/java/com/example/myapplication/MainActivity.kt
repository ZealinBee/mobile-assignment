package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost( navController, startDestination="greeting" ){
        composable("greeting"){ Greeting("Android", navController) }
        composable("daily"){ Daily(navController) }
    }
}


@Composable
fun Greeting(name: String, navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .background(Color.LightGray),
        horizontalAlignment =  Alignment.CenterHorizontally

    ) {
        Header()
        Text(
            text = stringResource(R.string.partly_cloudy),
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W500,
                color = Color.Blue
            )
        )
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "25C",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.W500,
                    color = Color.Black
                )
            )
            val painter = painterResource(id = R.drawable.partly_cloud)
            Image(
                painter = painter,
                contentDescription = "Partly Cloudy Image",
                modifier = Modifier
                    .size(150.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )
        }

        Row {
            Button(onClick = { navController.navigate("daily") }) {
                Text(text = "BUTTON")
            }
        }
    }
}

