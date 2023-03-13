package com.example.tos_androidcompose.ui.chats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.chats.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.common.AppBar

class ChatScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosandroidComposeTheme {
                // A surface container using the 'background' color from the theme
                setContent {
                    Column(modifier = Modifier.fillMaxSize()) {
                        AppBar(
                            Icons.Default.Search,
                            title = getString(R.string.chats),
                            onRefresh = { /*TODO*/ },
                            onBackPressed = { onBackPressed() })
                        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")
                        MyRecyclerView(items)
                    }
                }
            }
        }
    }
}

@Composable
fun MyRecyclerView(items: List<String>) {
    LazyColumn {
        items(items = items) { item ->
            Text(text = item, modifier = Modifier.padding(16.dp))
        }
    }
}