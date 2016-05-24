package com.ysbn.videotrain.managesystem.vo;

public class LoginVo {
    private int id;
    private String loginCode;
    private String loginName;
    private String loginPwd;
    private String createTime;
    private String useFlag;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLoginCode() {
        return loginCode;
    }
    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getLoginPwd() {
        return loginPwd;
    }
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getUseFlag() {
        return useFlag;
    }
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }
}
