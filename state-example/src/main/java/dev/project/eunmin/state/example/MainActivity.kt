package dev.project.eunmin.state.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.project.eunmin.state.example.ui.theme.JetpackComposeTheme

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
fun DemoScreen() {
    MyTextField()
}

@Composable
fun MyTextField() {
    val (text, setText) = remember { mutableStateOf("") }

    val onTextChange = { text: String ->
        setText(text)
    }

    TextField(
        value = text,
        onValueChange = onTextChange
    )
}

@Composable
fun FunctionA() {
    val (switch, setSwitch) = remember { mutableStateOf(true) }

    val onSwitchChange = { value: Boolean ->
        setSwitch(value)
    }

    FunctionB(switch, onSwitchChange)
}

@Composable
fun FunctionB(isAgree: Boolean, onSwitchChange: (Boolean) -> Unit) {
    Switch(checked = isAgree, onCheckedChange = onSwitchChange)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Column {
            DemoScreen()
            FunctionA()
        }
    }
}