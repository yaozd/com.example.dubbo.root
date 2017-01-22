package com.example.dubbo.service.provider.impl;

import com.example.dubbo.service.inf.IProviderServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/1/21.
 */
/**
 *  严重错误提醒--provider提供者是否需要增加注解！！！！！！！！！！！！！！！！！！！
 *  不应该增加任何的注解，例如：@Component、@Service等
 *  不管这些注解是来自Spring boot还是阿里dubbo都不进行添加
 *  因为添加了以后ProviderServiceImpl类会被实例化两次，如：
 *  public ProviderServiceImpl()
 *  public ProviderServiceImpl()
 *  提供者所有的服务都是通过example-dubbo-provider.xml文件进行配置的
 */
//TODO 严重错误提醒--provider提供者是否需要增加注解
//@Component--严重错误提醒
//@Service--严重错误提醒
public class ProviderServiceImpl implements IProviderServiceInf {

    public ProviderServiceImpl(){
        //验证-ProviderServiceImpl类会被实例化的次数
        System.out.println("public ProviderServiceImpl()");
    }
    @Override
    public String sayHello(String name) throws InterruptedException {
        String msg="+Hello:~~~~~~~~~~~~~~~~~~~~~~~~" + name + "你好，你好~~";
        System.out.println();
        System.out.println(msg);
        System.out.println();
        Thread.sleep(20000);
        return msg;
    }
}
