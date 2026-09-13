package com.jerinjoseph.mobilitylens.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jerinjoseph.mobilitylens.R
import com.jerinjoseph.mobilitylens.model.mobilityDimensions
import com.jerinjoseph.mobilitylens.ui.theme.MobilityLensTheme

@Composable
fun MobilityLensScreen(modifier: Modifier = Modifier) {
    val resources = LocalResources.current

    var currentDimensionIndex by remember { mutableIntStateOf(0) }
    var designTargetName by remember { mutableStateOf("") }
    var feedbackMessage by remember { mutableStateOf("") }
    var isFeedbackAnError by remember { mutableStateOf(false) }

    val currentDimension = mobilityDimensions[currentDimensionIndex]

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    )  {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.app_title),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = stringResource(R.string.app_intro),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        DimensionCard(
            dimension = currentDimension,
            positionLabel = stringResource(
                R.string.dimension_position,
                currentDimensionIndex + 1,
                mobilityDimensions.size
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        DimensionNavigator(
            onPreviousClick = {
                currentDimensionIndex--
                feedbackMessage = ""
            },
            onNextClick = {
                currentDimensionIndex++
                feedbackMessage = ""
            },
            isPreviousEnabled = currentDimensionIndex > 0,
            isNextEnabled = currentDimensionIndex < mobilityDimensions.lastIndex
        )

        HorizontalDivider()

        DesignTargetInput(
            designTargetName = designTargetName,
            onTextChange = { designTargetName = it },
            onButtonClick = {
                if (designTargetName.isBlank()) {
                    isFeedbackAnError = true
                    feedbackMessage = resources.getString(R.string.empty_field_error_message)
                } else {
                    isFeedbackAnError = false
                    feedbackMessage = resources.getString(
                        R.string.combined_message,
                        designTargetName,
                        resources.getString(currentDimension.nameRes)
                    )
                }
            },
            feedbackMessage = feedbackMessage,
            isFeedbackAnError = isFeedbackAnError
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MobilityLensScreenPreview() {
    MobilityLensTheme {
        MobilityLensScreen()
    }
}