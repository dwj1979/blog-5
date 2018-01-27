package com.gong.security.web.controller;

import com.gong.security.persistence.dto.UserQueryCondition;
import com.gong.security.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GongWenHua on 17.12.11.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails user){
        return user;
    }

    @GetMapping
    @ApiOperation("分页查询所有用户")
    public List<User> users(@PageableDefault(page = 1,size = 10,sort = {"age","userName"},direction = Sort.Direction.ASC) Pageable pageable){
        List<User> users = new LinkedList<User>();
        users.add(new User("gong","123","1",20));
        users.add(new User("xu","456","2",20));
        users.add(new User("feng","789","1",20));
        return users;
    }

    @GetMapping("/{userId:\\d+}")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId",value = "用户ID",dataType = "string",paramType = "query")})
    public User getUser(@PathVariable("userId") String userId){
        return new User("gong","123","1",20);
    }

    @PostMapping("/{userId:\\d+}")
    public void createUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach( error -> {
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user);
    }

    @PutMapping("/{userId:\\d+}")
    public void updateUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach( error -> {
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user);
    }

    @GetMapping("/query")
    public List<User> users(UserQueryCondition userQueryCondition,
                            @PageableDefault(page = 1,size = 10,sort = {"age","userName"},direction = Sort.Direction.ASC) Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(ReflectionToStringBuilder.toString(pageable.getSort(), ToStringStyle.MULTI_LINE_STYLE));
        List<User> users = new LinkedList<User>();
        users.add(new User("gong","123","1",20));
        users.add(new User("gong","123","1",20));
        users.add(new User("gong","123","1",20));
        return users;
    }
}
