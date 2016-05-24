package com.ysbn.videotrain.managesystem.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import jxl.Sheet;
import jxl.Workbook;
import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.IAddUserService;
import com.ysbn.videotrain.managesystem.util.TVUtility;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class AddUserMesssageAction extends BaseAction{

	/**
	 * @author jiangyi
	 * 新增用户信息
	 * 1.单独录入（页面数据）
	 * 2.批量录入（excel表格）
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAddUserService adduserService;
	private File uploadFile;							//上传文件
	private String uploadFileFileName; 				//上传文件名称
	public void setAdduserService(IAddUserService adduserService) {
		this.adduserService = adduserService;
	}
	public File getUploadFile()
	{
		return uploadFile;
	}
	public void setUploadFile(File uploadFile)
	{
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName()
	{
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName)
	{
		this.uploadFileFileName = uploadFileFileName;
	}


	String process() throws Exception{
		HttpServletRequest request = this.getHttpServletRequest();
		HttpSession session = request.getSession();
		String method = request.getParameter("method");			//录入方式
		
		
		if("single".equals(method))
		{
			//单条录入
			String userName = request.getParameter("userName");				//员工姓名
			String userIcid = request.getParameter("userIcid");				//员工icid
			//String userPhone = request.getParameter("userPhone");			//电话
			String checkId = request.getParameter("checkid");				//选中科室id
			//String keshi = request.getParameter("keshi");
			//String dep_id = request.getParameter("depid");					//科室所属部门id
			//String depment = request.getParameter("depment");				//所属部门名称
			//String company = request.getParameter("company");				//所在公司名称	
			String checkposition = request.getParameter("checkposition");				//员工职务
		
			UserInfoVo uservo = new UserInfoVo();
			
			uservo.setUser_name(userName);
			uservo.setUser_icid(userIcid);
			uservo.setUser_deparcode(checkId);
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
			//uservo.setUser_department(depment);
			//uservo.setUser_company(company);
			uservo.setUser_position(checkposition);
			//uservo.setUser_phone(userPhone);
			//session.setAttribute("userinfor", TVUtility.toJson(uservo));
			try {
				
				adduserService.UserAdd(uservo);
				request.setAttribute("msg", "添加成功");
				request.setAttribute("aduMsg", "添加成功!");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				Utility.Log.e(AddUserMesssageAction.class, e.getMessage());
				request.setAttribute("aduMsg", "添加失败!");
			}
		}else if("singles".equals(method))
		{
			
			String fnames = uploadFileFileName.trim();
			String directory = "/upload/xls";  
			String targetDirectory = this.getServletContext().getRealPath(directory);  
			File file = new File(targetDirectory,fnames);
			FileUtils.copyFile(uploadFile, file);		//文件保存到tomcat目录下
		    File target = new File(targetDirectory,fnames); 
			String targetPath = this.getServletContext().getRealPath("\\");
			InputStream is = new FileInputStream(target);
			
			//String filePath = request.getParameter("fileData");
			//InputStream is = new FileInputStream("D:\\"+filePath);
			jxl.Workbook rwb = Workbook.getWorkbook(is);
			//获取第一张Sheet表
			Sheet rs = rwb.getSheet(0);
			List<UserInfoVo> uservo = new ArrayList<UserInfoVo>();
			
			for(int i=0;i<rs.getRows();i++)
			{
				UserInfoVo us = new UserInfoVo() ;
			
				us.setUser_company(rs.getCell(0,i).getContents());
				us.setUser_department(rs.getCell(1,i).getContents());
				us.setUser_deparcode(rs.getCell(2,i).getContents());
				
				us.setUser_icid(rs.getCell(3,i).getContents());
				us.setUser_name(rs.getCell(4,i).getContents());
				us.setUser_position(rs.getCell(5,i).getContents());
				
				uservo.add(us);
			}
			rwb.close();
			System.out.println("uservo is:"+TVUtility.toJson(uservo));
			try
			{
				adduserService.UsersAdd(uservo);
				request.setAttribute("aduMsg", "添加成功!");
			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
				Utility.Log.e(AddUserMesssageAction.class, e.getMessage());
				request.setAttribute("aduMsg", "添加失败!");
			}
			
		}
		
		return "success";
	}
}
