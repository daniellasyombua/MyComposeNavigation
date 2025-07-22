package com.daniella.navigation


data class Payment(
    val incoming: Boolean,
    val amount: Double,
    val narration: String,
    val date: String
)
