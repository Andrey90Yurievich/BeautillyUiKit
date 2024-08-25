package ru.ayuandrey.beautillyuikit

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay



@Composable
fun SplashScreen(navController: NavController, context: MainActivity) {
    LaunchedEffect(key1 = true) {
        delay(2000L)


        if (onBoardingIsFinished(context = context)) {
            navController.popBackStack()
            navController.navigate("onBoarding4")
        } else {
            navController.popBackStack()
            navController.navigate("onBoarding1")
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF156778)),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .width(157.dp)
                .height(65.dp)
        )
    }
}


fun onBoardingIsFinished(context: MainActivity): Boolean {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean("isFinished", false)
}