package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //@Component 라고 어노테이션을 붙여넣음(빈 객체로 등록됨. )
//DemoApplication을 실행하면 보따리 안에 myBean이 출력되는 것을 확인할 수 있음.
//출력 시 Bean이름을 수동으로 지정하지 않으면 클래스 이름을 카멜 케이스로 출력시킴 -> myBean
//수동으로 지정하고 싶다면 -> @Component(HelloName)
@Scope("prototype")
public class MyBean {
    // 생성자가 없으면 자동으로 만들어지기 때문에 얘는 실행이 잘 됨.
}
