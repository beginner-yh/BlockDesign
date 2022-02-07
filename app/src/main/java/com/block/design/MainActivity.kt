package com.block.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.block.design.singleton.SingletonDCL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //单例
        SingletonDCL.getInstance()
    }
}