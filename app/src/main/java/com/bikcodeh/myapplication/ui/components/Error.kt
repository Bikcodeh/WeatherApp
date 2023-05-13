package com.bikcodeh.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.bikcodeh.myapplication.R

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    message: String,
    onTryAgain: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(modifier = Modifier.fillMaxWidth(), text = message, textAlign = TextAlign.Center)
        Button(onClick = onTryAgain) {
            Text(text = stringResource(id = R.string.try_again), textAlign = TextAlign.Center)
        }
    }
}