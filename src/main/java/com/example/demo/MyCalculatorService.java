package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyCalculatorService {
    // 해당 필드(calculator)에 의존성 주입이 진행될 수 있도록 Autowired 어노테이션을 적용
    //보통 클래스 생성 후 필드를 만드는데 그렇기 할 필요없이 필드 앞에 @Autowired만 생성해주면 자동으로 spring이 해줌.

    /* 방법1. 필드 주입 방법
    @Autowired //의존성 주입과 관련된 어노테이션
    private Calculator calculator; //calculator에 값을 넣어주지 않았지만 spring이 자동으로 대입을 해주는 의존성 주입이다.
    */

    /* 방법2 생성자 주입 보통 사람들이 추천하는 방법이 생성자 주입이다.
    private Calculator calculator;

    @Autowired
    public MyCalculatorService(Calculator calculator){
        //calculator 멤버변수는 Null값을 가지고 있기 때문에 오류가 발생해야 하는데 spring이 똑똑해서 실행이 됨.
        //private Calculator calculator이 Null 즉 값이 없을 때 앞에 @Autowired이 있어야 함.
        this.calculator = calculator;
    }
    */
    //방법3. 세터 주입 
    private Calculator calculator; //calculator가 Null 대입된 값이 없을 때 에러가 발생하기 때문에 이 멤버변수를 사용하는 메서드 앞에 @Autowired를 붙여줌.
    @Autowired
    public void setCalculator(Calculator calculator){
        this.calculator = calculator;
    }
    public int calcAdd(int a, int b) {
        return calculator.add(a, b);
    }

    @Autowired //이기적인 코딩 방법 ~~ 보따리 안에 포함만 시키자!~!
    //Person처럼 이미 DemoApplication에 Person 클래스가 이미 하나가 존재해서 총 2개 될 경우에는 @Qualifier를 활용해서 Bean의 이름을 정해줌. 그러면 오류가 발생하지 않음.
    public void iNeedDependency(MyBean myBean, @Qualifier("helloMyPerson") Person p, Calculator c){
        System.out.println(myBean);
        System.out.println(p);
        System.out.println(c);
    }
}
