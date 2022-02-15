package com.block.design.producer;

import android.util.Log;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await 和 signal
 */
class ProducerLock {

    private static final String TAG = "ProducerLock";

    private final static int MAX_SIZE = 10;
    private ReentrantLock mLock = new ReentrantLock();
    private Condition mEmpty = mLock.newCondition();
    private Condition mFull = mLock.newCondition();
    private LinkedList<Object> mList = new LinkedList<>();

    public void produce() {
        mLock.lock();
        while (mList.size() == MAX_SIZE) {
            Log.i(TAG, "produce: 缓存区满，暂停生产");
            try {
                mFull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mList.add(new Object());
        Log.i(TAG, "produce: 生产了一个新产品，现在容量" + mList.size());
        mEmpty.signalAll();
        mLock.unlock();
    }

    public void consume() {
        mLock.lock();
        while (mList.size() == 0) {
            Log.i(TAG, "produce: 缓存区为空，暂停消费");
            try {
                mEmpty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mList.remove();
        Log.i(TAG, "produce: 消费了一个新产品，现在容量" + mList.size());
        mFull.signalAll();
        mLock.unlock();
    }
}
