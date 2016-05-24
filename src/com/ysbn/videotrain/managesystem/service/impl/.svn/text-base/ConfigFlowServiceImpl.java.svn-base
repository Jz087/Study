package com.ysbn.videotrain.managesystem.service.impl;

import java.util.List;

import com.ysbn.videotrain.managesystem.dao.IConfigTrainFlowDao;
import com.ysbn.videotrain.managesystem.service.IConfigFlowService;
import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;

public class ConfigFlowServiceImpl implements IConfigFlowService
{

	private IConfigTrainFlowDao configTrainDao;
	
	public IConfigTrainFlowDao getConfigTrainDao()
	{
		return configTrainDao;
	}

	public void setConfigTrainDao(IConfigTrainFlowDao configTrainDao)
	{
		this.configTrainDao = configTrainDao;
	}

	@Override
	public List<TrainInfoVo> getFlowMsg() throws Exception
	{
		// TODO Auto-generated method stub
		return configTrainDao.getFlowMsg();
	}

	@Override
	public List<TrainInfoVo> getMsg(String cid) throws Exception
	{
		// TODO Auto-generated method stub
		return configTrainDao.getMsg(cid);
	}

	@Override
	public int updateFlowMsg(TrainInfoVo tvo) throws Exception
	{
		// TODO Auto-generated method stub
		return configTrainDao.updateFlowMsg(tvo);
	}

}
