package com.springtask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class SpringTaskApplication
fun main(args: Array<String>) {
	runApplication<SpringTaskApplication>(*args)
}
