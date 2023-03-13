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

		//자바 11 버전 이상부터 자동으로 형을 만들어줘서 클래스를 붙여주지 않아도 빈을 꺼내올 수 있다.
//		var person = (Person) context.getBean(Person.class);

		//Configuration을 활용하여 Person 클래스를 2개를 생성했을 경우 에러가 발생함. 그때는 이걸 사용하면 안 됨.
//		Person person = (Person) context.getBean(Person.class); //클래스 이름으로 꺼내올 수도 있다.
		//MyConfig 파일
		var helloperson = (Person) context.getBean("helloMyPerson");
		//Person 파일
		var person = (Person) context.getBean("person");
		System.out.println(person);

		var carculatorServeice = (MyCalculatorService) context.getBean(MyCalculatorService.class);
		System.out.println(carculatorServeice.calcAdd(5,3));
















		MyBean myBean1 = (MyBean) context.getBean("myBean");
		MyBean myBean2 = (MyBean) context.getBean("myBean");
		//싱글턴으로 인해서 Mybean 객체는 하나이므로 myBean1과 myBean2는 같은 객체를
		//호출해주는 것으므로 == 비교시 주소가 같으므로 True가 나온다.
		System.out.println(myBean1 == myBean2);

		//아래에서 발생할 수 있는 문제점은 GrettingService.class에서 Gretting 클래스가 2개이상이면 오류 발생할 수 있음.
		//그러나 지금은 괜찮음.
		GrettingService grettingService = (GrettingService) context.getBean(GrettingService.class);
		grettingService.greet(); //Hello! 출력
	}

}
