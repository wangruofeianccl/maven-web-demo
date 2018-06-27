package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //注解为控制器
@RequestMapping(value="/")    //截获所有路径的请求
public class HelloController {
	 @RequestMapping(value="/hello")   //把请求路由到对应的方法上
	    public String Hello(Model model){//model用来发生数据
	        model.addAttribute("messa", "Hello Liang");
	        return "hello";//路由到一个页面，这里是hello.jsp
	    }
}
