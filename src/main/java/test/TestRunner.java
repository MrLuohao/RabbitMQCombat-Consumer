package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Title: TestRunner
 * @Author Mr.罗
 * @Package test
 * @Date 2023/12/4 17:35
 * @description: 测试项目
 */
public class TestRunner {
    public static void main(String[] args) throws Exception {
        //获得spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-Consumer.xml");
        //让程序一直运行,别终止
        System.in.read();
    }
}
