package com.example.tos_androidcompose

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun DashboardButtons(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    textStyle: TextStyle = TextStyle(),
    image: Painter = painterResource(id = R.drawable.ic_baseline_folder_open_24),

    onClick: () -> Unit
) {
    val borderRadius = 16.dp
    val borderStrokeWidth = 1.dp
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.White)
            .clip(RoundedCornerShape(borderRadius))
            .border(borderStrokeWidth, color, RoundedCornerShape(borderRadius))
            .clickable {
                onClick()
            }
            .then(modifier),
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .align(Alignment.Center)
                .padding(10.dp)
        ) {
            Row(modifier = Modifier.padding()
                .align(Alignment.CenterHorizontally)) {
                Image(
                    painter = image,
                    contentDescription = symbol,
                    alignment = Alignment.Center)
            }
            Text(
                text = symbol,
                style = textStyle,
                fontSize = 11.sp,
                color = color
            )
        }

    }
}