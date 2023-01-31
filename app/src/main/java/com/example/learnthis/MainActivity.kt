package com.example.learnthis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun ComposeQuadrant(
        title: String,
        description: String,
        backgroundColor: Color,
        modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp) //normal Modifier, big M
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun CompletePage() {
    Column (Modifier.fillMaxWidth()) {
        Row (Modifier.weight(1f)) {
            ComposeQuadrant(
                title = stringResource(R.string.textC),
                description = stringResource(R.string.textCText),
                backgroundColor = Green,
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrant(
                title = stringResource(R.string.imageC),
                description = stringResource(R.string.imageCText),
                backgroundColor = Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row (Modifier.weight(1f)) {
            ComposeQuadrant(
                title = stringResource(R.string.rowC),
                description = stringResource(R.string.rowCText),
                backgroundColor = Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrant(
                title = stringResource(R.string.comulmC),
                description = stringResource(R.string.comlumnCText),
                backgroundColor = LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    LearnThisTheme {
        CompletePage()
    }
}

