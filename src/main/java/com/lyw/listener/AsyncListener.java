package com.lyw.listener;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Lenovo on 2018/6/28.
 */
public class AsyncListener {

    @Subscribe
    public void a(String a) {
        System.out.println("观察者接受到消息");
        System.out.println("当前线程名字为："  + Thread.currentThread().getName());
    }

}
