package com.example.myapplication.util

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication.module.Student

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION), CURD {


    companion object {
        const val DB_NAME = "contact"
        const val DB_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query =
            "create table student ('id' integer primary key autoincrement not null , 'name' text not null, 'phone_number' text)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun insert(student: Student) {
        val database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put("name", student.name)
        contentValues.put("phone_number", student.phone_number)
        database.insert("student", null, contentValues)

    }

    override fun loadList(): MutableList<Student> {
        val students= mutableListOf<Student>()
  val database= this.readableDatabase
        var query= "select*from student"
        var cursor=database.rawQuery(query,null)
        if(cursor.moveToFirst()){
            do{
                val id = cursor.getInt(0)
                val name=cursor.getString(1)
                val phone_number=cursor.getString(2)
            }
                while (cursor.moveToNext())
        }
        return students
    }

}