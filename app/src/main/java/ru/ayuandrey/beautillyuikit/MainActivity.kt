package ru.ayuandrey.beautillyuikit


import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import ru.ayuandrey.beautillyuikit.Constants.HEIGHT_44
import ru.ayuandrey.beautillyuikit.ui.theme.BeautillyUiKitTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()                      //расширяет верх экрана/ была черная строка
        super.onCreate(savedInstanceState)
            //installSplashScreen()
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS) //делает прозрачным статус бар и панель навигации
        setContent {
            BeautillyUiKitTheme {
                Surface(                                                            //поверхность
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Navigation(context = this@MainActivity)
                }
            }
        }
    }
}





@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 19.dp)
    ) {
        var text by remember { mutableStateOf("") }
        var textEmail by remember { mutableStateOf("") }
        var passwordVisibility by remember {
            mutableStateOf(false)
        }
        val icon = if(passwordVisibility)
            painterResource(id = R.drawable.vis)
        else
            painterResource(id = R.drawable.visibility_off)
        Spacer(modifier = Modifier.height(88.dp))
        Text(
            text = "Welcome back,",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
            )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Glad to meet you again!, please login to use the app.",
            color = Color(0xFF50555C),
            style = MaterialTheme.typography.bodyMedium
            )
        Spacer(modifier = Modifier.height(118.dp))
        OutlinedTextField(
            value = textEmail,
            onValueChange = { textEmail = it },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            placeholder = {
                Text(
                    text = "Email",
                    color = Color(0xFFADB3BC)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 24.dp, end = 16.dp),
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xff156778),
                unfocusedContainerColor = Color(0xffF0F3F6),
                cursorColor = Color(0xff156778),
                unfocusedLeadingIconColor = Color(0xFFADB3BC),
                focusedLeadingIconColor = Color(0xff156778),
                unfocusedTrailingIconColor = Color(0xFFADB3BC),
                focusedTrailingIconColor = Color(0xff156778),
                focusedBorderColor = Color(0xff156778),
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            placeholder = {
                Text(
                    text = "Password",
                    color = Color(0xFFADB3BC)
                    )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 24.dp, end = 16.dp),
                    )
            },
            trailingIcon = {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .clickable {
                            passwordVisibility = !passwordVisibility
                        }
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color(0xff156778),
                unfocusedContainerColor = Color(0xffF0F3F6),
                cursorColor = Color(0xff156778),
                unfocusedLeadingIconColor = Color(0xFFADB3BC),
                focusedLeadingIconColor = Color(0xff156778),
                unfocusedTrailingIconColor = Color(0xFFADB3BC),
                focusedTrailingIconColor = Color(0xff156778),
                focusedBorderColor = Color(0xff156778),
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Forgot password?",
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xff156778),
            textAlign = TextAlign.Right,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(108.dp))
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(16.dp)
        ) {
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Canvas(
                modifier = Modifier
                    .weight(0.5f)
                    .align(Alignment.CenterVertically)
            ) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                drawLine(
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = canvasWidth, y = 0f),
                    strokeWidth = 2f,
                    color = Color(0xff50555C)
                )
            }
            Text(
                    text = "or",
            modifier = Modifier
                .padding(horizontal = 34.dp)
                .align(Alignment.CenterVertically),
            color = Color(0xff50555C),
            style = MaterialTheme.typography.bodyLarge
            )
            Canvas(
                modifier = Modifier
                    .weight(0.5f)
                    .align(Alignment.CenterVertically)
            ) {
                drawLine(
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    strokeWidth = 2f,
                    color = Color(0xff50555C)
                )
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            border = BorderStroke(width = 1.dp, color = Color(0xff156778))
        ) {
            Image(
                painter = painterResource(id = R.drawable.icongoogle),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
            )
            Text(
                text = "   Sign In with Google",
                color = Color(0xFF156778),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.height(47.dp))
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Don’t have an account?",
                color = Color(0xff50555C),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = " Join Now",
                modifier = Modifier.clickable {
                    TODO()
                },
                color = Color(0xff156778),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(84.dp))
        }






    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview(
    modifier : Modifier = Modifier.fillMaxSize()
) {
    BeautillyUiKitTheme {
        Login()
    }
}









