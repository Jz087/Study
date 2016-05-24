package com.ysbn.videotrain.managesystem.service;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;

public interface ICreateTrainFlowService
{
	public void Flow_All(TrainInfoVo tvo,String vids,List<QuestionInfoVo> qvs,String sfor,String deps) throws Exception;
}
