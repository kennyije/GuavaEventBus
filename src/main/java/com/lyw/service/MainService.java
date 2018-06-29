package com.lyw.service;

import com.google.common.eventbus.AsyncEventBus;
import com.lyw.listener.AsyncListener;
import com.lyw.listener.SmsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2018/6/28.
 */
@Service
public class MainService {

    @Autowired
    private AsyncEventBus asyncEventBus;

    @Autowired
    private AsyncListener asyncListener;

    public void execute() throws InterruptedException {
        System.out.println("执行主线任务");
        System.out.println("发布消息");
        while(true) {
            Thread.sleep(2000);
            asyncEventBus.post("a");
            asyncEventBus.post(new SmsListener());
        }
    }
}
