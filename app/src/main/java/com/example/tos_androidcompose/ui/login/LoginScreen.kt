package com.example.tos_androidcompose.ui.login
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.chats.ui.theme.TosandroidComposeTheme
import com.example.tos_androidcompose.ui.theme.colorPrimary
import androidx.compose.material.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

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
    @Preview
    @Composable
    fun LoginContent() {
        var textValue by remember { mutableStateOf("") }
        Box(modifier = Modifier.fillMaxSize() ) {
            Image(
                painter = painterResource(id = R.drawable.precisely_bg),
                contentDescription = "login background",
                modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .height(700.dp)
                .padding(20.dp))
            {
                Image(
                    painter = painterResource(id = R.drawable.precisely_logo),
                    contentDescription = "login background",
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = getString(R.string.map_reveal),
                    fontSize = 22.sp,
                    color = colorPrimary
                )
                Text(
                    text = getString(R.string.geographical_information_system),
                    fontSize = 22.sp,
                    color = colorPrimary
                )
                Text(
                    text = getString(R.string.geographical_information_system),
                    fontSize = 22.sp,
                    color = colorPrimary
                )
                TextField(
                    value = textValue,
                    onValueChange = { newValue: String ->
                        textValue = newValue
                    },
                    label = { getString(R.string.login_username) },
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(27.dp),
                )

                TextField(
                    value = textValue,
                    onValueChange = { newValue: String ->
                        textValue = newValue
                    },
                    label = { getString(R.string.login_password) },
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(27.dp),
                )
                TextField(
                    value = textValue,
                    onValueChange = { newValue: String ->
                        textValue = newValue
                    },
                    label = { getString(R.string.organisation_id_mandatory) },
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(27.dp),
                )

                Text(
                    text = getString(R.string.forgot_password),
                    fontSize = 11.sp,
                    color = colorPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(Alignment.End)
                )
                Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {

                }

            }
        }
    }
}

