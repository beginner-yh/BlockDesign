package com.block.design.singleton

class SingleInnerClass private constructor() {

    companion object {
        val INSTANCE = StateHelperHolder.holder
    }

    private object StateHelperHolder {
        val holder = SingleInnerClass()
    }

    fun init(){
        
    }
}