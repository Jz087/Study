package com.ysbn.videotrain.managesystem.dao;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.LoginVo;

public interface ILoginDao {
    public List<LoginVo> queryLoginList(String loginCode) throws Exception;
}
