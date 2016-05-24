package com.ysbn.videotrain.managesystem.service;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.LoginVo;

public interface ILoginService {
    public List<LoginVo> queryLoginList(String loginCode) throws Exception;
}
