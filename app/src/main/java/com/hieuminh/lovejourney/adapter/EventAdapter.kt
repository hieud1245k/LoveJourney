package com.hieuminh.lovejourney.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.lovejourney.adapter.base.BaseAdapter
import com.hieuminh.lovejourney.common.constants.AppPatterns
import com.hieuminh.lovejourney.databinding.ItemEventBinding
import com.hieuminh.lovejourney.models.Data
import com.hieuminh.lovejourney.models.Event
import com.hieuminh.lovejourney.utils.DateUtil

class EventAdapter : BaseAdapter<Event>() {
    private var dataAdapters: List<DataAdapter>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    inner class EventViewHolder(private val binding: ItemEventBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Event) {
            binding.ivDate.text = DateUtil.getDayMonth(data.date ?: "", AppPatterns.DATE_PATTERN)
            val dataAdapter = dataAdapters?.get(layoutPosition)
            dataAdapter?.updateData(data.dataList as MutableList<Data>?)
        }
    }

    override fun updateData(list: MutableList<Event>?, isReload: Boolean) {
        list?.let { dataAdapters = List(list.size) { DataAdapter() } }
        super.updateData(list, isReload)
    }
}
