package com.bikcodeh.myapplication.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bikcodeh.myapplication.R

@ExperimentalMaterial3Api
@Composable
fun CardHeader(
    modifier: Modifier = Modifier,
    date: String,
    temperature: String,
    location: String
    ) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        shape = Shapes().medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.today),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(text = date, style = MaterialTheme.typography.bodySmall)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = temperature, style = MaterialTheme.typography.displayMedium
            )
            Image(
                painter = painterResource(id = R.drawable.ic_sunny), contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_location), contentDescription = null)
            Text(text = location)
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun CardHeaderPreview() {
    CardHeader(
        date = "Sat, 3 Aug",
        temperature = "30 °c",
        location = "California, USA 90145"
    )
}