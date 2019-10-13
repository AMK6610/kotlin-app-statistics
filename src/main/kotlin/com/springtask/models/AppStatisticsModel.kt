package com.springtask.models

import java.io.Serializable

data class AppStatisticsModel(
        val year: Int,
        val weekNum: Int,
        val requests: Int = 0,
        val clicks: Int = 0,
        val installs: Int = 0
) : Serializable