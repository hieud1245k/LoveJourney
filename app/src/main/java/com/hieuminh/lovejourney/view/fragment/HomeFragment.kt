package com.hieuminh.lovejourney.view.fragment

import com.hieuminh.lovejourney.R
import com.hieuminh.lovejourney.adapter.EventAdapter
import com.hieuminh.lovejourney.common.constants.AppPatterns
import com.hieuminh.lovejourney.databinding.FragmentHomeBinding
import com.hieuminh.lovejourney.models.Couple
import com.hieuminh.lovejourney.models.Event
import com.hieuminh.lovejourney.utils.DateUtil
import com.hieuminh.lovejourney.utils.JsonUtil
import com.hieuminh.lovejourney.utils.StringUtil
import com.hieuminh.lovejourney.view.fragment.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private lateinit var mEventAdapter: EventAdapter
    private var mCouple: Couple? = null

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun initListener() {
    }

    private fun initRecyclerViewAdapter() {
        mEventAdapter = EventAdapter()
        mEventAdapter.updateData(mCouple?.events as MutableList<Event>?, false)
        binding.rvEvent.adapter = mEventAdapter
    }

    override fun initView() {
        val json = context?.assets?.open("mock_data.json")?.bufferedReader().use { it?.readText() }
        mCouple = JsonUtil.fromJson<Couple>(json)
        binding.tvMaleName.text = mCouple?.maleName
        binding.tvFemaleName.text = mCouple?.femaleName
        val days = DateUtil.getDateCount(mCouple?.confessionDay ?: "", AppPatterns.DATE_PATTERN)
        binding.tvDayNumber.text =
            StringUtil.getString(context, R.string.s_day)?.let { String.format(it, days) }
        initRecyclerViewAdapter()
    }
}
