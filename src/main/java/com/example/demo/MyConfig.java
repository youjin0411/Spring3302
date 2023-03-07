package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig { //MyConfig도 Component와 등록됨.
    @Bean //Component와 비슷한 역할
    public MyBean helloMyBean() { //Bean이름은 메서드 이름이다. helloMyBean도 Component등록됨.
        return new MyBean(); //MyBean 타입의 객체를 생성함.
    }

    @Bean
    public Person helloMyPerson(){
        Person p = new Person("YuJin",19);
        p.setSomething("something");
        return p;
    }
}
