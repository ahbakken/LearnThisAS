package com.example.learnthis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnthis.ui.theme.LearnThisTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnThisTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CompletePage()
                }
            }
        }
    }
}

@Composable
fun IntroCard(
        name : String,
        title: String,
        modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.contacticon)
    Column (
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
            ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp
        )
    }
}
@Composable
fun ContactLine(text: String, @DrawableRes icon: Int) {
    Row (
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.weight(0.2f)
        )
        Text (
            text = text,
            fontSize = 20.sp,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f).padding(10.dp)
        )
    }
}

@Composable
fun ContactCard (
    number: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ContactLine(number, R.drawable.phonelogo)
        ContactLine(email, R.drawable.emaillogo)
        ContactLine(socialMedia, R.drawable.atsignlogopng)
    }



}

@Composable
fun CompletePage() {
    Column (Modifier.fillMaxWidth().background(color = Color.LightGray)) {
        IntroCard(
                name = "Astrid Bakken",
                title = "Developer",
                modifier = Modifier.weight(1f)
            )
        ContactCard(
            number = "+47 41662634",
            socialMedia = "@ahbakken",
            email = "ahobakken@gmail.com",
            modifier = Modifier.weight(1f)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    LearnThisTheme {
        CompletePage()
    }
}

