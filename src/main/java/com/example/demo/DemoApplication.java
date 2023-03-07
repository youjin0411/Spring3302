package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*  @SpringBootApplication안에 포함되어 있다.
	@SpringBootConfiguration
	@EnableAutoConfiguration
	@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
			@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
* */
@SpringBootApplication //SpringBootApplication은 어노테이션의 최상위 레벨이므로 다 담고 있어서 Component가 없어도 사용가능.
//Component 스캔 대상은 DemoApplication 폴더가 들어있는 폴더의 하위 클래스들이다. 즉 다른 패키지에서는 스캔이 되지 않음.
//이런식으로 다른 패키지 안에 있는 클래스 스캔할 수 있음.  @ComponentScan(basePackages = {"com.example.demo", "hello"})

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
		MyBean myBean = (MyBean) context.getBean("myBean"); //Bean을 꺼내올 때는 카멜케이스 형식으로 꺼내와야 한다.
//		Person person = (Person) context.getBean("person");
		Person person = (Person) context.getBean(Person.class); //클래스 이름으로 꺼내올 수도 있다.

		//자바 11 버전 이상부터 자동으로 형을 만들어줘서 클래스를 붙여주지 않아도 빈을 꺼내올 수 있다.
//		var person = (Person) context.getBean(Person.class);

		System.out.println(person);
	}

}
