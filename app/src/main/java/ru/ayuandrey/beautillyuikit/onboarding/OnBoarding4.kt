package ru.ayuandrey.beautillyuikit.onboarding

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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import ru.ayuandrey.beautillyuikit.R


@Composable
fun OnBoarding4(navController: NavHostController) {
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
        Image(
            painter = painterResource(id = R.drawable.image_5),
            contentDescription = "OnBoarding4",
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
                text = "Let’s Join with Us",
                style  = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 44.dp),
                text = "Find and book Beauty, Salon, Barber and Spa services anywhere, anytime",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(44.dp))
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icongoogle),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = "   Join with Google",
                    color = Color(0xFF156778),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate("Login")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_email), contentDescription = null)
                Text(text = "   Join with Email",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
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
