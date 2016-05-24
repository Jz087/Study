package com.ysbn.videotrain.managesystem.service.impl;

import java.util.List;

import com.ysbn.videotrain.managesystem.dao.ILoginDao;
import com.ysbn.videotrain.managesystem.service.ILoginService;
import com.ysbn.videotrain.managesystem.vo.LoginVo;

public class LoginServiceImpl implements ILoginService {
    private ILoginDao loginDao;
    public ILoginDao getLoginDao() {
        return loginDao;
    }
    public void setLoginDao(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }


    @Override
    public List<LoginVo> queryLoginList(String loginCode) throws Exception {
        return loginDao.queryLoginList(loginCode);
    }

}
