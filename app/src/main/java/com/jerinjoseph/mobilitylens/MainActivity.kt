package com.jerinjoseph.mobilitylens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jerinjoseph.mobilitylens.ui.MobilityLensScreen
import com.jerinjoseph.mobilitylens.ui.theme.MobilityLensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobilityLensTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MobilityLensScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}