package com.bikcodeh.myapplication.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.ui.theme.yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherItem(
    temperature: String,
    time: String,
    @DrawableRes weatherIcon: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(end = 8.dp).size(120.dp),
        shape = Shapes().medium
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (icon, temp, timeStr, centigrade) = createRefs()
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .padding(top = 8.dp, end = 8.dp)
                    .constrainAs(icon) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
                painter = painterResource(id = weatherIcon),
                contentDescription = null
            )
            Text(
                text = time,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(timeStr) {
                        start.linkTo(parent.start)
                        bottom.linkTo(temp.top)
                    }
            )
            Text(
                text = temperature,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W400,
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 8.dp)
                    .constrainAs(temp) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Text(
                text = "°c",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .constrainAs(centigrade) {
                        start.linkTo(temp.end)
                        top.linkTo(temp.top)
                    },
                color = yellow
            )
        }
    }
}

@Preview
@Composable
fun WeatherItemPreview() {
    WeatherItem(temperature = "26", time = "10 AM", weatherIcon = R.drawable.ic_sever_thunderstom)
}