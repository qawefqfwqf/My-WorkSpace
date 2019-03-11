package com.zzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:dubbo/consumer.xml")
@SpringBootApplication
public class ConsumerDubboSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDubboSpringbootApplication.class, args);

		System.out.println("======================服务消费者者启动成功=======================");

		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext(new String[] {"dubbo/consumer.xml"});
		// context.start();
		// HelloService demoService =
		// (HelloService)context.getBean("helloService"); // 获取远程服务代理
		// String hello = demoService.sayHello("dubbo"); // 执行远程方法
		// System.out.println( hello ); // 显示调用结果
	}

}
