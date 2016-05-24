package com.ysbn.videotrain.managesystem.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.IConfigUserMsgService;
import com.ysbn.videotrain.managesystem.util.TVUtility;
import com.ysbn.videotrain.managesystem.vo.OrganizeVo;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

public class GetOrganizeMsgAction extends BaseAction{

	/**
	 * @author jiangyi
	 * 获取科室人员列表功能
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IConfigUserMsgService configService;
	private List<UserInfoVo> rows;
	private String pageNo;
	private int pageSize;
	public List<UserInfoVo> getRows()
	{
		return rows;
	}
	public void setRows(List<UserInfoVo> rows)
	{
		this.rows = rows;
	}
	public String getPageNo()
	{
		return pageNo;
	}
	public void setPageNo(String pageNo)
	{
		this.pageNo = pageNo;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public void setConfigService(IConfigUserMsgService configService)
	{
		this.configService = configService;
	}
	

	String process() throws Exception{
		
		HttpServletRequest request = this.getHttpServletRequest();
		HttpSession session =  request.getSession();
		request.removeAttribute("OrgMsg");
		String orgid = request.getParameter("orgid");
		
		rows = configService.getOrganizeById(orgid);
		session.setAttribute("userinfor", rows);
		if( null!=rows && 0!=rows.size() )
		{
			for(int a=0;a<rows.size();a++)
			{
				if( "1".equals(rows.get(a).getUser_gender()) )
				{
					rows.get(a).setUser_gender("男");
				}else
				{
					rows.get(a).setUser_gender("女");
				}
			}
			pageNo ="1";
			pageSize = rows.size();
		}else
		{
			pageNo ="0";
			pageSize = 0;
			request.setAttribute("OrgMsg", "123");
		}
		
		//List<UserInfoVo> uList = configService.getOrganizeById(orgid);
		//rowdata = new HashMap<String, String>();
		//System.out.println(request.getParameter("pager.pageNo"));
		/*rowdata.put("pageNo", "1");
		rowdata.put("totalRows", ""+uList.size());
		rowdata.put("rows", TVUtility.toJson(uList));*/
		
		//Utility.Log.i(GetOrganizeMsgAction.class, "**************************************"+m1);
		return GetOrganizeMsgAction.SUCCESS;
	}
}
