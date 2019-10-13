package com.springtask.controllers

import com.springtask.models.AppStatisticsListResponse
import com.springtask.services.AppStatisticsService
import com.springtask.utils.toDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/app-statistics")
class AppStatisticsController {
    @Autowired
    lateinit var appStatisticsService: AppStatisticsService

    @GetMapping("/")
    fun getStats(@RequestParam(required = false, defaultValue = "1") type: Int,
                 @RequestParam(required = false, defaultValue = "1395-01-01") startDate: String,
                 @RequestParam(required = false, defaultValue = "1398-07-21") endDate: String) : AppStatisticsListResponse {

        return appStatisticsService.getStats(startDate.toDate(), endDate.toDate(), type)
    }
}