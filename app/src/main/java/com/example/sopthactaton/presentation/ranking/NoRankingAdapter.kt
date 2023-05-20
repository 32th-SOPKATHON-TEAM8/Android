package com.example.sopthactaton.presentation.ranking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sopthactaton.api.model.ResponseRankingDto
import com.example.sopthactaton.databinding.ItemNoRankBinding
import com.example.sopthactaton.databinding.ItemYesRank4Binding
import com.example.sopthactaton.databinding.ItemYesRank5Binding
import com.example.sopthactaton.util.DiffCallback

class NoRankingAdapter:
    ListAdapter<ResponseRankingDto.Data, NoRankingAdapter.RankViewHolder>(rankingDiffUtil) {

    private var listener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoRankingAdapter.RankViewHolder {
        val binding: ItemNoRankBinding =
            ItemNoRankBinding.inflate(LayoutInflater.from(parent.context))
        return RankViewHolder(binding)
    }


    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }



    inner class RankViewHolder(private val binding: ItemNoRankBinding) :
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