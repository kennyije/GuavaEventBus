package com.lyw.listener;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Lenovo on 2018/6/29.
 */
public class SmsListener {

    @Subscribe
    public void b(SmsListener b) {
        System.out.println("SmsListener 接受到消息: 线程为："+ Thread.currentThread().getName());
    }
}
