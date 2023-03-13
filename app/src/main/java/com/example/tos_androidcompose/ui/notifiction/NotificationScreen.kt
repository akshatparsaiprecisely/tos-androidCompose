package com.example.tos_androidcompose.ui.notifiction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.common.AppBar
import com.example.tos_androidcompose.ui.model.projects.Project
import com.example.tos_androidcompose.ui.theme.colorPrimary
import com.example.tos_androidcompose.ui.viewholder.ProjectListViewHolder

class NotificationScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                val items = mutableListOf<Project>()
                AppBar(
                    Icons.Default.Clear,
                    title = getString(R.string.notification),
                    onRefresh = { /*TODO*/ }
                ) { onBackPressed() }
                ProjectListViewHolder(items, onClick = {})
                if (items.size == 0) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Column(modifier = Modifier.align(Alignment.Center)) {
                            Text(text = stringResource(id = R.string.no_notification_found), fontSize = 27.sp, color = colorPrimary)
                            Text(text = stringResource(id = R.string.no_notification_msg), fontSize = 14.sp, color = colorPrimary)
                        }
                    }
                }
            }
        }
    }
}