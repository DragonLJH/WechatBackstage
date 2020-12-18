package yb.dragon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import yb.dragon.commom.User;

@Mapper
public interface UserDao {
	
	@Select("SELECT id,username,password,domain FROM user")
	public List<User> queryUser();
	
	@Select("SELECT id,username,password,domain FROM user where username = #{username} limit 1;  ")
	public User queryUserByAcc(String username);
	
	@Select("SELECT id,username,password,domain FROM user where domain = #{domain} limit 1;  ")
	public User queryUserByDomain(String domain);

	@Insert("INSERT INTO user (username,password) VALUES (#{username}, #{password});")
	public void creatUser(User user);

	@Delete("DELETE FROM user WHERE username = #{username} limit 1;")
	public void delectUser(String username);
	
	@Update("UPDATE user SET domain = #{domain} WHERE (username = #{username});")
	public void updateUserByAcc(User user);
}
