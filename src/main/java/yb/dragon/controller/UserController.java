package yb.dragon.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yb.dragon.commom.User;
import yb.dragon.service.UserService;

@RestController
@CrossOrigin(value = "*") // 支持跨域
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/queryUserByAcc")
	public User queryUserByAcc(User auser) {
		String username = auser.getUsername();
		User user = userService.queryUserByAcc(username);
		return user;
	}

	/**
	 * 
	 * 传入参数username、password 创建成功flag返回true
	 * 
	 * @param username
	 * @param password
	 * @return flag
	 * 
	 */
	@RequestMapping("/creatUser")
	public boolean creatUser(User user) {
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
