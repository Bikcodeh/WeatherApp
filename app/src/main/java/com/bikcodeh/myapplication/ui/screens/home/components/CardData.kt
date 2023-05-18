package com.bikcodeh.myapplication.ui.screens.home.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardData(
    modifier: Modifier = Modifier,
    size: Dp = 80.dp,
    titleText: String,
    content: @Composable () -> Unit,
    @DrawableRes iconResId: Int,
    @StringRes iconTitleTextId: Int
) {
    Card(
        modifier = modifier.size(size),
        shape = Shapes().extraSmall,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            val (title, icon, iconTitle) = createRefs()

            Image(
                modifier = Modifier
                    .size(14.dp)
                    .constrainAs(icon) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }, painter = painterResource(id = iconResId),
                contentDescription = null
            )

            Text(
                text = stringResource(id = iconTitleTextId).uppercase(),
                modifier = Modifier.constrainAs(iconTitle) {
                    start.linkTo(icon.end)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                fontSize = 10.sp,
                textAlign = TextAlign.Justify
            )

            Text(
                text = titleText, modifier = Modifier.constrainAs(title) {
                    top.linkTo(icon.bottom)
                    start.linkTo(parent.start)
                },
                fontSize = 18.sp
            )
            content()
        }
    }
}

@Preview
@Composable
fun CardDataPreview() {
    CardData(
        titleText = "test",
        content = {},
        iconResId = R.drawable.ic_blizzard,
        iconTitleTextId = R.string.tomorrow
    )
}