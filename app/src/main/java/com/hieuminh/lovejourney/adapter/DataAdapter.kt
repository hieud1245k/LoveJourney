package com.hieuminh.lovejourney.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hieuminh.lovejourney.R
import com.hieuminh.lovejourney.adapter.base.BaseAdapter
import com.hieuminh.lovejourney.common.enums.DataType
import com.hieuminh.lovejourney.databinding.ItemImageDataBinding
import com.hieuminh.lovejourney.databinding.ItemTextDataBinding
import com.hieuminh.lovejourney.models.Data

class DataAdapter : BaseAdapter<Data>() {
    override fun getItemViewType(position: Int): Int {
        return dataList[position].type ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            DataType.IMAGE.index -> ImageViewHolder(
                ItemImageDataBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                )
            )
            else -> TextViewHolder(
                ItemTextDataBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                )
            )
        }
    }

    inner class ImageViewHolder(private val binding: ItemImageDataBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Data) {

        }
    }

    inner class TextViewHolder(private val binding: ItemTextDataBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Data) {
            binding.ivPerson.setBackgroundResource(if (data.gender == 0) R.drawable.ic_male else R.drawable.ic_female)
            binding.tvMessage.text = data.data
        }
    }
}
