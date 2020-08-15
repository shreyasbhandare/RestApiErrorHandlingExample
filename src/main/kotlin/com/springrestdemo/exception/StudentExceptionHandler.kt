package com.springrestdemo.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class StudentExceptionHandler {
    @ExceptionHandler
    fun handleException(exc : StudentNotFoundException) : ResponseEntity<StudentErrorResponse> {
        val studentErrorResponse = StudentErrorResponse(HttpStatus.NOT_FOUND.value(),
                exc.message,
                System.currentTimeMillis())

        return ResponseEntity(studentErrorResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleGenericException(exc : Exception) : ResponseEntity<StudentErrorResponse> {
        val studentErrorResponse = StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exc.message,
                System.currentTimeMillis())

        return ResponseEntity(studentErrorResponse, HttpStatus.BAD_REQUEST)
    }
}