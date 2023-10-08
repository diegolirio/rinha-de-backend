package com.lirio.kotlinspringpostgres

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringPostgresApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringPostgresApplication>(*args)
}
