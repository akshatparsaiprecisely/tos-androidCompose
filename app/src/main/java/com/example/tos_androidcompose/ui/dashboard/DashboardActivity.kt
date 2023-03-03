package com.example.tos_androidcompose.ui.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tos_androidcompose.DashboardButtons
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.theme.DataStatsButtons
import com.example.tos_androidcompose.ui.theme.Orange
import com.example.tos_androidcompose.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.theme.colorPrimary
import com.example.tos_androidcompose.ui.utils.AppConstants
import kotlinx.coroutines.launch

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TosandroidComposeTheme {
                DashboardScreen()
                // A surface container using the 'background' color from the theme
            }

        }

    }

    @Composable
    fun DashboardScreen() {
        val navController = rememberNavController()
        val drawerItems = listOf(
            Screen.Home,
            Screen.Settings,
            Screen.About,
            Screen.Logout
        )
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()

        fun customDrawerShape() = object : Shape {
            override fun createOutline(
                size: Size,
                layoutDirection: LayoutDirection,
                density: Density
            ): Outline {
                return Outline.Rectangle(Rect(0f, 0f, 700f,/* width */ 10000f  /* height */))
            }
        }

        Scaffold(
            scaffoldState = scaffoldState,
            drawerShape = customDrawerShape(),
            drawerContent = {
                // Composable for the drawer content
                DrawerContent(drawerItems = drawerItems, navController = navController)
            },
            content = {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(color = colorPrimary)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.precisely_logo_white),
                            contentDescription = "nav",
                            Modifier
                                .padding(top = 60.dp)
                                .height(56.dp)
                                .width(56.dp)
                                .align(Alignment.TopCenter)
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.navigation_menu),
                        contentDescription = "nav",
                        Modifier
                            .padding(20.dp)
                            .clickable {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            },
                        alignment = Alignment.TopStart
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 120.dp),
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
