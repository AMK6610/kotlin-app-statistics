package com.springtask

import com.springtask.models.AppStatistics
import com.springtask.repositories.AppStatisticsRepository
import com.springtask.utils.toDate
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.*

/*
    This class will populate database with fake data
    run() method of this class will be invoked at application startup
*/
@Component
class DatabasePopulator(val appStatisticsRepository: AppStatisticsRepository): CommandLineRunner{

    override fun run(vararg args: String?) {
        populateDatabase()
    }

    fun populateDatabase(){
        var fakeData = mutableListOf<AppStatistics>()
        for(i in 1..100){
            fakeData.add(randomAppStatistics())
        }
        appStatisticsRepository.saveAll(fakeData)
    }

    fun randomAppStatistics(): AppStatistics{
        val year = (1395..1397).random()
        val month = (1..12).random()
        val day = (1..28).random()
        val reportTime = listOf(year, month, day).joinToString(separator = "-").toDate()
        return AppStatistics(
                id = UUID.randomUUID().toString(),
                reportTime = reportTime,
                type = (1..5).random(),
                videoRequests = (0..100).random(),
                webViewRequests = (0..100).random(),
                videoClicks = (0..100).random(),
                webViewClicks = (0..100).random(),
                videoInstalls = (0..100).random(),
                webViewInstalls = (0..100).random()
                )
    }

}