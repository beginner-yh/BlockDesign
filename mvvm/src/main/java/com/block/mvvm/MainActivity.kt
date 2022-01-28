package com.block.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import com.block.mvvm.viewmodel.UpdateViewModel

/**
 * MVVM
 */
class MainActivity : AppCompatActivity() {

    val mViewModel: UpdateViewModel by viewModels()
    lateinit var btnUpdate: AppCompatButton
    lateinit var tvShow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnUpdate = findViewById(R.id.btn_update)
        tvShow = findViewById(R.id.tv_show)

        mViewModel.mLiveData.observe(this, {
            tvShow.text = mViewModel.mLiveData.value
        })

        btnUpdate.setOnClickListener {
            mViewModel.update()
        }
    }
}