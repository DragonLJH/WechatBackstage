package yb.dragon.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yb.dragon.commom.User;
import yb.dragon.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/queryUserByAcc/{username}")
	public User queryUserByAcc(@PathVariable("username") String username) {
		User user = userService.queryUserByAcc(username);
		return user;
	}
	
	/**
	 * 
	 * 传入参数username、password
	 * 创建成功flag返回true
	 * 
	 * @param username
	 * @param password
	 * @return flag
	 * 
	 * */
	@RequestMapping("/creatUser")
	public boolean creatUser(@PathParam("username") String username,@PathParam("password") String password) {
		User user = new User();
		boolean flag = false;
		flag = userService.creatUser(user);
		return flag;
	}
	
	
	
	@RequestMapping("/delectUser")
	public boolean delectUser(@PathParam("username") String username) {
		boolean flag = false;
		flag = userService.delectUser(username);
		return flag;
	}
	
}
