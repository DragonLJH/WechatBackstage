package yb.dragon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yb.dragon.commom.User;
import yb.dragon.dao.UserDao;

@Service("UserService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public User queryUserByAcc(String username) {
		User user = userDao.queryUserByAcc(username);
		return user;
	}

	public List<User> queryUser() {
		List<User> list = new ArrayList<User>();
		list = userDao.queryUser();
		return list;
	}

	public User queryUserByDomain(String domain) {
		User user = userDao.queryUserByDomain(domain);
		return user;
	}

	/**
	 * 
	 * 参数user 先判断user是否已存在数据库 1存在不再创建，返回false 2不存在则创建，返回true
	 * 
	 * @param user
	 * @return flag
	 * 
	 */
	@Transactional(rollbackFor = RuntimeException.class) // 异常回滚
	public boolean creatUser(User user) {
		boolean flag = false;
		User checkUser = userDao.queryUserByAcc(user.getUsername());
		if (checkUser == null) {
			userDao.creatUser(user);
			flag = true;
		}
		return flag;
	}

	@Transactional(rollbackFor = RuntimeException.class) // 异常回滚
	public boolean delectUser(String username) {
		boolean flag = false;
		userDao.delectUser(username);
		if (userDao.queryUserByAcc(username) == null) {
			flag = true;
		}
		return flag;
	}

	@Transactional(rollbackFor = RuntimeException.class) // 异常回滚
	public boolean updateUserByAcc(User user) {
		boolean flag = false;
		if (userDao.queryUserByDomain(user.getDomain()) instanceof User) {

		} else {
			String firstStr = userDao.queryUserByAcc(user.getUsername()).getDomain() == null ? ""
					: userDao.queryUserByAcc(user.getUsername()).getDomain();
			userDao.updateUserByAcc(user);
			String secondStr = userDao.queryUserByAcc(user.getUsername()).getDomain() == null ? ""
					: userDao.queryUserByAcc(user.getUsername()).getDomain();
			userDao.updateUserByAcc(user);
			if (!firstStr.equals(secondStr)) {
				flag = true;
			}
		}

		return flag;
	}

}
