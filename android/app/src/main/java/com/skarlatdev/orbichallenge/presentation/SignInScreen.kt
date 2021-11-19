package com.skarlatdev.orbichallenge.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skarlatdev.orbichallenge.R

@Composable
fun SignInComposable(onSignInWithGoogleClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.sign_in),
            Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp),
            style = MaterialTheme.typography.h4
        )
        GoogleSignInButton(
            onSignInWithGoogleClicked,
            Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GoogleSignInButton(onClick: () -> Unit, modifier: Modifier) {
    Button(
        onClick = { onClick.invoke() },
        shape = RoundedCornerShape(size = 8.dp),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.align(Alignment.Center)) {
                Image(
                    painter = painterResource(id = R.drawable.icon_google),
                    contentDescription = "google_icon",
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(id = R.string.sign_in_google), modifier = Modifier.align(
                        Alignment.CenterVertically
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun GoogleSignInButtonPreview() {
    GoogleSignInButton(modifier = Modifier, onClick = {})
}

@Preview
@Composable
fun SignInPreview() {
    SignInComposable {}
}