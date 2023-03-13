package com.example.tos_androidcompose.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.theme.colorPrimaryDark

@Composable
fun DrawerContent(
    drawerItems: List<Screen>,
    navController: NavHostController,
) {
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .background(color = colorPrimaryDark)
        ) {
            val borderRadius = 16.dp
            val borderStrokeWidth = .01.dp
            Row(
                modifier = Modifier
                    .background(colorPrimaryDark)
                    .align(Alignment.Center)
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(
                            borderStrokeWidth,
                            Color.Black,
                            RoundedCornerShape(borderRadius)
                        )
                        .height(50.dp)
                        .width(50.dp)
                        .size(5.dp)
                        .background(Color.White)
                        .align(Alignment.CenterVertically),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_folder_open_24),
                        contentDescription = "aa",
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 30.dp)
                ) {
                    Text(
                        text = "Tossuer",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Project assigned: 9",
                        fontSize = 11.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Last Login",
                        fontSize = 11.sp,
                        color = Color.Gray
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(5.dp))
        drawerItems.forEach { screen ->
            Row(horizontalArrangement = Arrangement.spacedBy(30.dp),
                modifier = Modifier
                    .clickable {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                    .fillMaxWidth()
                    .padding(16.dp)) {
                Image(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = screen.id),
                    contentDescription = "aa"
                )
                Text(
                    text = screen.title,
                    style = TextStyle(fontWeight = Bold, color = Color.Gray),
                    fontSize = 14.sp
                )
            }
        }
    }
}