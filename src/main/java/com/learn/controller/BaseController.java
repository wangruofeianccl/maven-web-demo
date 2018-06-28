package com.learn.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(UserController.class);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String,Object> ret =new HashMap();
}
