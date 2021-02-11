package com.example.jetpackexample.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {
    @Insert
    fun insert(employee: Employee?)

    @get:Query("SELECT * FROM employee")
    val allEmployee: LiveData<List<Employee?>?>?

    @Query("SELECT * FROM employee where id=:employeeId")
    fun getEmployeeById(employeeId: String?): LiveData<Employee>

    @Update
    fun update(employee: Employee?)

    @Delete
    fun delete(employee: Employee?)
}