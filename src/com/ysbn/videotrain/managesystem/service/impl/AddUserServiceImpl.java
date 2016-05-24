package com.ysbn.videotrain.managesystem.service.impl;

import java.util.List;

import com.ysbn.videotrain.managesystem.dao.IAddUserDao;
import com.ysbn.videotrain.managesystem.service.IAddUserService;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class AddUserServiceImpl implements IAddUserService{

	private IAddUserDao adusdao;
	
	
	public void setAdusdao(IAddUserDao adusdao) {
		this.adusdao = adusdao;
	}


	@Override
	public void UserAdd(UserInfoVo uservo) throws Exception {
		// TODO Auto-generated method stub
		adusdao.UserAdd(uservo);
	}



	@Override
	public void UsersAdd(List<UserInfoVo> userList) throws Exception
	{
		// TODO Auto-generated method stub
		adusdao.UsersAdd(userList);
	}

	
}
