package com.example.sopthactaton.presentation.ranking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sopthactaton.databinding.ItemTopNoRankBinding
import com.example.sopthactaton.databinding.ItemTopYesRankBinding

class TopTitleAdapter(topType: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val type = topType

    private val MULTI_TYPE1 = 0 // no rank
    private val MULTI_TYPE2 = 1 // yes rank

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (type) {
            MULTI_TYPE1 -> {
                val binding: ItemTopNoRankBinding =
                    ItemTopNoRankBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return NoRankTitleViewHolder(binding)
            }
            MULTI_TYPE2 -> {
                val binding: ItemTopYesRankBinding = ItemTopYesRankBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return YesRankTitleViewHolder(binding)
            }
            else -> {
                val binding: ItemTopYesRankBinding = ItemTopYesRankBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return YesRankTitleViewHolder(binding)
            }

        }
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(type) {
            MULTI_TYPE1 -> {
                (holder as NoRankTitleViewHolder).onBind()
                holder.setIsRecyclable(false)
            }
            MULTI_TYPE2 -> {
                (holder as YesRankTitleViewHolder).onBind()
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as YesRankTitleViewHolder).onBind()
                holder.setIsRecyclable(false)
            }
        }

    }

    class YesRankTitleViewHolder(private val binding: ItemTopYesRankBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(){
        }
    }
    class NoRankTitleViewHolder(private val binding: ItemTopNoRankBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(){

        }
    }
}