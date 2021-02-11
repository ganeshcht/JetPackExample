package com.example.jetpackexample.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeDao employeeDao;
    private EmployeeRoomDatabase employeeDB;

    private LiveData<List<Employee>> allEmployee;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeDB = EmployeeRoomDatabase.getDatabase(application);
        employeeDao = employeeDB.employeeDao();
        allEmployee = employeeDao.getAllEmployee();
    }

    void insert(Employee employee) {
        new InsertAsynchTask(employeeDao).execute(employee);
    }

    LiveData<List<Employee>> getAllEmployee() {
        return allEmployee;
    }

    public LiveData<Employee> getEmployee(String employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    void update(Employee employee) {
        new UpdateAsynchTask(employeeDao).execute(employee);
    }

    void delete(Employee employee) {
        new DeleteAsynchTask(employeeDao).execute(employee);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


    private class InsertAsynchTask extends AsyncTask<Employee, Void, Void> {
        EmployeeDao employeeDao;

        public InsertAsynchTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.insert(employees[0]);
            return null;
        }
    }

    private class UpdateAsynchTask extends AsyncTask<Employee, Void, Void> {
        EmployeeDao employeeDao;

        public UpdateAsynchTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.update(employees[0]);
            return null;
        }
    }

    private class DeleteAsynchTask extends AsyncTask<Employee, Void, Void> {
        EmployeeDao employeeDao;

        public DeleteAsynchTask(EmployeeDao employeeDao) {
            this.employeeDao = employeeDao;
        }

        @Override
        protected Void doInBackground(Employee... employees) {
            employeeDao.delete(employees[0]);
            return null;
        }
    }
}
