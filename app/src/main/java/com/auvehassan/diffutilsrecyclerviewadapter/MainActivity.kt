package com.auvehassan.diffutilsrecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.auvehassan.diffutilsrecyclerviewadapter.R
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private val itemAdapter = ItemAdapter()
    private val list = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val addButton = findViewById<MaterialButton>(R.id.addButton)
        val removeButton = findViewById<MaterialButton>(R.id.removeButton)


        for (id in 0..5) {
            list.add(Item(id, "$id - Lorem ipsum doler sit amet." ))
        }

        recyclerView.adapter = itemAdapter
        itemAdapter.setItems(list)

        addButton.setOnClickListener { addNewItem() }
        removeButton.setOnClickListener { removeFirstItem() }
    }

    private fun addNewItem() {
        val currentList = itemAdapter.getCurrentList()
        val newId = currentList.last().id + 1

        val newList = arrayListOf<Item>()
        newList.addAll(currentList)
        newList.add(Item(newId, "$newId - Lorem ipsum doler sit amet. (recently added)"))

        itemAdapter.setItems(newList)
    }

    private fun removeFirstItem(){
        val currentList = itemAdapter.getCurrentList()

        val newList = arrayListOf<Item>()
        newList.addAll(currentList)
        newList.removeFirstOrNull()

        itemAdapter.setItems(newList)
    }
}