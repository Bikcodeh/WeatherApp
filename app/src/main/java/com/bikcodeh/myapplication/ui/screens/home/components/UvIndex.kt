package com.bikcodeh.myapplication.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.bikcodeh.myapplication.R
import com.bikcodeh.myapplication.ui.components.ProgressHorizontal


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UvIndex(
    modifier: Modifier = Modifier,
    value: String,
    size: Dp = 80.dp
) {
    Card(
        modifier = modifier.width(size).height(size / 2),
        shape = Shapes().extraSmall,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            val (title, icon, progress, valueUv, uvCategory) = createRefs()

            Image(
                modifier = Modifier
                    .size(14.dp)
                    .constrainAs(icon) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }, painter = painterResource(id = R.drawable.ic_sun),
                contentDescription = null
            )

            Text(
                text = stringResource(id = R.string.uv_index).uppercase(),
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(icon.end)
                    top.linkTo(parent.top)
                },
                fontSize = 10.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                text = value, modifier = Modifier.constrainAs(valueUv) {
                    top.linkTo(icon.bottom)
                    start.linkTo(parent.start)
                },
                fontSize = 18.sp
            )
            Text(text = "Moderate", modifier = Modifier.constrainAs(uvCategory) {
                start.linkTo(parent.start)
                top.linkTo(valueUv.bottom)
            })
            ProgressHorizontal(
                modifier = Modifier
                    .clip(shape = Shapes().extraSmall)
                    .constrainAs(progress) {
                        start.linkTo(parent.start)
                        top.linkTo(uvCategory.bottom, 4.dp)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }, uvIndex = value.toInt()
            )
        }
    }
}

@Preview
@Composable
fun UvIndexPreview() {
    UvIndex(value = "11")
}