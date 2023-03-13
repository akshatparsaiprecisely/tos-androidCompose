package com.example.tos_androidcompose.ui.notifiction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.ui.Modifier
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.common.AppBar

class NotificationScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                AppBar(
                    Icons.Default.Clear,
                    title = getString(R.string.notification),
                    onRefresh = { /*TODO*/ }
                ) { onBackPressed() }
            }
        }
    }
}