package com.springtask.services

import com.springtask.models.AppStatisticsListResponse
import com.springtask.models.AppStatisticsModel
import com.springtask.repositories.AppStatisticsRepository
import com.springtask.utils.toPersianYearAndWeek
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.*


@Service("AppStatisticsService")
class AppStatisticsService{
    @Autowired
    lateinit var appStatisticsRepository: AppStatisticsRepository

    @Cacheable(cacheNames = ["app-statistics"], key= "{#startDate,#endDate,#type}")
    fun getStats(startDate: Date, endDate: Date, type: Int): AppStatisticsListResponse {
        return AppStatisticsListResponse(
                stats =
                appStatisticsRepository.findByTypeAndReportTimeBetween(type, startDate, endDate)
                        .groupBy {
                            it.reportTime.toPersianYearAndWeek()
                        }.map{
                            entry ->
                            AppStatisticsModel(
                                    year = entry.key.first,
                                    weekNum = entry.key.second,
                                    clicks = entry.value.sumBy { it.clickCount() },
                                    requests = entry.value.sumBy { it.requestCount() },
                                    installs = entry.value.sumBy { it.installCount() }
                            )
                        }
                        .sortedWith(
                                compareBy({it.year}, {it.weekNum})
                        )
        )
    }
}