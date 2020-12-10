package yb.dragon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import yb.dragon.commom.WX;

@Mapper
public interface WXDao {

	@Select("SELECT id,username,wxnumber FROM wx where username = #{username};")
	public List<WX> queryWxByUsername(String username);
	
	@Insert("INSERT INTO wx (username,wxnumber) VALUES (#{username}, #{wxnumber});")
	public void creatWx(WX wx);

	@Delete("DELETE FROM wx WHERE username = #{username};")
	public void delectWx(String username);
	
	@Delete("DELETE FROM wx WHERE username = #{username} and wxnumber = #{wxnumber};")
	public void delectWxByNumber(WX wx);
	
}
