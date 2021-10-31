package com.android.mvvmstoredbapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.mvvmstoredbapp.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(item: ShoppingItem)

    @Delete
    suspend fun deleteItem(item: ShoppingItem)

    @Query(value = "SELECT * FROM Shopping_item")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}