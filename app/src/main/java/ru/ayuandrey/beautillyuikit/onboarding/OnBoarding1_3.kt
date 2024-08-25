package ru.ayuandrey.beautillyuikit.onboarding

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.ayuandrey.beautillyuikit.MainActivity
import ru.ayuandrey.beautillyuikit.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoarding1_3(
    navController: NavController,
    context: MainActivity
) {
    val pagerState = rememberPagerState(pageCount = { //подниманием состояние в функцию навигации
        3
    })
    val myPage = listOf(
        OnBoardingPage(image = R.drawable.image, title = "Best Stylist For You", description = "Styling your appearance according to your lifestyle"),
        OnBoardingPage(image = R.drawable.image2, title = "Meet Our Specialists", description = "There are many best stylists from all the best salons ever"),
        OnBoardingPage(image = R.drawable.image3, title = "Find The Best Service", description = "There are various services from the best salons that have become our partners.")
    )
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        PageOnBoarding(
            context = context,
            navController = navController,
            pagerState = pagerState,
            imageOnBoarding = myPage[pagerState.currentPage].image,
            textTitle = myPage[pagerState.currentPage].title,
            textDescription = myPage[pagerState.currentPage].description,
        )
    }
    Row(
        Modifier
            .wrapContentHeight()       //высота содержимого обертки
            .fillMaxSize()
            .padding(bottom = 201.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color(0xFFF98600) else Color.White
            val width = animateDpAsState(
                targetValue = if (pagerState.currentPage == iteration) 30.dp else 8.dp,
                label = ""
            )
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .height(8.dp)
                    .width(width.value)
            )
        }
    }
}



