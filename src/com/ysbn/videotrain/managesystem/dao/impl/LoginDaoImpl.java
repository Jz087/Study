package com.ysbn.videotrain.managesystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ysbn.videotrain.managesystem.dao.ILoginDao;
import com.ysbn.videotrain.managesystem.vo.LoginVo;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;

public class LoginDaoImpl implements ILoginDao {
    private PersistDao persistDao;

    public PersistDao getPersistDao() {
        return persistDao;
    }

    public void setPersistDao(PersistDao persistDao) {
        this.persistDao = persistDao;
    }

    @Override
    public List<LoginVo> queryLoginList(String loginCode) throws Exception {
        String sql = "SELECT LM_AGENCYID, LM_LOGINCODE, LM_LOGINNAME, LM_LOGINPWD, LM_CREATETIME, LM_USEFLAG FROM DLOGINMSG WHERE LM_LOGINCODE=?";
        Object[] args = new Object[] {loginCode};
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                LoginVo loginVo = new LoginVo();
                try {
                    loginVo.setId(Integer.parseInt(rs.getString(1)));
                    loginVo.setLoginCode(rs.getString(2));
                    loginVo.setLoginName(rs.getString(3));
                    loginVo.setLoginPwd(rs.getString(4));
                    loginVo.setCreateTime(rs.getString(5));
                    loginVo.setUseFlag(rs.getString(6));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return loginVo;
            }
        };
        List<LoginVo> loginVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return loginVoList;
    }

}
