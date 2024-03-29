package com.besonganong.listquotesfeature.view.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A simple composable that displays an error message.
 */
@Composable
fun ErrorIndicator(
    onErrorButtonClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

    Text(text = " Sorry!. Can't Load Quotes.", modifier = Modifier.padding(bottom = 22.dp))

    Button(onClick = onErrorButtonClick) {

        Text(text = "Try Again!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorMessagePreview() {
    
    ErrorIndicator {}
}