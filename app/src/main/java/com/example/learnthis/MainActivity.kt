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
                    BannerImage()
                }
            }
        }
    }
}

@Composable
fun BannerImage() {
    val image = painterResource(R.drawable.ic_task_completed)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CelebrationText(taskC: String, niceW: String) {
    Column {
        Text(
            text = taskC,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = niceW,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontSize = 16.sp
        )
    }
}

@Composable
fun CompletePage(taskC: String, niceW: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BannerImage()
        CelebrationText(
            taskC = taskC,
            niceW = niceW
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    LearnThisTheme {
        CompletePage(
            stringResource(R.string.task_complete),
            stringResource(R.string.nice_work)
            )
    }
}

