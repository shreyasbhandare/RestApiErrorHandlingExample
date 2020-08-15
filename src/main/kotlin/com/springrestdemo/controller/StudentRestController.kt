package com.springrestdemo.controller

import com.springrestdemo.entity.Student
import com.springrestdemo.exception.StudentNotFoundException
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/api")
class StudentRestController{

    lateinit var studentList : List<Student>

    @PostConstruct
    fun loadStudents(){
        studentList = listOf(Student("John", "Doe"),
                            Student("Jane", "Smith"),
                            Student("Shane", "Reeves"))
    }

    @GetMapping("/student")
    fun getStudents() : List<Student> {
        return studentList
    }

    @GetMapping("/student/{studentId}")
    fun getStudent(@PathVariable studentId : Int) : Student {
        if(studentId >= studentList.size || studentId < 0)
            throw StudentNotFoundException("Student Id is not found : $studentId")

        return studentList.get(studentId)
    }
}