package ru.ayuandrey.beautillyuikit

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.OverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.ayuandrey.beautillyuikit.ui.theme.BeautillyUiKitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()                      //расширяет верх экрана/ была черная строка
        super.onCreate(savedInstanceState)
//        var isChecking = true                          //это было к заставке / пока не актуально
//        lifecycleScope.launch {
//            delay(3000)
//            isChecking = false
//        }
//        installSplashScreen().apply {
//            setKeepOnScreenCondition {
//                isChecking
//            }
//        }




//        window.decorView.apply {
//            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
//        }  //при запуске активити не показвается строка состояния и панель навигации пока не нажмешь на экран

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS) //делает прозрачным статус бар и панель навигации
        setContent {
            BeautillyUiKitTheme {
                // A surface container using the 'background' color from the theme
                Surface(                                                            //поверхность
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Navigation()
                    //SplashScreen()
                    //Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ЯНАСАПАС"
        )
    }

}

@Composable
fun SplashScreen(navController: NavController) {
//    val scale = remember {                    //эффект увеличения который не актуален так как размер фиксированный
//        Animatable(0f)
//    }



    LaunchedEffect(key1 = true) {
        delay(3000L)

        navController.navigate("onBoarding1")
    }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF156778)),
            contentAlignment = Alignment.Center,
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .width(157.dp)
                    .height(65.dp)
            )
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("onBoarding1") {
            OnBoarding1()
        }
        composable("onBoarding1") {
            OnBoarding1()
        }
    }
}

@Composable
fun OnBoarding1() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "OnBoarding1",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview(

) {
    BeautillyUiKitTheme {
        OnBoarding1()
    }
}