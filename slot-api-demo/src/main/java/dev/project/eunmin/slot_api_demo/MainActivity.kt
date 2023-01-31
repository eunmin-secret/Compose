package dev.project.eunmin.slot_api_demo

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.project.eunmin.slot_api_demo.ui.theme.JetpackComposeTheme

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
    var linearSelected by remember { mutableStateOf(true) }
    var imageSelected by remember { mutableStateOf(true) }

    val onLinearClicked = { value: Boolean ->
        linearSelected = value
    }

    val onTitleClicked = { value: Boolean ->
        imageSelected = value
    }

    ScreenContent(
        linearSelected = linearSelected,
        imageSelected = imageSelected,
        onTitleClicked = onTitleClicked,
        onLinearClicked = onLinearClicked,
        titleContent = {
            if (imageSelected) {
                TitleImage(imageVector = Icons.Default.CloudDownload)
            } else {
                Text(text = "Downloading", style = MaterialTheme.typography.h3, modifier = Modifier.padding(30.dp))
            }
        },
        progressContent = {
            if (linearSelected) {
                LinearProgressIndicator(Modifier.height(40.dp))
            } else {
                CircularProgressIndicator(Modifier.size(200.dp), strokeWidth = 18.dp)
            }
        }
    )
}

@Composable
fun ScreenContent(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onTitleClicked: (Boolean) -> Unit,
    onLinearClicked: (Boolean) -> Unit,
    titleContent: @Composable () -> Unit,
    progressContent: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        titleContent()
        progressContent()
        CheckBoxes(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onTitleClicked = onTitleClicked,
            onLinearClicked = onLinearClicked
        )
    }
}

@Composable
fun CheckBoxes(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onTitleClicked: (Boolean) -> Unit,
    onLinearClicked: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = imageSelected, onCheckedChange = onTitleClicked)
        Text(text = "Image Title")
        Spacer(modifier = Modifier.width(20.dp))
        Checkbox(checked = linearSelected, onCheckedChange = onLinearClicked)
        Text(text = "Linear Progress")
    }
}

@Composable
fun TitleImage(imageVector: ImageVector) {
    Image(
        modifier = Modifier.width(150.dp).height(150.dp),
        imageVector = imageVector,
        contentDescription = "title image",
        colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant)
    )
}

@Preview(showBackground = true)
@Composable
fun DemoPreview() {
    MainScreen()
}