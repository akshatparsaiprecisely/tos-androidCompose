package com.example.tos_androidcompose.ui.dashboard

import android.annotation.SuppressLint
import android.media.Image
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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tos_androidcompose.DashboardButtons
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.theme.*
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
        val isDrawerVisible = remember { mutableStateOf(false) }

        LaunchedEffect(isDrawerVisible.value) {
            if (isDrawerVisible.value) {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            } else {
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        }

        Scaffold(
            topBar = {

            },
            drawerContent = {
                // Composable for the drawer content
                Column(
                    modifier = Modifier.background(Color.White)
                ) {
                    Box(
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                            .background(color = colorPrimaryDark)
                    ) {
                        val borderRadius = 16.dp
                        val borderStrokeWidth = .01.dp
                            Row(modifier = Modifier
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
                                        .background(Color.White)
                                        .padding(25.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(painter = painterResource(id = R.drawable.ic_baseline_folder_open_24),
                                        contentDescription = "aa")
                                }
                                Column(modifier = Modifier
                                    .weight(2.7f)
                                    .fillMaxHeight()
                                    .padding(10.dp)
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
                            Image(painter = painterResource(id = screen.id), contentDescription = "aa" )
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

                            Image(painter = painterResource(id = R.drawable.navigation_menu), contentDescription = "nav",
                                Modifier
                                    .padding(20.dp)
                                    .clickable { isDrawerVisible.value = true },
                                alignment = Alignment.TopStart)

                            Image(painter = painterResource(id = R.drawable.precisely_logo_white), contentDescription = "nav",
                                Modifier
                                    .padding(top = 40.dp)
                                    .height(100.dp)
                                    .width(100.dp)
                                    .align(Alignment.TopCenter))

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


                                BoxWithConstraints(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(127.dp)
                                        .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                                ) {
                                    val borderRadius = 16.dp
                                    val borderStrokeWidth = .01.dp

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
                                        Row(modifier = Modifier
                                            .background(Color.White)
                                            .align(Alignment.Center),
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
                                                    .fillMaxHeight()
                                                    .background(Color.White)
                                                    .padding(25.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Image(painter = painterResource(id = R.drawable.ic_baseline_folder_open_24),
                                                    contentDescription = "aa")
                                            }
                                            Column(modifier = Modifier
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
                                        .background(Color.White),
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
                                                .padding(10.dp)
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
        object Home : Screen("home" ,"Home", R.drawable.menu_home)
        object Settings : Screen("settings", "Settings", R.drawable.menu_settings)
        object About : Screen("ABOUT", "ABOUT", R.drawable.menu_about_24)
        object Logout : Screen("LOGOUT", "LOGOUT", R.drawable.menu_logout_24)
    }
