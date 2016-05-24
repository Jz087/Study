package com.ysbn.videotrain.managesystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ysbn.videotrain.managesystem.dao.IConfigTrainFlowDao;
import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class ConfigTrainFlowDaoImpl implements IConfigTrainFlowDao
{
	private PersistDao persistDao;

	public PersistDao getPersistDao()
	{
		return persistDao;
	}

	public void setPersistDao(PersistDao persistDao)
	{
		this.persistDao = persistDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainInfoVo> getFlowMsg() throws Exception
	{
		// TODO Auto-generated method stub
		//String sql ="SELECT D.CR_AGENCYID,D.CR_CULID,D.CR_CULNAME,D.CR_STUDYSTART,D.CR_STUDYEND FROM DCULRECORD D WHERE (SELECT TO_CHAR(SYSDATE，'YYYYMMDD') NOW FROM DUAL) < D.CR_STUDYEND";
		String sql ="SELECT D.CR_AGENCYID,D.CR_CULID,D.CR_CULNAME,D.CR_STUDYSTART,D.CR_STUDYEND FROM DCULRECORD D ";
		Object[] args={};
		
		@SuppressWarnings("rawtypes")
		List<TrainInfoVo> trainList = persistDao.selectListBySQL(sql, args, new RowMapper()
				{
					public TrainInfoVo mapRow(ResultSet rs,int index) throws SQLException
					{
						TrainInfoVo tvo = new TrainInfoVo();
						tvo.setCi_id(rs.getString("CR_AGENCYID"));
						tvo.setCulid(rs.getString("CR_CULID"));
						tvo.setCulname(rs.getString("CR_CULNAME"));
						tvo.setStudytime(rs.getString("CR_STUDYSTART"));
						tvo.setStudyend(rs.getString("CR_STUDYEND"));
						
						return tvo;
						
					}
				}
		);
		return trainList;
	}

	@Override
	public List<TrainInfoVo> getMsg(String cid) throws Exception
	{
		// TODO Auto-generated method stub
		String sql ="SELECT D.CR_AGENCYID,D.CR_CULID,D.CR_CULNAME,D.CR_STUDYSTART,D.CR_STUDYEND FROM DCULRECORD D WHERE D.CR_AGENCYID=?";
		Object[] args={cid};
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<TrainInfoVo> trainList = persistDao.selectListBySQL(sql, args, new RowMapper()
				{
					public TrainInfoVo mapRow(ResultSet rs,int index) throws SQLException
					{
						TrainInfoVo tvo = new TrainInfoVo();
						tvo.setCi_id(rs.getString("CR_AGENCYID"));
						tvo.setCulid(rs.getString("CR_CULID"));
						tvo.setCulname(rs.getString("CR_CULNAME"));
						tvo.setStudytime(rs.getString("CR_STUDYSTART"));
						tvo.setStudyend(rs.getString("CR_STUDYEND"));
						
						return tvo;
						
					}
				}
		);
		return trainList;
	}

	@Override
	public int updateFlowMsg(TrainInfoVo tvo) throws Exception
	{
		// TODO Auto-generated method stub
		String sql="UPDATE DCULRECORD SET CR_CULID=?,CR_CULNAME=?,CR_STUDYSTART=?,CR_STUDYEND=? WHERE CR_AGENCYID=?";
		Object[] args={tvo.getCulid(),tvo.getCulname(),tvo.getStudytime(),tvo.getStudyend(),tvo.getCi_id()};
		
		return persistDao.update(sql, args);
	}
	
	

}
