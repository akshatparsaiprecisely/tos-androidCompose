package com.example.tos_androidcompose.ui.viewholder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.model.projects.Project


@Composable
fun ListItem(item: Project, onClick: () -> Unit) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(top = 8.dp)
            .shadow(2.dp, shape = RoundedCornerShape(0.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(8.dp)
            )
            Spacer(
                modifier = Modifier
                    .padding(1.dp)
                    .background(Color.Gray)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_info),
                    contentDescription = "info"
                )
                Text(text = "collected")
                Text(
                    text = "30", modifier = Modifier
                        .padding(start = 30.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_approved),
                    modifier = Modifier.padding(start = 10.dp),
                    contentDescription = "info"
                )
                Text(text = "Approved")
                Text(
                    text = "30", modifier = Modifier
                        .padding(start = 50.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_resurvey),
                    contentDescription = "info"
                )
                Text(text = "collected")
                Text(
                    text = "30", modifier = Modifier
                        .padding(start = 30.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_pending),
                    modifier = Modifier.padding(start = 10.dp),
                    contentDescription = "info"
                )
                Text(text = "Approved")
                Text(
                    text = "30", modifier = Modifier
                        .padding(start = 50.dp)
                )
            }
        }
    }
}

@Composable
fun ProjectListViewHolder(items: List<Project>) {
    LazyColumn {
        items(items = items) { item ->
            ListItem(
                item = item,
                onClick = { /* Do something */ }
            )
        }
    }
}