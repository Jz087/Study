package com.ysbn.videotrain.managesystem.dao;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public interface IAddUserDao {

	public void UserAdd(UserInfoVo uservo) throws Exception;		//添加人员信息(手动)
	
	public void UsersAdd(List<UserInfoVo> userList) throws Exception;		//excel
}
