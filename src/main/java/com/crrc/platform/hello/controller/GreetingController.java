package com.crrc.platform.hello.controller;

import com.crrc.platform.hello.dto.Greeting;
import com.crrc.platform.hello.mapper.UserMapper;
import com.crrc.platform.hello.model.JsSysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @author mikejn
 */
@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Logger logger= LoggerFactory.getLogger(GreetingController.class);
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<JsSysUser>  userList=userMapper.getAll();
        userList.stream().forEach(b->{logger.debug("userList--->"+b.getUserCode());});
        return new Greeting(counter.incrementAndGet(),
                            String.format(TEMPLATE, name));
    }

    @RequestMapping("/users")
    public List<JsSysUser>  users() {
        List<JsSysUser>  userList=userMapper.getAll();
        logger.debug("user list number of --->"+userList.size());
        userList.stream().forEach(b->{logger.debug("userList--->"+b.getUserCode());});
        return userList;
    }
}