package com.example.jetpackexample.roomdatabase;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Employee.class,version = 1)
public abstract class EmployeeRoomDatabase extends RoomDatabase {

    public abstract EmployeeDao employeeDao();

    private static volatile EmployeeRoomDatabase employeeRoomInstance;

    static EmployeeRoomDatabase getDatabase(final Context context){
        if (employeeRoomInstance==null){
            synchronized (EmployeeRoomDatabase.class){
                employeeRoomInstance= Room.databaseBuilder(context.getApplicationContext(),
                        EmployeeRoomDatabase.class,"employee.db")
                        .build();
            }
        }
        return employeeRoomInstance;
    }

}
