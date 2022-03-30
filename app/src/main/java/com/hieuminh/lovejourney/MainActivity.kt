package com.hieuminh.lovejourney

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.hieuminh.lovejourney.databinding.ActivityMainBinding
import com.hieuminh.lovejourney.view.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding() = ActivityMainBinding.inflate(this.layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    override fun initListener() = Unit

    override fun initView() = Unit
}
