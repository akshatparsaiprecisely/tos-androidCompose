package com.example.tos_androidcompose.ui.aboutScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.Modifier
import com.example.tos_androidcompose.ui.chats.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.common.AppBar
import com.example.tos_androidcompose.ui.utils.AppConstants

class AboutScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosandroidComposeTheme {
                // A surface container using the 'background' color from the theme
                setContent {
                    Column(modifier = Modifier.fillMaxSize()) {
                        AppBar(
                            Icons.Default.Info,
                            title = AppConstants.ABOUT,
                            onRefresh = { /*TODO*/ },
                            onBackPressed = { onBackPressed() })
                    }
                }
            }
        }
    }
}