package com.besonganong.listquotesfeature.view.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.besonganong.listquotesfeature.model.QuoteModel
import com.besonganong.listquotesfeature.model.QuotesScreenState
import com.besonganong.listquotesfeature.utils.TestQuotes.quoteModel1
import com.besonganong.listquotesfeature.utils.TestQuotes.quoteModel2
import com.besonganong.listquotesfeature.utils.TestQuotes.quoteModel3
import com.besonganong.listquotesfeature.utils.TestQuotes.quoteModel4
import com.besonganong.listquotesfeature.view.ui.components.ErrorIndicator
import com.besonganong.listquotesfeature.view.ui.components.ProgressIndicator
import com.besonganong.listquotesfeature.view.ui.components.VerticalGrid
import com.besonganong.listquotesfeature.viewModel.QuotesViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun QuotesScreen(
    quotesViewModel: QuotesViewModel = koinViewModel()
) {

    val uiState: QuotesScreenState by quotesViewModel
        .uiState.collectAsState()

    when(uiState) {

        is QuotesScreenState.Loading -> {
            ProgressIndicator()
        }

        is QuotesScreenState.Success -> {
            val quotes = (uiState as QuotesScreenState.Success).quoteModels
            QuoteGrid(quoteModels = quotes)
        }


        is QuotesScreenState.Error -> {
            ErrorIndicator(
                onErrorButtonClick = { quotesViewModel.onErrorButtonClick() })

        }
    }


}

@Composable
private fun QuoteGrid(quoteModels: List<QuoteModel>) {

    VerticalGrid {
        quoteModels.forEach { quote ->
            Quote(quoteModel = quote)
        }
    }

}

@Composable
private fun Quote(quoteModel: QuoteModel) {

    Box(
        modifier = Modifier
            .padding(
                start = 4.dp, top = 4.dp, end = 4.dp
            )
            .size(100.dp)
    ) {
        Text(
            text = "\"${quoteModel.text}\"",
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp,
            letterSpacing = 2.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuoteGridPreview() {
    val quotes = listOf(quoteModel1, quoteModel2, quoteModel3, quoteModel4)

    QuoteGrid(quoteModels = quotes)

}

@Preview(showBackground = true)
@Composable
fun QuotePreview() {
    Quote(
        quoteModel = quoteModel1
    )
}

