package ru.musindev.ochko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.musindev.ochko.ui.screen.SettingsScreen
import ru.musindev.ochko.ui.theme.OchkoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OchkoTheme {
                SettingsScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

//    Column(modifier = Modifier.fillMaxSize()) {
//        // Карты на столе
//        DynamicOverlappingCards(
//            cardResIds = listOf(
//                R.drawable.img_6c,
//                R.drawable.img_6d,
//                R.drawable.img_6s
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            cardHeightDp = 100
//        )
//
//        Spacer(modifier = Modifier.weight(1f))
//
//        // Карты игрока внизу
//        DynamicOverlappingCards(
//            cardResIds = listOf(
//                R.drawable.img_as,
//                R.drawable.img_kc,
//                R.drawable.img_as,
//                R.drawable.img_9d,
//                R.drawable.img_kh
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            cardHeightDp = 120
//        )
//    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 24.dp)
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        CardFan(
//            cardResIds = listOf(
//                R.drawable.img_6c,
//                R.drawable.img_6d,
//                R.drawable.img_6d,
//                R.drawable.img_6d,
//                R.drawable.img_6d,
//                R.drawable.img_6d,
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(120.dp)
//        )
//    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OchkoTheme {
        Greeting("Android")
    }
}
