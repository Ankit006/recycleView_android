package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todos:List<Todo>):RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    //  this class hold view
    class TodoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textView:TextView = itemView.findViewById(R.id.tvTitle)
        val checkBox:CheckBox = itemView.findViewById(R.id.cbDone)
    }

    // this class create view for recycleview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val viewData = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return TodoViewHolder(viewData)
    }

    // this class bind data to view
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.apply {
            textView.text = todos[position].title
            checkBox.isChecked = todos[position].isChecked
        }
    }

    // this class return item count of list
    override fun getItemCount(): Int {
        return todos.size
    }

}