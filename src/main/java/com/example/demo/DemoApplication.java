package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		//ApplicationContext는 IOC 콘테이너(보따리)의 역할을 한다.
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		//context의 실제 클래스 이름을 출력함. (어노테이션 기반으로 하는 것이다. )
		System.out.println(context.getClass().getName());
		String[] beanNames = context.getBeanDefinitionNames();
		//확인해보기
		for (String beanName : beanNames) {
			//우리가 만들지 않은 org. 이나 spring.으로 시작하는 것들을 거르고 출력시킴.
			if(!beanName.startsWith("org.") && !beanName.startsWith("spring.")){
				System.out.println(beanName);
			}
		}
	}

}
