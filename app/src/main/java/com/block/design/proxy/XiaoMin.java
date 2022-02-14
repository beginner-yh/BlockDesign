package com.block.design.proxy;

import android.util.Log;

class XiaoMin implements ILawsuit{
    @Override
    public void submit() {
        Log.i("XiaoMin", "submit: ");
    }

    @Override
    public void burden() {
        Log.i("XiaoMin", "burden: ");
    }

    @Override
    public void defend() {
        Log.i("XiaoMin", "defend: ");
    }

    @Override
    public void finish() {
        Log.i("XiaoMin", "finish: ");
    }
}
