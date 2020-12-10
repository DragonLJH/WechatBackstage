package yb.dragon.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import yb.dragon.commom.User;

@Mapper
public interface UserDao {

	@Select("SELECT id,username,password FROM user where username = #{username} limit 1;  ")
	public User queryUserByAcc(String username);

	@Insert("INSERT INTO user (username,password) VALUES (#{username}, #{password});")
	public void creatUser(User user);

	@Delete("DELETE FROM user WHERE username = #{username} limit 1;")
	public void delectUser(String username);
}
