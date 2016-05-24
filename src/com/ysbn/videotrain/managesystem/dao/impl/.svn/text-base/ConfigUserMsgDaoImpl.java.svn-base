package com.ysbn.videotrain.managesystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.dao.IAddUserDao;
import com.ysbn.videotrain.managesystem.dao.IConfigUserMsgDao;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class ConfigUserMsgDaoImpl implements IConfigUserMsgDao
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
	public List<UserInfoVo> getOrganizeById(String depId) throws Exception
	{
		// TODO Auto-generated method stub
		String sql ="SELECT A.UM_AGENCYID,A.UM_ICID,A.UM_USERNAME,A.UM_POSITION,B.DC_DEPARNAME FROM SDEPARCONFIG B,DUSERMSG A WHERE A.UM_DEPARCODE=B.DC_DEPARCODE AND B.DC_DEPARCODE=?";
		String sqla = "SELECT A.UM_AGENCYID,A.UM_ICID,A.UM_USERNAME,A.UM_POSITION,B.DC_DEPARNAME from DUSERMSG A,SDEPARCONFIG B where A.UM_POSITION=? and A.UM_DEPARCODE = B.DC_DEPARCODE";
		String sqlb = "SELECT A.UM_AGENCYID,A.UM_ICID,A.UM_USERNAME,A.UM_POSITION,B.DC_DEPARNAME FROM SDEPARCONFIG B,DUSERMSG A WHERE (A.UM_DEPARCODE=B.DC_DEPARCODE AND B.DC_BELONG=? AND B.DC_LEVEL='3') OR (B.DC_LEVEL='2' AND A.UM_DEPARCODE = B.DC_DEPARCODE and B.DC_DEPARCODE=? ) ";
		Object[] args={depId};

		if( depId.equals("3") || depId.equals("4") || depId.equals("5") || depId.equals("6") || depId.equals("7") || depId.equals("8") || depId.equals("9") )

		{
			@SuppressWarnings("rawtypes")
			List<UserInfoVo> OrganizeList = persistDao.selectListBySQL(sqla, args, new RowMapper()
			{
				public UserInfoVo mapRow(ResultSet rs,int index) throws SQLException
				{
					UserInfoVo uservo = new UserInfoVo();
					uservo.setAgid(rs.getString("UM_AGENCYID"));
					uservo.setUser_icid(rs.getString("UM_ICID"));
					uservo.setUser_name(rs.getString("UM_USERNAME"));
					uservo.setUser_position(rs.getString("UM_POSITION"));
					uservo.setUser_department(rs.getString("DC_DEPARNAME"));
					return uservo;
				}
			}
			);
			return OrganizeList;
		}else if( depId.substring(3,5).equals("00") ) 
		{
			Object[] argsb={depId,depId};
			@SuppressWarnings("rawtypes")
			List<UserInfoVo> OrganizeList = persistDao.selectListBySQL(sqlb, argsb, new RowMapper()
			{
				public UserInfoVo mapRow(ResultSet rs,int index) throws SQLException
				{
					UserInfoVo uservo = new UserInfoVo();
					uservo.setAgid(rs.getString("UM_AGENCYID"));
					uservo.setUser_icid(rs.getString("UM_ICID"));
					uservo.setUser_name(rs.getString("UM_USERNAME"));
					uservo.setUser_position(rs.getString("UM_POSITION"));
					uservo.setUser_department(rs.getString("DC_DEPARNAME"));
					return uservo;
				}
			}
			);
			return OrganizeList;
		}else
		{
			@SuppressWarnings("rawtypes")
			List<UserInfoVo> OrganizeList = persistDao.selectListBySQL(sql, args, new RowMapper()
			{
				public UserInfoVo mapRow(ResultSet rs,int index) throws SQLException
				{
					UserInfoVo uservo = new UserInfoVo();
					uservo.setAgid(rs.getString("UM_AGENCYID"));
					uservo.setUser_icid(rs.getString("UM_ICID"));
					uservo.setUser_name(rs.getString("UM_USERNAME"));
					uservo.setUser_position(rs.getString("UM_POSITION"));
					uservo.setUser_department(rs.getString("DC_DEPARNAME"));
					return uservo;
				}
			}
			);
			return OrganizeList;
		}
	}

	@Override
	public List<UserInfoVo> getUserMsgByName(String userName) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int upUserMsg(UserInfoVo uservo) throws Exception
	{
		// TODO Auto-generated method stub
		String sql="UPDATE  DUSERMSG SET UM_ICID=?,UM_USERNAME=?,UM_POSITION=? WHERE UM_AGENCYID=?";
		Object[] args={uservo.getUser_icid(),uservo.getUser_name(),uservo.getUser_position(),uservo.getAgid()};
		
		return persistDao.update(sql, args);
	}

	@Override
	public int delUset(String usericid) throws Exception
	{
		// TODO Auto-generated method stub
		/*if(-1 == usericid.indexOf(",") )
		{
			String sql ="TRUNCATE TABLE DUSERMSG WHERE UM_ICID=?";
			Object[] args={usericid};
			return persistDao.delete(sql, args);
			
		}else
		{*/
			String sql ="DELETE FROM DUSERMSG WHERE UM_ICID IN ?";
			Object[] args =  new Object[]{usericid};
			return persistDao.delete(sql, args);
		//}
	}

	@Override
	public void newUserMsg(UserInfoVo uservo) throws Exception
	{
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

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoVo> getUserMsgByIcid(String userIcid) throws Exception
	{
		// TODO Auto-generated method stub
		String sql="SELECT UM_AGENCYID,UM_ICID,UM_USERNAME,UM_SEX FROM DUSERMSG WHERE UM_ICID=?";
		Object[] args={userIcid};
		@SuppressWarnings("rawtypes")
		List<UserInfoVo> SelectMsgList = persistDao.selectListBySQL(sql, args, new RowMapper()
			{
				public UserInfoVo mapRow(ResultSet rs,int index) throws SQLException
				{
					UserInfoVo uservo = new UserInfoVo();
					uservo.setAgid(rs.getString("UM_AGENCYID"));
					uservo.setUser_icid(rs.getString("UM_ICID"));
					uservo.setUser_name(rs.getString("UM_USERNAME"));
					uservo.setUser_gender(rs.getString("UM_SEX"));
					return uservo;
				}
			}
		);
		return SelectMsgList;
		
	}

	@Override
	public List<UserInfoVo> getUserMsgByAgid(String agid) throws Exception
	{
		// TODO Auto-generated method stub
		String sql="SELECT UM_AGENCYID,UM_ICID,UM_USERNAME,UM_DEPARCODE FROM DUSERMSG WHERE UM_AGENCYID=?";
		Object[] args={agid};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<UserInfoVo> SelectMsgList = persistDao.selectListBySQL(sql, args, new RowMapper()
			{
				public UserInfoVo mapRow(ResultSet rs,int index) throws SQLException
				{
					UserInfoVo uservo = new UserInfoVo();
					uservo.setAgid(rs.getString("UM_AGENCYID"));
					uservo.setUser_icid(rs.getString("UM_ICID"));
					uservo.setUser_name(rs.getString("UM_USERNAME"));
					uservo.setUser_deparcode(rs.getString("UM_DEPARCODE"));
					return uservo;
				}
			}
		);
		return SelectMsgList;
	}

	

}
