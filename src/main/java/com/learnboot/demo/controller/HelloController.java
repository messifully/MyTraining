package com.learnboot.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@Api("swaggerDemoController相关的api")
@RequestMapping("api")
public class HelloController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/hello")
    @ApiOperation("添加用户的接口")
    public String index() {
        redisTemplate.opsForValue().set("name", "redis");
        String rs = redisTemplate.opsForValue().get("name");
        return "Hello World:" + rs;
    }

    @GetMapping("/testCookies")
    public String cookies(HttpServletResponse response){
        response.addCookie(new Cookie("testUser","fang"));
        return "cookies";
    }

    @RequestMapping("/testRequest")
    @ResponseBody
    public String testSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("testSession","this is my http session");
        return "testHttpSession";
    }

    @RequestMapping("/testSession")
    @ResponseBody
    public String testSession(HttpSession session){
        session.setAttribute("testSession","this is my session");
        return "testSession";
    }

    @RequestMapping("/testGetSession")
    @ResponseBody
    public String testGetSession(HttpSession session){
        Object testSession = session.getAttribute("testSession");
        return String.valueOf(testSession);
    }


}
