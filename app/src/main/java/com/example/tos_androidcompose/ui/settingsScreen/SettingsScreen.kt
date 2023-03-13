package com.example.tos_androidcompose.ui.settingsScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tos_androidcompose.R
import com.example.tos_androidcompose.ui.common.AppBar
import com.example.tos_androidcompose.ui.utils.AppConstants

class SettingsScreen() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                SettingScreen()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SettingScreen() {
        Column(modifier = Modifier.fillMaxSize()) {
            AppBar(
                Icons.Default.AccountBox,
                title = AppConstants.SETTINGS,
                onRefresh = { /*TODO*/ }
            ) { onBackPressed() }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color.Gray)
            ) {
                Text(
                    text = stringResource(id = R.string.general_setting),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp),
                    color = Color.Black
                )
            }
            settingButton(R.drawable.ic_profile, stringResource(id = R.string.edit_profile))
            settingButton(R.drawable.ic_form_layout, stringResource(id = R.string.form_layout))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color.Gray)
                    .padding(start = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.map_setting),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
            settingButton(R.drawable.ic_map, stringResource(id = R.string.edit_profile))
            settingButton(R.drawable.ic_satelite, stringResource(id = R.string.form_layout))
            settingButton(R.drawable.ic_measurement, stringResource(id = R.string.form_layout))
        }
    }
}

@Composable
fun settingButton(painter: Int, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Image(
            painter = painterResource(id = painter), contentDescription = "edit profile",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )
        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 40.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_navigate_next),
            contentDescription = "edit profile",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        )
    }
}


