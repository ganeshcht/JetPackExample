package com.example.jetpackexample.roomdatabase

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.jetpackexample.R
import kotlinx.android.synthetic.main.activity_edit_employee.*

class EditEmployeeActivity : AppCompatActivity() {

    private var model: EditViewModel? = null
    private var employee: LiveData<Employee>? = null
    private var emp_id: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_employee)

        emp_id = intent.getStringExtra("EMP_ID")

        model = ViewModelProviders.of(this).get(EditViewModel::class.java)

        employee = model!!.getEmployee(emp_id)

        employee!!.observe(this, Observer {
            ed_first_name.setText(it.firstName)
            ed_last_name.setText(it.lastName)
        })


        btn_cancel.setOnClickListener {
            finish()
        }

        btn_update.setOnClickListener {
            val firstname = ed_first_name.text.toString()
            val lastname = ed_last_name.text.toString()

            val resultIntent=Intent()
            resultIntent.putExtra("EMP_ID",emp_id)
            resultIntent.putExtra("EMP_FNAME",firstname)
            resultIntent.putExtra("EMP_LNAME",lastname)
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }
    }
}
