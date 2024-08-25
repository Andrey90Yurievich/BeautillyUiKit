package ru.ayuandrey.beautillyuikit

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.ayuandrey.beautillyuikit.onboarding.OnBoarding1_3
import ru.ayuandrey.beautillyuikit.onboarding.OnBoarding4

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navigation(context: MainActivity) {
    val navController = rememberNavController()





    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController, context = context)
        }
        composable("onBoarding1") {
            OnBoarding1_3(navController = navController, context = context)
        }
        composable("onBoarding4") {
            OnBoarding4(navController = navController)
        }
        composable("Login") {
            Login()
        }
    }
}