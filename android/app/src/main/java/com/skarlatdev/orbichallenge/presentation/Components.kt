package com.skarlatdev.orbichallenge.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skarlatdev.orbichallenge.R

@Composable
fun ScreenTitle(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier
            .padding(top = 16.dp),
        style = MaterialTheme.typography.h4
    )
}

@Composable
@Preview
fun ScreenTitlePrev() {
    ScreenTitle(text = stringResource(id = R.string.sign_in), Modifier)
}