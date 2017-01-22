package com.example.dubbo.service.consumer;

import com.example.dubbo.service.inf.IProviderServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/1/21.
 */
@Service
public class ConsumerService {

    @Autowired
    private IProviderServiceInf providerService;

    //实现初始化之后进行的操作
    @PostConstruct
    public void init()throws InterruptedException {
        String msg="";
        msg=providerService.sayHello("哈哈哈~");
        System.out.println("");
        System.out.println(msg);
        System.out.println("");
    }

}
