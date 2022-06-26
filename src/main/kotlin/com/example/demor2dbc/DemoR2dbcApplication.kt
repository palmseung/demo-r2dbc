package com.example.demor2dbc

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoR2dbcApplication

val log = KotlinLogging.logger {  }

fun main(args: Array<String>) {
	runApplication<DemoR2dbcApplication>(*args)

	log.info { ">>> core = ${Runtime.getRuntime().availableProcessors()}" }

}
