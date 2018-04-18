package com.liuchunshu.novels.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.liuchunshu.novels.common.JsonUtils;
import com.liuchunshu.novels.common.JwtToken;
import com.liuchunshu.novels.model.UserEntity;
import com.liuchunshu.novels.service.UserService;

@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Value("${JWTToken}")
	private String screat;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		String token=JwtToken.createToken(screat);
		model.addObject("token", token);
		logger.info("Hello World,index request!");
		return model;
	}

	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users = userService.getAll();
		return users;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String getUser(int id) {
		UserEntity user = userService.getOne(id);
		String str = JsonUtils.formatEnumValueWithNoField(user, new String[] { "password" });
		return str;
	}

	@RequestMapping("/add")
	public void save(UserEntity user) {
		userService.insert(user);
	}

	@RequestMapping(value = "update")
	public void update(UserEntity user) {
		userService.update(user);
	}

	@RequestMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		userService.delete(id);
	}

}