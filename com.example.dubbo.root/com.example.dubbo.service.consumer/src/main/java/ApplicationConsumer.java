import com.example.dubbo.service.inf.IProviderServiceInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2017/1/21.
 */
@SpringBootApplication
@ComponentScan("com.example.dubbo.service.consumer")
@ImportResource("classpath:example-dubbo-consumer.xml")
public class ApplicationConsumer {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationConsumer.class);
    public static void main(String[] args) throws Exception {
//        参考：
//        HadesJK/dubbo-demo-dubbo-xml配置方案-超级赞-byArvin
//        https://github.com/HadesJK/dubbo-demo
//        目录：
//        1.负载均衡
//        2.直连提供者-这个功能为开发测试用的，绕过注册中心，只测试指定服务提供者。（令牌验证-防止消费者绕过注册中心访问提供者）
//        3.只订阅（直连提供者的更高级策略）-服务提供者的配置文件中，禁止向注册中心注册
//        4.多协议暴露服务-发布了3个服务，1个用dubbo暴露，1个用hessian暴露，1个用dubbo/hessian都暴露
//        5.服务分组-当一个接口有多种实现时，可以用group区分
//        6.多版本--当一个接口实现，出现不兼容升级时，可以用版本号过渡，版本号不同的服务相互间不引用
//        7.回声测试--能够测试整个调用是否通畅，可用于监控
//        8.隐式传参--用于框架集成，不建议常规业务使用。尽量不要用！尽量不要用！
//        9.事件通知--异步模式下，该通知就非常有用了
//        10.令牌验证--防止消费者绕过注册中心访问提供者、在注册中心控制权限，以决定要不要下发令牌给消费者、注册中心可灵活改变授权方式，而不需修改或升级提供者
        logger.info("项目启动--BEGIN");
        SpringApplication.run(ApplicationConsumer.class, args);
        System.in.read();
    }
}
