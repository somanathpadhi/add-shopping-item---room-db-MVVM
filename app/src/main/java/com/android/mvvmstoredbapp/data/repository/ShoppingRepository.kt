package com.android.mvvmstoredbapp.data.repository

import com.android.mvvmstoredbapp.data.db.ShoppingDatabase
import com.android.mvvmstoredbapp.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db:ShoppingDatabase
) {
    suspend fun addItem(item: ShoppingItem) = db.getShoppingDao().addItem(item)
    suspend fun deleteItem(item: ShoppingItem) = db.getShoppingDao().deleteItem(item)
    fun getAllItems() = db.getShoppingDao().getAllShoppingItems()

}