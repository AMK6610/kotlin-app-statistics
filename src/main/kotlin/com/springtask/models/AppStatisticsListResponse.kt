package com.springtask.models

import java.io.Serializable


data class AppStatisticsListResponse(val stats: List<AppStatisticsModel>) : Serializable