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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    BannerImage()
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
fun BannerImage() {
    val image = painterResource(R.drawable.bg_compose_background)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArticleText(title: String, part_1: String, part_2: String) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .padding(16.dp)
        )
        Text(
            text = part_1,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .padding(start = 16.dp, end = 16.dp)

        )
        Text(
            text = part_2,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
                .padding(16.dp)
        )
    }
}

@Composable
fun ArticlePage(title: String, part_1: String, part_2: String) {
    Column {
        BannerImage()
        ArticleText(
            title = title,
            part_1 = part_1,
            part_2 = part_2
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    LearnThisTheme {
        ArticlePage(
            stringResource(R.string.article_title),
            stringResource(R.string.part_1),
            stringResource(R.string.part_2)
        )
    }
}

