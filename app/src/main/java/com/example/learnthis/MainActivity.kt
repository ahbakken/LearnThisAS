package com.example.learnthis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    BirthdayGreetingWithImage(
                        stringResource(R.string.te_amo) ,
                        stringResource(R.string.love_A))
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Te amo $name!")
//}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 100.dp, start = 16.dp)
        )
        Text(
            text = from,
            fontSize = 26.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 16.dp, end = 16.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    LearnThisTheme {
        BirthdayGreetingWithImage(
            stringResource(R.string.te_amo),
            stringResource(R.string.love_A)
        )
    }
}

