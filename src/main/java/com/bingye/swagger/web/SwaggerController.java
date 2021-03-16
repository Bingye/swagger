package com.bingye.swagger.web;

import com.bingye.swagger.domain.po.User;
import io.swagger.annotations.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api("测试")
@RestController
public class SwaggerController {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("张三","123"));
        users.add(new User("李四","123"));
        users.add(new User("六二","123"));
    }

    @ApiOperation(value = "获取用户列表")
    //@ApiImplicitParam(name = "id",value = "用户ID",defaultValue = "1",required = true)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username",value = "账号",defaultValue = "bingye",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "123",required = true)
    })
    @GetMapping("/users/{username}/{password}")
    public List<User> getUsers(@PathVariable String username, @PathVariable String password){
        log.info("用户：{}，密码：{}",username,password);
        return users;
    }


    @ApiOperation(value = "用户信息")
    @GetMapping("/user")
    public List<User> getUser(User user){
        log.info("用户：{}",user);
        return users;
    }


}
