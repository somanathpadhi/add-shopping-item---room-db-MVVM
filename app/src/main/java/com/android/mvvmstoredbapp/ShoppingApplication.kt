package com.android.mvvmstoredbapp

import android.app.Application
import com.android.mvvmstoredbapp.data.db.ShoppingDatabase

class ShoppingApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { ShoppingDatabase.getDatabase(this) }
}
