package com.hieuminh.lovejourney

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.hieuminh.lovejourney.adapter.EventAdapter
import com.hieuminh.lovejourney.common.constants.AppPatterns
import com.hieuminh.lovejourney.databinding.ActivityMainBinding
import com.hieuminh.lovejourney.models.Couple
import com.hieuminh.lovejourney.models.Event
import com.hieuminh.lovejourney.utils.DateUtil
import com.hieuminh.lovejourney.utils.JsonUtil
import com.hieuminh.lovejourney.utils.StringUtil
import com.hieuminh.lovejourney.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var eventAdapter: EventAdapter
    private var couple: Couple? = null

    override fun getViewBinding() = ActivityMainBinding.inflate(this.layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun initListener() = Unit

    override fun initView() {
        val json = assets.open("mock_data.json").bufferedReader().use { it.readText() }
        couple = JsonUtil.fromJson<Couple>(json)
        binding.tvMaleName.text = couple?.maleName
        binding.tvFemaleName.text = couple?.femaleName
        val days = DateUtil.getDateCount(couple?.confessionDay ?: "", AppPatterns.DATE_PATTERN)
        binding.tvDayNumber.text =
            StringUtil.getString(this, R.string.s_day)?.let { String.format(it, days) }

        eventAdapter = EventAdapter()
        eventAdapter.updateData(couple?.events as MutableList<Event>?, true)
        binding.rvEvent.run {
            layoutManager = LinearLayoutManager(null)
            adapter = eventAdapter
        }

    }

    override fun onStart() {
        super.onStart()
    }
}
