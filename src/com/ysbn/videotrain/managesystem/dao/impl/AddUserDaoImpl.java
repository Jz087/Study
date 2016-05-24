package com.ysbn.videotrain.managesystem.dao.impl;

import java.util.List;

import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.dao.IAddUserDao;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class AddUserDaoImpl implements IAddUserDao{

	private PersistDao persistDao;
	
	public void setPersistDao(PersistDao persistDao) {
		this.persistDao = persistDao;
	}

	@Override
	public void UserAdd(UserInfoVo uservo) throws Exception {
		// TODO Auto-generated method stub
		String sql="INSERT INTO DUSERMSG(UM_AGENCYID,UM_ICID,UM_USERNAME,UM_POSITION,UM_DEPARCODE)VALUES(USERMSG_ID.NEXTVAL,?,?,?,?)";
		Object[] args={uservo.getUser_icid(),uservo.getUser_name(),uservo.getUser_position(),uservo.getUser_deparcode()};
		
		try {
			
			persistDao.insert(sql, args);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Utility.Log.e(AddUserDaoImpl.class, e.getMessage());
		}
	}

	@Override
	public void UsersAdd(List<UserInfoVo> userList) throws Exception
	{
		// TODO Auto-generated method stub
		String sql="INSERT INTO DUSERMSG A(A.UM_AGENCYID,A.UM_ICID,A.UM_USERNAME,A.UM_POSITION,A.UM_DEPARCODE) VALUES(USERMSG_ID.NEXTVAL,?,?,?,(SELECT B.DC_DEPARCODE FROM SDEPARCONFIG B WHERE B.DC_DEPARNAME=? AND B.DC_BELONG=(SELECT C.DC_DEPARCODE FROM SDEPARCONFIG C  WHERE C.DC_DEPARNAME=? AND C.DC_BELONG=?)))";
		String sql1="INSERT INTO DUSERMSG A(A.UM_AGENCYID,A.UM_ICID,A.UM_USERNAME,A.UM_POSITION,A.UM_DEPARCODE) VALUES(USERMSG_ID.NEXTVAL,?,?,?,(SELECT B.DC_DEPARCODE FROM SDEPARCONFIG B WHERE B.DC_DEPARNAME=? AND B.DC_BELONG=? ))";
		for(int i=0;i<userList.size();i++)
		{
			UserInfoVo uservo = userList.get(i) ;
			
			String icid = uservo.getUser_icid();
			String name = uservo.getUser_name();
			String checkposition = uservo.getUser_position();
			String comp = uservo.getUser_company();
			String depname = uservo.getUser_department();
			String depcode = uservo.getUser_deparcode();
			if("公司领导".equals(checkposition))
			{
				checkposition="3";
			}else if("总经理助理".equals(checkposition))
			{
				checkposition="4";
			}else if("主任".equals(checkposition))
			{
				checkposition="5";
			}else if("副主任".equals(checkposition))
			{
				checkposition="6";
			}else if("主任助理".equals(checkposition))
			{
				checkposition="7";
			}else if("科长".equals(checkposition))
			{
				checkposition="8";
			}else
			{
				checkposition="9";
			}
			if("元申广电公司".equals(comp))
			{
				comp = "1";
			}else if("有线电视公司".equals(comp))
			{
				comp = "2";
			}
			
			Object[] args={icid,name,checkposition,depcode,depname,comp};
			Object[] args1={icid,name,checkposition,depcode,comp};
			
			if( depname.equals(depcode) )
			{
				persistDao.insert(sql1, args1);
			}else
			{
				persistDao.insert(sql, args);				
			}
/*			try {
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				Utility.Log.e(AddUserDaoImpl.class, e.getMessage());
			}
*/			
		}
		
		
		
		
	}

}
