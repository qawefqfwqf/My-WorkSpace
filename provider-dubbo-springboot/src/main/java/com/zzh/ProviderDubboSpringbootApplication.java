package com.zzh;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:dubbo/provider.xml")
@SpringBootApplication
public class ProviderDubboSpringbootApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ProviderDubboSpringbootApplication.class, args);

		System.out.println("======================服务提供者启动成功=======================");
	}

}
