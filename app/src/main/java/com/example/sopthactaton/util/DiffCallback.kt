package com.example.sopthactaton.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DiffCallback<T : Any>(val id: (T, T) -> Boolean) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return id(oldItem, newItem)
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}

//ex)
// companion object {
//        private val HomeDiffCallback =
//            DiffCallback<ResponseUserInfo>(id = { old, new -> old.id == new.id })
//    }