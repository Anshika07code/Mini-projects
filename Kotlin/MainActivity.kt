package com.example.todoapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var taskInput: EditText
    private lateinit var addButton: Button
    private lateinit var listView: ListView

    private val taskList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskInput = findViewById(R.id.taskInput)
        addButton = findViewById(R.id.addButton)
        listView = findViewById(R.id.taskListView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val task = taskInput.text.toString()

            if (task.isNotEmpty()) {
                taskList.add(task)
                adapter.notifyDataSetChanged()
                taskInput.text.clear()
            } else {
                Toast.makeText(this, "Enter a task", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
