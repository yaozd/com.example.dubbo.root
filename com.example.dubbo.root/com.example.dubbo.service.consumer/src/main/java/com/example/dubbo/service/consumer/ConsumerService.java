package com.example.dubbo.service.consumer;

import com.example.dubbo.service.inf.IProviderServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
        //死循环--主要用于测试dubbo的监控统计
        while (true){
            try{
                String msg="";
                msg=providerService.sayHello("哈哈哈~");
                System.out.println("");
                System.out.println(msg);
                System.out.println("");
                System.out.println("upload file--providerService.uploadFile");
                providerService.uploadFile(fileToByteArray());
                System.out.println("upload file ok");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }
    //将文件转化为byte[]
    public static byte[] fileToByteArray()
    {
        FileInputStream fileInputStream = null;
        //File file = new File("F:\\1\\ZE1217010002_13241169628_52.pdf");
        File file = new File("F:\\1\\ZE1217010002_13241169628_52.pdf");
        byte[] bFile = null;
        try {
            bFile = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            //debug-调试输入
//            for (int i = 0; i < bFile.length; i++) {
//                System.out.print((char) bFile[i]);
//            }
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                bFile.clone();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bFile;
    }
}
