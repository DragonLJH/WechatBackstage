package yb.dragon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yb.dragon.commom.WX;
import yb.dragon.service.WXService;

@RestController
@CrossOrigin(value = "*") // 支持跨域
public class WXController {
	
	@Autowired
	private WXService wxService;
	
//	@Autowired
//	private UserService userService;

	@RequestMapping("/queryWx")
	public List<WX> queryWxByUsername(WX wx){
		List<WX> list = new ArrayList<WX>();
		list = wxService.queryWxByUsername(wx.getUsername());
		return list;
	}
	
//	@RequestMapping("/queryWXUserByDomain")
//	public List<WX> queryWXUserByDomain(@PathParam("domain")String domain) {
//		User user = userService.queryUserByDomain(domain);
//		List<WX> list = wxService.queryWxByUsername(user.getUsername());
//		return list;
//	}
	
	@RequestMapping("/creatWx")
	public boolean creatWx(WX wx) {
		boolean flag = false;
		flag = wxService.creatWx(wx);
		return flag;
	}
	
	@RequestMapping("/delectAllWx")
	public boolean delectWx(WX wx) {
		boolean flag = false;
		flag = wxService.delectWx(wx.getUsername());
		return flag;
	}
	
	@RequestMapping("/delectWx")
	public boolean delectWxByNumber(WX wx) {
		boolean flag = false;
		flag = wxService.delectWxByNumber(wx);
		return flag;
	}
	
}
