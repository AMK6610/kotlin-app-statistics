package com.springtask.repositories

import com.springtask.models.AppStatistics
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AppStatisticsRepository: CrudRepository<AppStatistics, String>{
    fun findByTypeAndReportTimeBetween(type: Int, startDate: Date, endDate: Date): List<AppStatistics>
}