package yb.dragon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

	@RequestMapping("/queryWx")
	public List<WX> queryWxByUsername(@PathParam("username") String username){
		List<WX> list = new ArrayList<WX>();
		list = wxService.queryWxByUsername(username);
		return list;
	}
	
	@RequestMapping("/creatWx")
	public boolean creatWx(@PathParam("username") String username,@PathParam("wxnumber") String wxnumber) {
		WX wx = new WX();
		wx.setUsername(username);
		wx.setWxnumber(wxnumber);
		boolean flag = false;
		flag = wxService.creatWx(wx);
		return flag;
	}
	
	@RequestMapping("/delectAllWx")
	public boolean delectWx(@PathParam("username") String username) {
		boolean flag = false;
		flag = wxService.delectWx(username);
		return flag;
	}
	
	@RequestMapping("/delectWx")
	public boolean delectWxByNumber(@PathParam("username") String username,@PathParam("wxnumber") String wxnumber) {
		WX wx = new WX();
		wx.setUsername(username);
		wx.setWxnumber(wxnumber);
		boolean flag = false;
		flag = wxService.delectWxByNumber(wx);
		return flag;
	}
	
}
