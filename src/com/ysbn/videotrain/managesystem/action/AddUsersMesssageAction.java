package com.ysbn.videotrain.managesystem.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;

import com.google.gson.Gson;
import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.IAddUserService;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class AddUsersMesssageAction extends BaseAction
{

	/**
	 * @author jiangyi 新增用户信息 批量录入（excel表格）
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAddUserService addusersService;
	public void setAddusersService(IAddUserService addusersService)
	{
		this.addusersService = addusersService;
	}


	String process() throws Exception
	{
		HttpServletRequest request = this.getHttpServletRequest();
		// HttpSession session = request.getSession();

		String filepath = request.getParameter("fileData");

		jxl.Workbook readwb = null;

		try
		{

			InputStream is = new FileInputStream("D:\\" + filepath);

			jxl.Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0);
			
			List<UserInfoVo> uservo = new ArrayList<UserInfoVo>();
			
			for(int i=0;i<rs.getRows();i++)
			{
				UserInfoVo us = new UserInfoVo() ;
			
				us.setUser_icid(rs.getCell(0,i).getContents());
				us.setUser_name(rs.getCell(1,i).getContents());
				us.setUser_phone(rs.getCell(2,i).getContents());
				us.setUser_deparcode(rs.getCell(3,i).getContents());		
				
				uservo.add(us);
			}
			
			addusersService.UsersAdd(uservo);
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();

		} finally
		{
			readwb.close();
		}

		// aduser = "add user success!";
		return "success";
	}
}
