package com.springtask.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("appstatistics")
data class AppStatistics(
        @Id
        val id: String,
        val reportTime: Date,
        val type: Int,

        private val videoRequests: Int,
        private val webViewRequests: Int,

        private val videoClicks: Int,
        private val webViewClicks: Int,

        private val videoInstalls: Int,
        private val webViewInstalls: Int
){
        fun requestCount() = videoRequests + webViewRequests
        fun clickCount() = videoClicks + webViewClicks
        fun installCount() = videoInstalls + webViewInstalls
}

