package com.jerinjoseph.mobilitylens.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jerinjoseph.mobilitylens.R
import com.jerinjoseph.mobilitylens.model.MobilityDimension

@Composable
fun DimensionCard(
    dimension: MobilityDimension,
    positionLabel: String,
    modifier: Modifier = Modifier
) {
    ElevatedCard(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = positionLabel,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = stringResource(dimension.nameRes),
                style = MaterialTheme.typography.titleLarge
            )

            LabelledParagraph(
                label = stringResource(R.string.label_constraint),
                body = stringResource(dimension.descriptionRes)
            )

            LabelledParagraph(
                label = stringResource(R.string.label_implication),
                body = stringResource(dimension.implicationRes)
            )
        }
    }
}

@Composable
private fun LabelledParagraph(
    label: String,
    body: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}