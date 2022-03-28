package com.hieuminh.lovejourney.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.lovejourney.adapter.base.BaseAdapter
import com.hieuminh.lovejourney.databinding.ItemEventBinding
import com.hieuminh.lovejourney.models.Couple

class HomeAdapter: BaseAdapter<Couple>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return EventViewHolder(ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    inner class EventViewHolder(private val binding: ItemEventBinding): BaseViewHolder(binding.root) {
        override fun bind(data: Couple) {
        }
    }
}