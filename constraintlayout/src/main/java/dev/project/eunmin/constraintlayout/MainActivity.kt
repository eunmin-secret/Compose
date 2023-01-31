package dev.project.eunmin.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import dev.project.eunmin.constraintlayout.ui.theme.JetpackComposeTheme

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
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (button1, button2, button3) = createRefs()

        createVerticalChain(button1, button2, chainStyle = ChainStyle.Spread)

        val barrier = createEndBarrier(button1, button2, margin = 20.dp)

        MyButton(
            text = "Button1",
            modifier = Modifier.constrainAs(button1) {
                start.linkTo(parent.start, margin = 20.dp)
            }
        )
        MyButton(
            text = "Button2",
            modifier = Modifier.constrainAs(button2) {
                start.linkTo(parent.start, margin = 20.dp)
            }
        )
        MyButton(
            text = "Button3",
            modifier = Modifier.constrainAs(button3) {
                centerVerticallyTo(parent)
                linkTo(barrier, parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )
    }
}

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ }
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        MainScreen()
    }
}