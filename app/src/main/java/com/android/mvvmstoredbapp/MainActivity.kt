package com.android.mvvmstoredbapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mvvmstoredbapp.data.db.entities.ShoppingItem
import com.android.mvvmstoredbapp.data.repository.ShoppingRepository
import com.android.mvvmstoredbapp.ui.shoppinglist.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val application = applicationContext as ShoppingApplication
        val repository = ShoppingRepository(application.database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(
            this, factory
        ).get(ShoppingViewModel::class.java)
        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        fab.setOnClickListener {
            AddShoppingItemTextDialogue(
                this,
                object : AddDialogueListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.addItem(item)
                    }
                }).show()
        }
    }
}