package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
//새로운 프로퍼티 파일 생성 시 (myconfig.properties)
@PropertySource("classpath:myconfig.properties")
public class GrettingService {
    // Value 어노테이션을 이용해서 설정값 주입하기, 달러 기호와 중괄호 사용은 필수
// (이후 자동으로 message의 값이 "Hello!"로 설정됨)
//    @Value("${greeting.message}")
    @Value("${myconfig.some.value}")
    private String message;
    public void greet() {
        System.out.println(message);
    }
}
