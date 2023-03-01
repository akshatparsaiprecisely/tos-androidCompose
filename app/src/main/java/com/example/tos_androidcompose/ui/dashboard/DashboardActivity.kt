package com.example.tos_androidcompose.ui.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tos_androidcompose.DashboardButtons
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.theme.Orange
import com.example.tos_androidcompose.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.theme.colorPrimary

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosandroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorPrimary)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(580.dp)
                            .background(Color.White)
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {}

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = BiasAlignment(0f, -0.37f)),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {


                        BoxWithConstraints(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(50.dp)
                        ) {
                            val borderRadius = 16.dp
                            val borderStrokeWidth = 1.dp

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(borderRadius))
                                    .border(
                                        borderStrokeWidth,
                                        Color.Black,
                                        RoundedCornerShape(borderRadius)
                                    )
                                    .background(Color.White)
                            ) {
                                // Content of the box goes here
                            }
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                DashboardButtons(
                                    symbol = getString(R.string.Projects),
                                    color = colorPrimary,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                ) {
//                            fuctionality
                                }
                                DashboardButtons(
                                    image = painterResource(id = R.drawable.notification),
                                    symbol = getString(R.string.Notifiction),
                                    color = Color.Green,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                ) {
                                    //                            fuctionality
                                }
                                DashboardButtons(
                                    image = painterResource(id = R.drawable.chat),
                                    symbol = getString(R.string.Chats),
                                    color = Orange,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .weight(1f)
                                ) {
                                    //                            fuctionality
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(start = 16.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(start = 16.dp),
                                    text = "Data Stats",
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {

                            }
                        }
                    }
                }
            }
        }
    }
}
