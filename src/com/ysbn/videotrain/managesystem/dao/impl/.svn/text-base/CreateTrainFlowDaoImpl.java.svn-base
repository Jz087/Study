package com.ysbn.videotrain.managesystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.dao.ICreateTrainFlowDao;
import com.ysbn.videotrain.managesystem.vo.CheckedVideoVo;
import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class CreateTrainFlowDaoImpl implements ICreateTrainFlowDao
{

	private PersistDao persistDao;
	
	public void setPersistDao(PersistDao persistDao) {
		this.persistDao = persistDao;
	}

	@SuppressWarnings("unchecked")
    @Override
	public void Flow_All(TrainInfoVo tvo, String vids,
			List<QuestionInfoVo> qvs,String sfor, String deps) throws Exception
	{
		// TODO Auto-generated method stub
		
		String sql1 = "INSERT INTO DCULRECORD(CR_AGENCYID,CR_CULID,CR_CULNAME,CR_STUDYSTART,CR_STUDYEND,CR_CREATETIME,CR_DESCRIBE) VALUES(CR_ID.NEXTVAL,?,?,?,?, (SELECT TO_CHAR(SYSDATE，'YYYYMMDD') NOW FROM DUAL),?)";
		Object[] args1={ tvo.getCulid(),tvo.getCulname(),tvo.getStudytime(),tvo.getStudyend(),tvo.getDescribe() };
		persistDao.insert(sql1, args1);
		String sqlid="SELECT CR_AGENCYID FROM DCULRECORD WHERE CR_CULNAME=? AND CR_CULID=? AND CR_STUDYSTART=? AND CR_STUDYEND=? ";
        Object[] argsid={tvo.getCulname(),tvo.getCulid(),tvo.getStudytime(),tvo.getStudyend()};
        List<String> crid = persistDao.selectListBySQL(sqlid, argsid, new RowMapper()
        {
            public String mapRow(ResultSet rs,int index) throws SQLException
            {
                String uservo = rs.getString(1) ;
                return uservo;
            }
        }
        ); 
        String cid = crid.get(0);
		String sql2="INSERT INTO SCULVIDEORELAT S (S.CVR_AGENCYID,S.CVR_CRAGENID,S.CVR_SETVIAGENID) VALUES(SCULAT_ID.NEXTVAL,?,?)";
		Object[] args2={cid,vids};
		persistDao.insert(sql2, args2);
	/*	String sql33 = "INSERT INTO DEXAMPAPER A (A.EP_AGENCYID,A.EP_NAME,A.EP_QIAGENID) VALUES (EP_ID.NEXTVAL,?,'1')";
		Object[] args33={qname};
		persistDao.insert(sql33, args33);*/
	
		String vid = qvs.get(0).getViid();
		String qname = qvs.get(0).getQname();
		int juanzi = qvs.get(0).getJuanzi();
		int qnums = qvs.get(0).getQuestion_nums();
		int vv = qvs.get(0).getVv();
		for(int i=0;i<qvs.size();i++)
		{

			if( !qname.equals(qvs.get(i).getQname()) )
			{			
				String sql34="INSERT INTO DEXAMPAPER DE (DE.EP_AGENCYID,DE.EP_NAME,DE.EP_QIAGENID) VALUES (EP_ID.NEXTVAL,?,(SELECT LISTAGG(EI_AGENCYID,',') WITHIN GROUP (ORDER BY EI_AGENCYID DESC) FROM(SELECT D.EI_AGENCYID FROM DQUESTIONINFO D ORDER BY D.EI_AGENCYID DESC)A WHERE ROWNUM<=?))";
				Object[] args34={ qname,qnums };
				qname = qvs.get(i).getQname();
				qnums = qvs.get(i).getQuestion_nums();
				persistDao.update(sql34, args34);
				
				if( !vid.equals(qvs.get(i).getViid()) )
				{
					//vv = qvs.get(0).getVv();
					String sql32="INSERT INTO SCULDEPRELATION SC(SC.CDR_AGENCYID,SC.CDR_VIAGENID,SC.CDR_SETEPAGENID,SC.CDR_CRAGENID) VALUES(SCUTION_ID.NEXTVAL,?,(SELECT LISTAGG(EP_AGENCYID,',') WITHIN GROUP (ORDER BY EP_AGENCYID DESC) FROM(SELECT D.EP_AGENCYID FROM DEXAMPAPER D ORDER BY D.EP_AGENCYID DESC)A WHERE ROWNUM<=?),?)";
					Object[] args32={vid,juanzi,cid};
					/*String sql333="UPDATE DVIDEOINFO SET VI_PUBLISHFLAG=0 WHERE VI_AGENCYID=?";
					Object[] args333={vid};*/
					vid = qvs.get(i).getViid();
					juanzi = qvs.get(i).getJuanzi();
					persistDao.insert(sql32, args32);
					
				}
			}
			
			String sql31="INSERT INTO DQUESTIONINFO D (D.EI_AGENCYID,D.EI_QUESTION,D.EI_ANSWERA,D.EI_ANSWERB,D.EI_ANSWERC,D.EI_ANSWERD,D.EI_ANSWER) VALUES( DQUESTION_ID.NEXTVAL,?,?,?,?,?,?)";
			Object[] args31={qvs.get(i).getQuestion(),qvs.get(i).getAnswera(),qvs.get(i).getAnswerb(),qvs.get(i).getAnswerc(),qvs.get(i).getAnswerd(),qvs.get(i).getAnswer()};
			persistDao.insert(sql31, args31);
			
			if(i == qvs.size()-1  )
			{			
				String sql34="INSERT INTO DEXAMPAPER DE (DE.EP_AGENCYID,DE.EP_NAME,DE.EP_QIAGENID) VALUES (EP_ID.NEXTVAL,?,(SELECT LISTAGG(EI_AGENCYID,',') WITHIN GROUP (ORDER BY EI_AGENCYID DESC) FROM(SELECT D.EI_AGENCYID FROM DQUESTIONINFO D ORDER BY D.EI_AGENCYID DESC)A WHERE ROWNUM<=?))";
				Object[] args34={ qname,qnums };
				persistDao.update(sql34, args34);
				
				String sql32="INSERT INTO SCULDEPRELATION SC(SC.CDR_AGENCYID,SC.CDR_VIAGENID,SC.CDR_SETEPAGENID,SC.CDR_CRAGENID) VALUES(SCUTION_ID.NEXTVAL,?,(SELECT LISTAGG(EP_AGENCYID,',') WITHIN GROUP (ORDER BY EP_AGENCYID DESC) FROM(SELECT D.EP_AGENCYID FROM DEXAMPAPER D ORDER BY D.EP_AGENCYID DESC)A WHERE ROWNUM<=?),?)";
				Object[] args32={vid,juanzi,cid};
				persistDao.insert(sql32, args32);
			}
			
		}
		/*if( 1 == vv && 1 == juanzi)
		{
			String sql34="INSERT INTO DEXAMPAPER DE (DE.EP_AGENCYID,DE.EP_NAME,DE.EP_QIAGENID) VALUES (EP_ID.NEXTVAL,?,(SELECT LISTAGG(EI_AGENCYID,',') WITHIN GROUP (ORDER BY EI_AGENCYID DESC) FROM(SELECT D.EI_AGENCYID FROM DQUESTIONINFO D ORDER BY D.EI_AGENCYID DESC)A WHERE ROWNUM<=?))";
			Object[] args34={ qname,qnums };
			persistDao.update(sql34, args34);
			String sql32="INSERT INTO SCULDEPRELATION SC(SC.CDR_AGENCYID,SC.CDR_CRAGENID,SC.CDR_SETEPAGENID) VALUES(SCUTION_ID.NEXTVAL,?,(SELECT LISTAGG(EP_AGENCYID,',') WITHIN GROUP (ORDER BY EP_AGENCYID DESC) FROM(SELECT D.EP_AGENCYID FROM DEXAMPAPER D ORDER BY D.EP_AGENCYID DESC)A WHERE ROWNUM<=?))";
			Object[] args32={vid,juanzi};
			persistDao.insert(sql32, args32);
		}*/
		
		/*{
			for(int i=0;i<qvs.size();i++)
			{
				Object[] args31={qvs.get(i).getQuestion(),qvs.get(i).getAnswera(),qvs.get(i).getAnswerb(),qvs.get(i).getAnswerc(),qvs.get(i).getAnswerd(),qvs.get(i).getAnswer()};
				persistDao.insert(sql31, args31);
			}
			
			String sql34="UPDATE DEXAMPAPER DE SET DE.EP_QIAGENID=(SELECT LISTAGG(EI_AGENCYID,',') WITHIN GROUP (ORDER BY EI_AGENCYID DESC) FROM(SELECT D.EI_AGENCYID FROM DQUESTIONINFO D ORDER BY D.EI_AGENCYID DESC)A WHERE ROWNUM<=?) WHERE DE.EP_NAME=?";
			Object[] args34={qnums,qname};
			persistDao.update(sql34, args34);
			
			String sql32="INSERT INTO SCULDEPRELATION S(S.CDR_AGENCYID,S.CDR_CRAGENID,S.CDR_SETEPAGENID) VALUES(SCUTION_ID.NEXTVAL,?,( SELECT LISTAGG(EP_AGENCYID,',') WITHIN GROUP (ORDER BY EP_AGENCYID DESC) FROM(SELECT D.EP_AGENCYID FROM DEXAMPAPER D ORDER BY D.EP_AGENCYID DESC)A WHERE ROWNUM<=?))";
			Object[] args32={vid,juanzi};
			persistDao.insert(sql32, args32);
		}*/
		
		String sql41="INSERT INTO DUSERCUL D (D.EC_AGENCYID,D.EC_CRAGENID,D.EC_ICID) VALUES(DUCUL_ID.NEXTVAL,?,? )";
		String sql42="SELECT UM_ICID FROM DUSERMSG WHERE UM_DEPARCODE=? ";
		String sql43="SELECT UM_ICID FROM DUSERMSG WHERE UM_POSITION=? ";
		
		String[] dep = deps.split("\\,");
		String depcode="";
		for(int i=0;i<dep.length;i++)
		{
			depcode=dep[i];
			if("ff1".equals(sfor))
			{
				Object[] args42={depcode};
				@SuppressWarnings({ "rawtypes", "unchecked" })
				List<UserInfoVo> IcidList = persistDao.selectListBySQL(sql42, args42, new RowMapper()
					{
						public UserInfoVo mapRow(ResultSet rs,int index) throws SQLException
						{
							UserInfoVo uservo = new UserInfoVo();
							uservo.setUser_icid(rs.getString("UM_ICID"));
							return uservo;
						}
					}
				); 
				if( null != IcidList && !"".equals(IcidList) )
				{
					for(int j=0;j<IcidList.size();j++)
					{
						Object[] args41={cid,IcidList.get(j).getUser_icid()};
						persistDao.insert(sql41, args41);
					}
				}
			}else
			{
				Object[] args43={depcode};
				@SuppressWarnings({ "rawtypes", "unchecked" })
				List<UserInfoVo> IcidList = persistDao.selectListBySQL(sql43, args43, new RowMapper()
					{
						public UserInfoVo mapRow(ResultSet rs,int index) throws SQLException
						{
							UserInfoVo uservo = new UserInfoVo();
							uservo.setUser_icid(rs.getString("UM_ICID"));
							return uservo;
						}
					}
				); 
				if( null != IcidList && !"".equals(IcidList) && 0!=IcidList.size() )
				{
					for(int j=0;j<IcidList.size();j++)
					{
						Object[] args41={cid,IcidList.get(j).getUser_icid()};
						persistDao.insert(sql41, args41);
					}
				}
			}
		}
		
		
	}
	
	
}
