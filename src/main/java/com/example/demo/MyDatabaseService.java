package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

public class MyDatabaseService {
    @Autowired
    CrudRepository repository; //에러 발생

    // CrudRepository가 2개이므로 오류가 발생함.
    //추천하지 않는 방법 1.
    //2개의 인터페이스, 클래스 중에 더 중요한 주가 되는 클래스나 인터페이스에 @Repository 아래에 @Primary 추가함.
    //방법 2.
    //Qualifier("simpleCuredRepositoryImpl") 추가해주기
}
