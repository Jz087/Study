package com.ysbn.videotrain.managesystem.service.impl;

import java.util.List;

import com.ysbn.videotrain.managesystem.dao.IConfigUserMsgDao;
import com.ysbn.videotrain.managesystem.service.IConfigUserMsgService;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class ConfigUserMsgServiceImpl implements IConfigUserMsgService
{
	private IConfigUserMsgDao configUserDao;

	public IConfigUserMsgDao getConfigUserDao()
	{
		return configUserDao;
	}

	public void setConfigUserDao(IConfigUserMsgDao configUserDao)
	{
		this.configUserDao = configUserDao;
	}

	@Override
	public List<UserInfoVo> getOrganizeById(String depId) throws Exception
	{
		// TODO Auto-generated method stub
		return configUserDao.getOrganizeById(depId);
	}

	@Override
	public List<UserInfoVo> getUserMsgByName(String userName) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int upUserMsg(UserInfoVo uservo) throws Exception
	{
		// TODO Auto-generated method stub
		return configUserDao.upUserMsg(uservo);
	}

	@Override
	public int delUset(String usericid) throws Exception
	{
		// TODO Auto-generated method stub
		return configUserDao.delUset(usericid);
	}

	@Override
	public void newUserMsg(UserInfoVo uservo) throws Exception
	{
		// TODO Auto-generated method stub
		configUserDao.newUserMsg(uservo);
	}

	@Override
	public List<UserInfoVo> getUserMsgByAgid(String agid) throws Exception
	{
		// TODO Auto-generated method stub
		return configUserDao.getUserMsgByAgid(agid);
	}

}
