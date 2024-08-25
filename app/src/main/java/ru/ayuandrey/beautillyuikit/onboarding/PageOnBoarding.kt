package ru.ayuandrey.beautillyuikit.onboarding

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ru.ayuandrey.beautillyuikit.MainActivity


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageOnBoarding(
    context: MainActivity,
    navController: NavController,
    pagerState: PagerState,
    imageOnBoarding: Int,
    textTitle: String,
    textDescription: String,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val contrast = 1f // 0f..10f (1 should be default)
        val brightness = -40f // -255f..255f (0 should be default)
        val colorMatrix = floatArrayOf(
            contrast, 0f, 0f, 0f, brightness,
            0f, contrast, 0f, 0f, brightness,
            0f, 0f, contrast, 0f, brightness,
            0f, 0f, 0f, 0.85f, 0f
        )
        val scope = rememberCoroutineScope()
        val textButton = when (pagerState.currentPage) {
            0 -> "Next"
            1 -> "Next"
            2 -> "Get Started"
            else -> ""
        }
        Image(
            painter = painterResource(imageOnBoarding),
            contentDescription = "OnBoarding1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix) )
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = textTitle,
                style  = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()//fraction = 0.6f)
                    .padding(horizontal = 44.dp),
                text = textDescription,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(68.dp))
            Button(
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            onBoardingIsFinished(context = context)
                            navController.popBackStack()
                            navController.navigate("OnBoarding4")
                        } else {
                            val pageState = pagerState.currentPage + 1
                            pagerState.animateScrollToPage(pageState)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(16.dp)
            ) {
                Text(
                    text = textButton,
                    style = MaterialTheme.typography.bodyLarge
                    )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "Already have an account?",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = " Sign In",
                    modifier = Modifier.clickable {
                        TODO()
                    },
                    color = Color(0xFFF98600),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(84.dp))
            }
        }
    }
}

fun onBoardingIsFinished(context: MainActivity) {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("isFinished", true)
    editor.apply()
}