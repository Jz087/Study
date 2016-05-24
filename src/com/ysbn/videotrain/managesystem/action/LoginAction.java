package com.ysbn.videotrain.managesystem.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ysbn.videotrain.managesystem.service.ILoginService;
import com.ysbn.videotrain.managesystem.vo.LoginVo;

public class LoginAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ILoginService loginService;

    public ILoginService getLoginService() {
        return loginService;
    }
    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }


    @Override
    String process() throws Exception {
        String result = "success";
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("loginFlag");
        session.removeAttribute("count");
        session.removeAttribute("userName");
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        List<LoginVo> loginList = loginService.queryLoginList(username);
        
        String msg = "";
        boolean ISLogin = false;
        if(loginList!=null && loginList.size()!=0){
            String loginPwd = loginList.get(0).getLoginPwd().trim();
            if(password.equals(loginPwd)){
                ISLogin = true;
                session.setAttribute("userName", loginList.get(0).getLoginName());
            }else{
                msg = "密码错误！";
                ISLogin = false;
            }
        }else{
            msg = "用户名不存在！";
            ISLogin = false;
        }
        
        if (ISLogin) {
            session.setAttribute("loginFlag", "1");
            result = "success";
        } else {
            request.setAttribute("msg", msg);
            session.setAttribute("loginFlag", "0");
            result = "fail";
        }
        session.setAttribute("count", 0);
        return result;
    }
}
