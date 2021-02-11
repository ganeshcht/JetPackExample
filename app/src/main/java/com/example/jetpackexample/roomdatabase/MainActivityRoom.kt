package com.example.jetpackexample.roomdatabase

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackexample.R
import kotlinx.android.synthetic.main.activity_main_room.*
import java.util.*

class MainActivityRoom : AppCompatActivity(), OnClickRecyclerItem {
    private var model: EmployeeViewModel? = null
    private var employeeAdapter: EmployeeListAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

        model = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        val ivAdd = findViewById<ImageView>(R.id.iv_add)
        ivAdd.setOnClickListener { addRecords() }

        employeeAdapter = EmployeeListAdapter(this)
        rv_notes.adapter = employeeAdapter
        rv_notes.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        model!!.allEmployee.observe(this, androidx.lifecycle.Observer {

            employeeAdapter!!.setEmployee(it)
        })
    }

    private fun addRecords() {

        val dialog = Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_add)
        val edFirstName = dialog.findViewById<EditText>(R.id.ed_firstname)
        val edLastName = dialog.findViewById<EditText>(R.id.ed_lastname)
        val btnSave =
            dialog.findViewById<Button>(R.id.btn_save)
        val btnCancel =
            dialog.findViewById<Button>(R.id.btn_cancel)
        btnSave.setOnClickListener {
            val firstName = edFirstName.text.toString()
            val lastName = edLastName.text.toString()
            if (firstName.trim { it <= ' ' }.equals("", ignoreCase = true) &&
                lastName.trim { it <= ' ' }.equals("", ignoreCase = true)
            ) {
                Toast.makeText(
                    this@MainActivityRoom,
                    "Please enter valid filed!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                dialog.dismiss()
                val id = UUID.randomUUID().toString()
                val employee = Employee(id, firstName, lastName)
                model!!.insert(employee)
                Toast.makeText(
                    this@MainActivityRoom,
                    "saved",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        btnCancel.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private var EDIT_RESQUEST: Int = 143
    override fun onEdit(employeeId: String?) {


        val intent = Intent(this, EditEmployeeActivity::class.java)
        intent.putExtra("EMP_ID", employeeId)
        startActivityForResult(intent, EDIT_RESQUEST)
    }

    override fun onDelete(employeeId: Employee) {
        model!!.delete(employeeId)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_RESQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if (data!=null){
                    val id = data.getStringExtra("EMP_ID")
                    val fname = data.getStringExtra("EMP_FNAME")
                    val lname = data.getStringExtra("EMP_LNAME")
                    model?.update(Employee(id, fname, lname))
                }

            }
        }
    }


}