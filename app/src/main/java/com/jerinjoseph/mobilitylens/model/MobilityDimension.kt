package com.jerinjoseph.mobilitylens.model

import androidx.annotation.StringRes
import com.jerinjoseph.mobilitylens.R

data class MobilityDimension(
    @param:StringRes val nameRes: Int,
    @param:StringRes val descriptionRes: Int,
    @param:StringRes val implicationRes: Int
)

val mobilityDimensions = listOf(
    MobilityDimension(R.string.dimension_interaction_name, R.string.dimension_interaction_description, R.string.dimension_interaction_implication),
    MobilityDimension(R.string.dimension_orientation_name, R.string.dimension_orientation_description, R.string.dimension_orientation_implication),
    MobilityDimension(R.string.dimension_lifecycle_name, R.string.dimension_lifecycle_description, R.string.dimension_lifecycle_implication),
    MobilityDimension(R.string.dimension_context_name, R.string.dimension_context_description, R.string.dimension_context_implication),
    MobilityDimension(R.string.dimension_patterns_name, R.string.dimension_patterns_description, R.string.dimension_patterns_implication),
    MobilityDimension(R.string.dimension_security_name, R.string.dimension_security_description, R.string.dimension_security_implication)
)

