package com.example.jetpackexample.roomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackexample.R
import com.example.jetpackexample.roomdatabase.EmployeeListAdapter.EmployeeListHolder

class EmployeeListAdapter(private val context: Context) :
    RecyclerView.Adapter<EmployeeListHolder>() {
    private val layoutInflater: LayoutInflater
    private var employees: List<Employee>? = null
    var onClickRecyclerItem: OnClickRecyclerItem
    private val model: EmployeeViewModel? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return EmployeeListHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeListHolder, position: Int) {
        if (employees != null) {
            val employee = employees!![position]
            holder.tvFirstname.text = employee.firstName
            holder.tvLastName.text = employee.lastName
            holder.ivEdit.tag = position
            holder.ivEdit.setOnClickListener { onClickRecyclerItem.onEdit(employee.id) }
            holder.ivDelete.setOnClickListener { onClickRecyclerItem.onDelete(employee) }
        } else {
            holder.tvFirstname.text = "No Employee"
        }
    }

    override fun getItemCount(): Int {
        return if (employees != null) employees!!.size else 0
    }

    fun setEmployee(it: List<Employee>) {
        employees = it
        notifyDataSetChanged()
    }

    inner class EmployeeListHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvFirstname: TextView = itemView.findViewById(R.id.tv_firstname)
        var tvLastName: TextView = itemView.findViewById(R.id.tv_lastname)
        var ivEdit: ImageView = itemView.findViewById(R.id.iv_edit)
        var ivDelete: ImageView = itemView.findViewById(R.id.iv_delete)

    }

    init {
        layoutInflater = LayoutInflater.from(context)
        onClickRecyclerItem = context as OnClickRecyclerItem
    }
}