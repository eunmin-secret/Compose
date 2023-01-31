package dev.project.eunmin.boxlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.project.eunmin.boxlayout.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.size(400.dp)
    ) {
        val height = 200.dp
        val width = 200.dp

        TextCell(text = "1", modifier = Modifier.size(width, height))
        TextCell(text = "2", modifier = Modifier.size(width, height))
        TextCell(text = "3", modifier = Modifier.size(width, height))
    }
}

@Composable
fun MainScreen2() {
    Box(
        modifier = Modifier.size(width = 290.dp, height = 90.dp)
    ) {
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopCenter", Modifier.align(Alignment.TopCenter))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))

        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))

        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomCenter", Modifier.align(Alignment.BottomCenter))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier, fontSize: Int = 150) {
    val cellModifier = Modifier
        .padding(4.dp)
        .border(width = 5.dp, color = Color.Black)

    Surface {
        Text(
            modifier = cellModifier.then(modifier),
            text = text,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Box(
        modifier = Modifier.size(200.dp).clip(CutCornerShape(30.dp)).background(Color.Blue)
    ) {

    }
}