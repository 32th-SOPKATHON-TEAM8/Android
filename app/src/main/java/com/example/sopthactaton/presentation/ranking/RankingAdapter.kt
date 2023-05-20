package com.example.sopthactaton.presentation.ranking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sopthactaton.api.model.ResponseRankingDto
import com.example.sopthactaton.databinding.ItemNoRankBinding
import com.example.sopthactaton.databinding.ItemYesRank4Binding
import com.example.sopthactaton.databinding.ItemYesRank5Binding
import com.example.sopthactaton.util.DiffCallback


class RankingAdapter:
    ListAdapter<ResponseRankingDto.Data, ViewHolder>(rankingDiffUtil) {

    private var listener: OnItemClickListener? = null

    private val MULTI_TYPE1 = 0 // yes rank 5
    private val MULTI_TYPE2 = 1 // yes rank 4

    override fun getItemViewType(position: Int): Int {
        return when(currentList[position].life){

            4 -> MULTI_TYPE2
            5 -> MULTI_TYPE1
            else -> MULTI_TYPE1

        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            MULTI_TYPE1 -> {
                val binding: ItemYesRank5Binding =
                    ItemYesRank5Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return YesRank5ViewHolder(binding)
            }
            MULTI_TYPE2 -> {
                val binding: ItemYesRank4Binding =
                    ItemYesRank4Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return YesRank4ViewHolder(binding)
            }
            else -> {
                val binding: ItemYesRank5Binding =
                    ItemYesRank5Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return YesRank5ViewHolder(binding)
            }


        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            MULTI_TYPE1 -> {
                (holder as YesRank5ViewHolder).onBind(currentList[position])
                holder.setIsRecyclable(false)
            }
            MULTI_TYPE2 -> {
                (holder as YesRank4ViewHolder).onBind(currentList[position])
                holder.setIsRecyclable(false)
            }

        }
    }



    inner class YesRank5ViewHolder(private val binding: ItemYesRank5Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ResponseRankingDto.Data) {

            if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                binding.ibAccuse.setOnClickListener {
                    listener?.onItemClick(itemView, item, absoluteAdapterPosition)
                }
            }

        }
    }

    inner class YesRank4ViewHolder(private val binding: ItemYesRank4Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ResponseRankingDto.Data) {

            if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                binding.ibAccuse.setOnClickListener {
                    listener?.onItemClick(itemView, item, absoluteAdapterPosition)
                }
            }

        }
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, data: ResponseRankingDto.Data, pos: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


    companion object {
        private val rankingDiffUtil =
            DiffCallback<ResponseRankingDto.Data>(id = { old, new -> old.id == new.id })
    }


}


