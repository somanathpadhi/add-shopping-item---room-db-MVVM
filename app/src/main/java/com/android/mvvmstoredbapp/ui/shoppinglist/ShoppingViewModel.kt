package com.android.mvvmstoredbapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.android.mvvmstoredbapp.data.db.entities.ShoppingItem
import com.android.mvvmstoredbapp.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {
    fun addItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.addItem(item)
    }

    fun deleteItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.deleteItem(item)
    }

    fun getAllItems() = repository.getAllItems()
}