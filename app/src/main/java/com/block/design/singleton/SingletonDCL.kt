package com.block.design.singleton

class SingletonDCL private constructor() {

    companion object {
        val instance: SingletonDCL by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDCL()
        }
    }

    fun init() {

    }
}