package com.example.learnthis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnthis.ui.theme.LearnThisTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnThisTheme {
                LemonadeApp()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LemonadeApp() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var result by remember { mutableStateOf(1) }
        val imageResource = when (result) {
            1 -> R.drawable.lemon_tree
            in 2..5 -> R.drawable.lemon_squeeze
            6 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        val textResource = when (result) {
            1 -> R.string.LemonTree
            in 2..5 -> R.string.Lemon
            6 -> R.string.FullGlass
            else -> R.string.EmptyGlass
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(stringResource(textResource))
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = result.toString(),
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .clickable(
                        onClick = {
                            if (result < 6) {
                                result++
                            } else {
                                result = 0
                            }
                        }
                    )
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(7.dp))
            )
        }
    }
}
