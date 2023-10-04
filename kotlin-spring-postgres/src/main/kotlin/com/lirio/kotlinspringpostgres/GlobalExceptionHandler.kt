package com.lirio.kotlinspringpostgres

import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.RuntimeException


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleException(ex: Exception): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build()
    }

    @ExceptionHandler(Quatro22Excpeption::class)
    fun handleNullableExceptionException(ex: Exception): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build()
    }
}

class Quatro22Excpeption : RuntimeException()