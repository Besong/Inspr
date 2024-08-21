package com.besonganong.listquotesfeature.view.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.besonganong.listquotesfeature.R

/**
 * A simple composable that displays an error message.
 */
@Composable
fun ErrorMessage(
    @StringRes errorMsg: Int,
    onErrorButtonClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

    Text(text = stringResource(id = errorMsg), modifier = Modifier.padding(bottom = 22.dp))

    Button(onClick = onErrorButtonClick) {

        Text(text = stringResource(id = R.string.try_again))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorMessagePreview() {
    
    ErrorMessage(errorMsg = R.string.network_is_disconnected) {}
}