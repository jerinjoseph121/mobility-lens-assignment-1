package com.jerinjoseph.mobilitylens.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jerinjoseph.mobilitylens.R

@Composable
fun DimensionNavigator(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    isPreviousEnabled: Boolean,
    isNextEnabled: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedButton(
            onClick = onPreviousClick,
            enabled = isPreviousEnabled,
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.dimension_navigator_previous))
        }

        Button(
            onClick = onNextClick,
            enabled = isNextEnabled,
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.dimension_navigator_next))
        }
    }
}