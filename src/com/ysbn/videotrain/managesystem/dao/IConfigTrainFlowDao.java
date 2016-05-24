package com.ysbn.videotrain.managesystem.dao;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;

public interface IConfigTrainFlowDao
{

	public List<TrainInfoVo> getFlowMsg() throws Exception;			//获取培训信息
	
	public List<TrainInfoVo> getMsg(String cid) throws Exception;			//获取选中信息
	
	public int updateFlowMsg(TrainInfoVo tvo) throws Exception;		//修改
}
