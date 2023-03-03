package com.example.tos_androidcompose.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tos_androidcompose.DashboardButtons
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.theme.*
import com.example.tos_androidcompose.ui.utils.AppConstants
import kotlinx.coroutines.launch

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TosandroidComposeTheme {
                MyDrawer()
                // A surface container using the 'background' color from the theme
            }

        }

    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun MyDrawer() {
        val navController = rememberNavController()
        val drawerItems = listOf(
            Screen.Home,
            Screen.Settings,
            Screen.About,
            Screen.Logout
        )
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {

            },
            drawerContent = {
                // Composable for the drawer content
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
                                .padding(top = 20.dp, start = 10.dp),
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
                                    .weight(1f)
                                    .height(84.dp)
                                    .size(5.dp)
                                    .background(Color.White)
                                    .padding(25.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_baseline_folder_open_24),
                                    contentDescription = "aa"
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .weight(2.7f)
                                    .fillMaxHeight()
                                    .padding(10.dp)
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
                    Box(modifier = Modifier.padding(top = 20.dp))
                    drawerItems.forEach { screen ->
                        Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
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
                                painter = painterResource(id = screen.id),
                                contentDescription = "aa"
                            )
                            Text(
                                text = screen.title,
                            )
                        }

                    }
                }
            },
            content = {
                Column {
                    // image that will open the navigation drawer when clicked
                    // Composable for the screen content
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(Screen.Home.route) {
                            // Composable for the home screen
                        }
                        composable(Screen.Settings.route) {
                            // Composable for the settings screen
                        }
                        composable(Screen.About.route) {
                            // Composable for the settings screen
                        }
                        composable(Screen.Logout.route) {
                            // Composable for the settings screen
                        }
                    }

                    // Dashboard Content
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = colorPrimary)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.navigation_menu),
                            contentDescription = "nav",
                            Modifier
                                .padding(20.dp)
                                .clickable { scope.launch {
                                    scaffoldState.drawerState.open()
                                } },
                            alignment = Alignment.TopStart
                        )

                        Image(
                            painter = painterResource(id = R.drawable.precisely_logo_white),
                            contentDescription = "nav",
                            Modifier
                                .padding(top = 60.dp)
                                .height(56.dp)
                                .width(56.dp)
                                .align(Alignment.TopCenter)
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(580.dp)
                                .background(Color.White)
                                .align(Alignment.BottomCenter),
                        ) {}

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(alignment = BiasAlignment(0f, -0.34f)),
                        ) {


                            val borderRadius = 16.dp
                            val borderStrokeWidth = 2.dp
                            BoxWithConstraints(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(127.dp)
                                    .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 2.dp)
                                    .shadow(
                                        borderStrokeWidth,
                                        shape = RoundedCornerShape(borderRadius)
                                    )
                            ) {


                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(borderRadius))
                                        .size(200.dp)

                                ) {
                                    Row(
                                        modifier = Modifier
                                            .background(Color.White)
                                            .align(Alignment.Center),
                                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .fillMaxHeight()
                                                .background(Color.White)
                                                .padding(25.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_baseline_folder_open_24),
                                                contentDescription = "aa"
                                            )
                                        }
                                        Column(
                                            modifier = Modifier
                                                .weight(2.7f)
                                                .fillMaxHeight()
                                                .padding(20.dp)
                                        ) {
                                            Text(
                                                text = "Tossuer",
                                                fontSize = 20.sp,
                                                color = colorPrimary
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
                            }

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(top = 20.dp),
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 30.dp, end = 30.dp, top = 10.dp),
                                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                                ) {
                                    DashboardButtons(
                                        symbol = getString(R.string.Projects),
                                        color = colorPrimary,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                            .padding(10.dp),
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
                                        .padding(start = 30.dp, end = 30.dp, top = 20.dp),
                                ) {
                                    Text(
                                        text = "Data Stats",
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 30.dp, end = 30.dp, top = 20.dp),
                                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                                ) {
                                    DataStatsButtons(
                                        titleText = "415",
                                        color = colorPrimary,
                                        symbol = getString(R.string.collected),
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                            .padding(10.dp)
                                    ) {
//                            fuctionality
                                    }
                                    DataStatsButtons(
                                        titleText = "415",
                                        symbol = getString(R.string.approved),
                                        color = Color.Green,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        //                            fuctionality
                                    }
                                    DataStatsButtons(
                                        titleText = "415",
                                        symbol = getString(R.string.pending),
                                        color = Orange,
                                        modifier = Modifier
                                            .aspectRatio(1f)
                                            .weight(1f)
                                    ) {
                                        //                            fuctionality
                                    }
                                }
                            }
                        }
                    }
                }
                // rest of your screen content goes here
            }

        )
    }

}

sealed class Screen(val route: String, val title: String, val id: Int) {
    object Home : Screen(AppConstants.HOME, AppConstants.HOME, R.drawable.menu_home)
    object Settings : Screen(AppConstants.SETTINGS, AppConstants.SETTINGS, R.drawable.menu_settings)
    object About : Screen(AppConstants.ABOUT, AppConstants.ABOUT, R.drawable.menu_about_24)
    object Logout : Screen(AppConstants.LOGOUT, AppConstants.LOGOUT, R.drawable.menu_logout_24)
}
