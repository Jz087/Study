package com.ysbn.videotrain.managesystem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.IAddUserService;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class ChangeUserMesssageAction extends BaseAction{

	/**
	 * @author jiangyi
	 * 修改用户信息
	 */
	private static final long serialVersionUID = 1L;
	

	String process() throws Exception{
		HttpServletRequest request = this.getHttpServletRequest();
		//HttpSession session = request.getSession();
		String userName = request.getParameter("userName");				//员工姓名
		String userIcid = request.getParameter("userIcid");				//员工icid
		String userPhone = request.getParameter("userPhone");			//电话
		String checkId = request.getParameter("checkid");				//选中科室id
		//String keshi = request.getParameter("keshi");
		String dep_id = request.getParameter("depid");					//科室所属部门id
		String depment = request.getParameter("depment");				//所属部门名称
		String company = request.getParameter("company");				//所在公司名称	
		String checksex = request.getParameter("checksex");				//员工姓名
		
		String level ="1" ;
		String deparcode = "1";
		if("有线电视公司".equals(company))
		{
			deparcode="2";
		}
		deparcode = deparcode + checkId + dep_id;			//部门代码：公司id，科室id，部门id
		
		if(!"0".equals(dep_id) && 5 != dep_id.length() )
		{
			level ="2";
		}else if(5==dep_id.length())
		{
			level ="3";
		}
	
		UserInfoVo uservo = new UserInfoVo();
		
		uservo.setUser_name(userName);
		uservo.setUser_icid(userIcid);
		uservo.setUser_deparcode(deparcode);
		uservo.setUser_department(depment);
		uservo.setUser_company(company);
		uservo.setUser_gender(checksex);
		
		try {
			
			//adduserService.UserAdd(uservo);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Utility.Log.e(ChangeUserMesssageAction.class, e.getMessage());
		}
		
	
		return "success";
	}
}
