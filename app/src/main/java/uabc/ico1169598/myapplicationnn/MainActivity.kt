package uabc.ico1169598.myapplicationnn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uabc.ico1169598.myapplicationnn.ui.theme.MyApplicationnnTheme
import uabc.ico1169598.myapplicationnn.ui.theme.SecondActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationnnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent(
                        navigateToSecondActivity = {
                            executeExplicitIntent()
                        },
                        openWebPage = {
                            executeImplicitIntent()
                        }
                    )
                }
            }
        }
    }

    private fun executeExplicitIntent() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    private fun executeImplicitIntent() {
        val url = "https://www.google.com"
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
        }
        startActivity(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationnnTheme {
        Greeting("Android")
    }
}

@Composable
fun NavigateToSecondActivityButton(
    navigateToSecondActivity: () -> Unit = {}
) {
    Button(onClick = navigateToSecondActivity) {
        Text("Navigate to second activity")
    }
}

@Composable
fun MainContent(
    navigateToSecondActivity: () -> Unit = {},
    openWebPage: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavigateToSecondActivityButton(
            navigateToSecondActivity = navigateToSecondActivity
        )
        Spacer(modifier = Modifier.height(16.dp))
        OpenWebPageButton(
            openWebPage = openWebPage
        )
    }
}

@Composable
fun OpenWebPageButton(openWebPage: () -> Unit = {}) {
    Button(onClick = openWebPage) {
        Text(text = ("Open Web Page"))
    }
}