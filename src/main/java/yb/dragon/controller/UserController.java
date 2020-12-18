package yb.dragon.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping("/queryUser")
	public List<User> queryUser(){
		List<User> list = new ArrayList<User>();
		list = userService.queryUser();
		return list;
	}

	@RequestMapping("/queryUserByAcc")
	public User queryUserByAcc(User auser) {
		User user = userService.queryUserByAcc(auser.getUsername());
		return user;
	}
	@RequestMapping("/queryUserByDomain")
	public User queryUserByDomain(User auser) {
		User user = userService.queryUserByDomain(auser.getDomain());
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
	public boolean delectUser(User user) {
		boolean flag = false;
		flag = userService.delectUser(user.getUsername());
		return flag;
	}
	
	@RequestMapping("/updateUserByAcc")
	public boolean updateUserByAcc(User user) {
		boolean flag = false;
		flag = userService.updateUserByAcc(user);
		return flag;
	}

}
