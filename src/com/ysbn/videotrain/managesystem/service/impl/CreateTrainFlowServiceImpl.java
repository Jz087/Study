package com.ysbn.videotrain.managesystem.service.impl;

import java.util.List;

import com.ysbn.videotrain.managesystem.dao.ICreateTrainFlowDao;
import com.ysbn.videotrain.managesystem.service.ICreateTrainFlowService;
import com.ysbn.videotrain.managesystem.vo.CheckedVideoVo;
import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;

public class CreateTrainFlowServiceImpl implements ICreateTrainFlowService
{

	private ICreateTrainFlowDao ctfDao;
	
	public void setCtfDao(ICreateTrainFlowDao ctfDao)
	{
		this.ctfDao = ctfDao;
	}

	

	@Override
	public void Flow_All(TrainInfoVo tvo, String vids,
			List<QuestionInfoVo> qvs,String sfor, String deps) throws Exception
	{
		// TODO Auto-generated method stub
		ctfDao.Flow_All(tvo, vids, qvs, sfor,deps);
	}

}
