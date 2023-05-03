package com.example.myapplication.util

import com.example.myapplication.module.Student

interface CURD {

    fun insert(student: Student)

//    fun delete(student: Student)

//    fun update(student: Student)

    fun loadList(): MutableList<Student>

}