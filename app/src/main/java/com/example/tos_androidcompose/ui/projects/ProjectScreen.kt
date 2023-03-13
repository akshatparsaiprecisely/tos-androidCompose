package com.example.tos_androidcompose.ui.projects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.Modifier
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.chats.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.common.AppBar
import com.example.tos_androidcompose.ui.model.projects.Project
import com.example.tos_androidcompose.ui.viewholder.ProjectListViewHolder

class ProjectScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosandroidComposeTheme {
                // A surface container using the 'background' color from the theme
                setContent {
                    Column(modifier = Modifier.fillMaxSize()) {
                        AppBar(
                            Icons.Default.Refresh,
                            title = getString(R.string.projects),
                            onRefresh = { /*TODO*/ },
                            onBackPressed = { onBackPressed() })
                        val items = mutableListOf<Project>()
                        items.add(Project("11", "New project", "23"))
                        items.add(Project("11", "New project", "23"))
                        items.add(Project("11", "New project", "23"))
                        items.add(Project("11", "New project", "23"))
                        ProjectListViewHolder(items)
                    }
                }

            }
        }
    }
}








