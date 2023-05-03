package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.module.Student
import com.example.myapplication.util.DBHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = DBHelper(this)
        db.insert(Student(name = "Aliyev Ali", phone_number = "+998(99)-123-45-67"))
    }
}