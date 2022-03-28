package com.hieuminh.lovejourney.interfaces

interface InitLayout<V> {
    fun getViewBinding(): V
    fun initListener()
    fun initView()
}