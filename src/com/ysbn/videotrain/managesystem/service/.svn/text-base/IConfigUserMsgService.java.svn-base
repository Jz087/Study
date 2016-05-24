package com.ysbn.videotrain.managesystem.service;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public interface IConfigUserMsgService
{

	public List<UserInfoVo> getOrganizeById(String depId) throws Exception;			//根据deparcode获取部门人员信息
	
	public List<UserInfoVo> getUserMsgByName(String userName) throws Exception;			//根据username查询人员信息
	
	public void newUserMsg(UserInfoVo uservo) throws Exception;				//新增用户
	
	public int upUserMsg(UserInfoVo uservo) throws Exception;				//修改用户信息
	
	public int delUset(String usericid) throws Exception;					//删除用户信息
	
	public List<UserInfoVo> getUserMsgByAgid(String agid) throws Exception;			//根据agencyid查询人员信息
	
}
