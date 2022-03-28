package com.hieuminh.lovejourney

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.hieuminh.lovejourney.adapter.HomeAdapter
import com.hieuminh.lovejourney.databinding.ActivityMainBinding
import com.hieuminh.lovejourney.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var mAdapter: HomeAdapter

    override fun getViewBinding() = ActivityMainBinding.inflate(this.layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun initRecyclerViewAndAdapter() {
        mAdapter = HomeAdapter()
        binding.rvEvent.apply {
            layoutManager = LinearLayoutManager(null)
            adapter = mAdapter
        }
    }

    override fun initListener() = Unit

    override fun initView() {
        initRecyclerViewAndAdapter()
    }
}
