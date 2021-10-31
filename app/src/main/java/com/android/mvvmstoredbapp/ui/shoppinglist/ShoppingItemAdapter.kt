package com.android.mvvmstoredbapp.ui.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mvvmstoredbapp.R
import com.android.mvvmstoredbapp.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
     var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]
        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text = "${currentShoppingItem.amount}"
        holder.itemView.ivDelete.setOnClickListener {
            viewModel.deleteItem(currentShoppingItem)
        }
        holder.itemView.ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.addItem(currentShoppingItem)
        }
        holder.itemView.ivMinus.setOnClickListener {
            if (currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewModel.addItem(currentShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}