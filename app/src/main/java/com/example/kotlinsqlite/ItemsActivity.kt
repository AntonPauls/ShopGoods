package com.example.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()
        items.add(Item(1, "boots", "Жіночі кросівки","Зимові чоботи","Тепла підкладка для найкращого тепла та комфорту в холодну погоду.",1600))
        items.add(Item(2,"shoes","Жіночі чоботи", "Зимові чоботи","Сучасний та стильний дизайн, який підкреслить вашу індивідуальність.", 1400))
        items.add(Item(3,"yggi","Жіночі угі", "Зимові чоботи","Водонепроникні матеріали для надійного захисту від вологи та снігу.", 1800))
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}