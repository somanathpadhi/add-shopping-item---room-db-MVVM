package com.android.mvvmstoredbapp.ui.shoppinglist

import com.android.mvvmstoredbapp.data.db.entities.ShoppingItem

interface AddDialogueListener {
    fun onAddButtonClicked(item:ShoppingItem)
}