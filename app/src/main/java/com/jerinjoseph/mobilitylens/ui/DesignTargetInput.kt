package com.jerinjoseph.mobilitylens.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jerinjoseph.mobilitylens.R

@Composable
fun DesignTargetInput(
    designTargetName: String,
    onTextChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    feedbackMessage: String,
    isFeedbackAnError: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.design_target_prompt),
            style = MaterialTheme.typography.titleMedium
        )

        OutlinedTextField(
            value = designTargetName,
            onValueChange = onTextChange,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(R.string.design_target_label)) },
            placeholder = { Text(stringResource(R.string.design_target_placeholder)) },
            singleLine = true
        )

        Button(
            onClick = onButtonClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.submit_button))
        }

        if (feedbackMessage.isNotBlank()) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                color = if (isFeedbackAnError) {
                    MaterialTheme.colorScheme.errorContainer
                } else {
                    MaterialTheme.colorScheme.secondaryContainer
                }
            ) {
                Text(
                    text = feedbackMessage,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (isFeedbackAnError) {
                        MaterialTheme.colorScheme.onErrorContainer
                    } else {
                        MaterialTheme.colorScheme.onSecondaryContainer
                    }
                )
            }
        }
    }
}