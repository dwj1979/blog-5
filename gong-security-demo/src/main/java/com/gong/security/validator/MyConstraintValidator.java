package com.gong.security.validator;

import com.gong.security.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by GongWenHua on 17.12.12.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private IHelloService helloService;

    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.sayHello();
        System.out.println(o);
        return false;
    }
}
