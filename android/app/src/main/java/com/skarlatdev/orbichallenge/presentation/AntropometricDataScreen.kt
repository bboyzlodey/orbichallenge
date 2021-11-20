package com.skarlatdev.orbichallenge.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skarlatdev.orbichallenge.R

@Preview
@Composable
fun AntropometricDataScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        ScreenTitle(text = stringResource(id = R.string.antropometric_data), modifier = Modifier)

        Spacer(modifier = Modifier.height(34.dp))

        TextField(value = "176 cm", onValueChange = {}, enabled = false, label = {
            Text(
                text = stringResource(
                    id = R.string.human_height
                )
            )
        })


        TextField(modifier = Modifier.padding(top = 16.dp),
            value = "76 kg", onValueChange = {}, enabled = false, label = {
                Text(
                    text = stringResource(
                        id = R.string.human_weight
                    )
                )
            })


        TextField(
            modifier = Modifier.padding(top = 16.dp),
            value = "Муж",
            onValueChange = {},
            enabled = false,
            label = {
                Text(
                    text = stringResource(
                        id = R.string.human_sex
                    )
                )
            })
    }
}