package com.auvehassan.diffutilsrecyclerviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var list = emptyList<Item>()

    fun setItems(items: List<Item>) {
        val diffCallback = DiffUtils(list, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.list = items
        diffResult.dispatchUpdatesTo(this)
    }

    fun getCurrentList() = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Item) {
            val textView = view.findViewById<TextView>(android.R.id.text1)
            textView.text = item.name
        }
    }
}