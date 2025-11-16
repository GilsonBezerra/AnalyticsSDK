package br.com.lithiumcode.analyticssdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import br.com.lithiumcode.analytics_sdk.AnalyticsTracker
import br.com.lithiumcode.analyticssdk.ui.theme.AnalyticsSDKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnalyticsSDKTheme() {
                Box(modifier = Modifier.fillMaxSize()) {
                    AnalyticsTracker.initialize(this@MainActivity)
                }
            }
        }
    }
}
