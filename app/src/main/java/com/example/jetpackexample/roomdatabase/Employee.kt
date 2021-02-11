package com.example.jetpackexample.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
class Employee(
    @field:PrimaryKey val id: String,
    @field:ColumnInfo(name = "first_name") val firstName: String,
    @field:ColumnInfo(
        name = "last_name"
    ) val lastName: String
)