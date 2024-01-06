package com.besonganong.listquotesfeature.view.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A simple composable that shows a Loading Indicator
 */
@Composable
fun ProgressIndicator() {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        CircularProgressIndicator(
            modifier = Modifier.padding(8.dp),
            strokeWidth = 4.dp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProgressIndicatorPreview() {
    ProgressIndicator()
}