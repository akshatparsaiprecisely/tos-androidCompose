package com.example.tos_androidcompose.ui.formStatisticsScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.FormDashboardScreen.FormDataDashboardActivity
import com.example.tos_androidcompose.ui.chats.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.common.AppBar
import com.example.tos_androidcompose.ui.common.AppBarCustomImage
import com.example.tos_androidcompose.ui.model.projects.Project
import com.example.tos_androidcompose.ui.viewholder.ProjectListViewHolder

class FormStatisticsScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosandroidComposeTheme {
                // A surface container using the 'background' color from the theme
                setContent {
                    Column(modifier = Modifier.fillMaxSize()) {
                        AppBarCustomImage( R.drawable.ic_cloud_upload,
                            title = "new project",
                            onRefresh = { /*TODO*/ }
                        ) { onBackPressed() }
                        val items = mutableListOf<Project>()
                        val activity = LocalContext.current as Activity

                        items.add(Project("11", "Pt(Do not use)", "23", R.drawable.ic_point))
                        items.add(Project("11", "Pt(Do not use)", "23", R.drawable.ic_line))
                        items.add(Project("11", "Pt(Do not use)", "23", R.drawable.ic_polygon))
                        items.add(Project("11", "Pt(Do not use)", "23", R.drawable.ic_multipolygon))
                        ProjectListViewHolder(items, onClick = {
                            val intent = Intent(
                                this@FormStatisticsScreen,
                                FormDataDashboardActivity::class.java
                            ).apply {
                                putExtra("key", "ab")
                            }
                            this@FormStatisticsScreen.startActivity(intent)
                        })
                    }
                }

            }
        }
    }
}

