package com.example.tos_androidcompose.ui.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

@Composable
fun AppBar(
    imageVector: ImageVector,
    title: String,
    onRefresh: () -> Unit,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = onRefresh) {
                Icon(imageVector, contentDescription = "Refresh")
            }
        }
    )
}

@Composable
fun AppBarCustomImage(
    painter: Int ,
    title: String,
    onRefresh: () -> Unit,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = onRefresh) {
                Icon(painter = painterResource(painter) , contentDescription = "Refresh")
            }
        }
    )
}