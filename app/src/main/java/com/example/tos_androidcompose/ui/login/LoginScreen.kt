package com.example.tos_androidcompose.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.chats.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.dashboard.DashboardActivity
import com.example.tos_androidcompose.ui.theme.colorPrimary
import com.example.tos_androidcompose.ui.theme.colorPrimaryDark

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosandroidComposeTheme {
                LoginContent()
                // A surface container using the 'background' color from the theme

            }
        }
    }

    @Preview()
    @Composable
    fun LoginContent() {
        val activity = LocalContext.current as Activity
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var organizatinId by remember { mutableStateOf("") }
        val borderRadius = 16.dp
        val borderStrokeWidth = 2.dp
        Image(
            painter = painterResource(id = R.drawable.precisely_bg),
            contentDescription = "login background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .shadow(
                    borderStrokeWidth,
                    shape = RoundedCornerShape(borderRadius)
                )
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.precisely_logo),
                    contentDescription = "login background",
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp)
                )
                Text(
                    text = stringResource(id = R.string.map_reveal),
                    fontSize = 22.sp,
                    color = colorPrimary,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp)
                )
                Text(
                    text = stringResource(id = R.string.geographical_information_system),
                    fontSize = 14.sp,
                    color = colorPrimaryDark,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                TextField(
                    value = username,
                    onValueChange = { newValue: String ->
                        username = newValue
                    },
                    textStyle = TextStyle(color = Color.Black),
                    label = {
                        Text(
                            text = stringResource(id = R.string.login_username),
                            color = Color.Gray,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                )

                TextField(
                    value = password,
                    onValueChange = { newValue: String ->
                        password = newValue
                    },
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(
                        text = stringResource(id = R.string.login_password),
                        color = Color.Gray,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    ) },
                    modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                )
                TextField(
                    value = organizatinId,
                    onValueChange = { newValue: String ->
                        organizatinId = newValue
                    },
                    textStyle = TextStyle(color = Color.Black),
                    label = { Text(
                        text = stringResource(id = R.string.organisation_id_mandatory),
                        color = Color.Gray,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    ) },
                    modifier = Modifier
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    fontSize = 11.sp,
                    color = colorPrimary,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 20.dp, end = 20.dp)
                )
                Button(
                    onClick = {
                        activity.startActivity(
                            Intent(
                                this@LoginScreen,
                                DashboardActivity::class.java
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(20.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.login)
                    )
                }
            }
        }
    }
}

