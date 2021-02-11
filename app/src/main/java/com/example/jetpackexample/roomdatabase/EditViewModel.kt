package com.example.jetpackexample.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class EditViewModel(application: Application) : AndroidViewModel(application) {
    private val db: EmployeeRoomDatabase
    private val dao: EmployeeDao
    fun getEmployee(employeeId: String?): LiveData<Employee> {
        return dao.getEmployeeById(employeeId)
    }

    init {
        db = EmployeeRoomDatabase.getDatabase(application)
        dao = db.employeeDao()
    }
}