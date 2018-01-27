package com.gong.security.service.impl;

import com.gong.security.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * Created by GongWenHua on 17.12.12.
 */
@Service
public class HelloService implements IHelloService{

    public void sayHello() {
        System.out.println("hello");
    }
}
