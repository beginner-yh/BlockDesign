package com.block.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 数据刷新ViewModel
 */
class UpdateViewModel : ViewModel() {

    val mLiveData = MutableLiveData<String>()

    fun update() {
        mLiveData.value = "Android"
    }
}