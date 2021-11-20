package com.skarlatdev.orbichallenge.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ChallengesScreen() {

}

@Composable
fun Challenge() {
    Column(modifier = Modifier.background(Color.Blue, shape = RoundedCornerShape(8.dp))) {
        Image(
            painter = rememberImagePainter("https://web-zoopark.ru/wp-content/uploads/2018/07/4-42.jpg"),
            contentDescription = "challenge entity"
        )

        Text(text = "Cat challenge", modifier = Modifier.padding(top = 16.dp))
    }
}