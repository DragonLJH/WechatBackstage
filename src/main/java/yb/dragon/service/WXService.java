package yb.dragon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yb.dragon.commom.WX;
import yb.dragon.dao.WXDao;

@Service
public class WXService {

	@Autowired
	private WXDao wxDao;

	public List<WX> queryWxByUsername(String username) {
		List<WX> list = new ArrayList<WX>();
		list = wxDao.queryWxByUsername(username);
		return list;
	}

	@Transactional(rollbackFor = Exception.class) // 异常回滚
	public boolean creatWx(WX wx) {
		boolean flag = false;
		int first = wxDao.queryWxByUsername(wx.getUsername()).size();
		wxDao.creatWx(wx);
		int secend = wxDao.queryWxByUsername(wx.getUsername()).size();
		if (first < secend) {
			flag = true;
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class) // 异常回滚
	public boolean delectWx(String username) {
		boolean flag = false;
		int first = wxDao.queryWxByUsername(username).size();
		wxDao.delectWx(username);
		int secend = wxDao.queryWxByUsername(username).size();
		if (first > secend) {
			flag = true;
		}
		return flag;
	}

	@Transactional(rollbackFor = Exception.class) // 异常回滚
	public boolean delectWxByNumber(WX wx) {
		boolean flag = false;
		int first = wxDao.queryWxByUsername(wx.getUsername()).size();
		wxDao.delectWxByNumber(wx);
		int secend = wxDao.queryWxByUsername(wx.getUsername()).size();
		if (first > secend) {
			flag = true;
		}
		return flag;
	}

}
