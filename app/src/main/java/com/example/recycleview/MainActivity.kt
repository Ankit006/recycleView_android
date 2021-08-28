package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf<Todo>(
            Todo("Follow Android Dev",false),
            Todo("Learn Kotlin",true),
            Todo("Learn typeScript",false),
            Todo("learn x86 assembly",false),
            Todo("learn about kernel development",false)
        )


         // add adapter to recycle view
        val recyclerView:RecyclerView = findViewById(R.id.rvTodos);
        val adapter = TodoAdapter(todoList)
        recyclerView.adapter = adapter

        // set layout manager to recycle view
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addTodo:Button = findViewById(R.id.btnAddTodo)
        val inputTodo:EditText = findViewById(R.id.etTodo)
        addTodo.setOnClickListener{
            val title = inputTodo.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            // update recycle view
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}