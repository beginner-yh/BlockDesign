package com.block.design.singleton

/**
 * 懒汉式
 */
class SingletonIdler private constructor() {

    companion object {
        private var instance: SingletonIdler? = null
            @Synchronized
            get() {
                if (field == null) {
                    field = SingletonIdler()
                }
                return field
            }
    }

    fun init() {

    }
}