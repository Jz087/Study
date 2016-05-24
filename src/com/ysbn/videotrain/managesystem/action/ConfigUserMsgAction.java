package com.ysbn.videotrain.managesystem.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.cxf.binding.corba.wsdl.Array;

import com.hctn.dev.toolkit.util.Utility;
import com.mysql.jdbc.Util;
import com.ysbn.videotrain.managesystem.service.IConfigUserMsgService;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;


public class ConfigUserMsgAction extends BaseAction{

	/**
	 * @author jiangyi
	 * 人员配置
	 * 1.人员查询
	 * 2.人员新增
	 * 3.人员修改
	 * 4.人员删除
	 */
	private static final long serialVersionUID = 1L;

	private IConfigUserMsgService configService;
	public void setConfigService(IConfigUserMsgService configService)
	{
		this.configService = configService;
	}
	private List<UserInfoVo> rows;
	private String pageNo;
	private int pageSize;
	private String AllocationMsg;
	private String msg;
	private String agid;
	private String uicid;
	private String uname;
	private String orgid;
	private int dreturn;
	public String getAgid()
	{
		return agid;
	}
	public void setAgid(String agid)
	{
		this.agid = agid;
	}
	public String getUicid()
	{
		return uicid;
	}
	public void setUicid(String uicid)
	{
		this.uicid = uicid;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getAllocationMsg()
	{
		return AllocationMsg;
	}
	public void setAllocationMsg(String allocationMsg)
	{
		AllocationMsg = allocationMsg;
	}
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

	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public String getOrgid()
	{
		return orgid;
	}
	public void setOrgid(String orgid)
	{
		this.orgid = orgid;
	}
	public int getDreturn()
	{
		return dreturn;
	}
	public void setDreturn(int dreturn)
	{
		this.dreturn = dreturn;
	}
	String process() throws Exception{
		
		HttpServletRequest request = this.getHttpServletRequest();
		HttpSession session =  request.getSession();
		
		String method = request.getParameter("method");
		String remsg="success";
		
		if("add".equals(method))
		{
			String userName = request.getParameter("userName");				//员工姓名
			String userIcid = request.getParameter("userIcid");				//员工icid
			String checkId = request.getParameter("checkid");				//选中科室id
			String checkposition = request.getParameter("checkposition");	//员工职务
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
			uservo.setUser_position(checkposition);
			try
			{
				configService.newUserMsg(uservo);
				msg = "添加成功";
			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
				Utility.Log.e(ConfigUserMsgAction.class, e.getMessage());
				msg = "添加失败";
			}
			
			return remsg;
		}else if("update".equals(method))
		{
			//修改
			UserInfoVo upvo = new UserInfoVo();
			upvo.setAgid(request.getParameter("agencyid"));
			upvo.setUser_icid(request.getParameter("userIcid"));
			upvo.setUser_name(request.getParameter("userName"));
			String spo = request.getParameter("checkposition");
			if("公司领导".equals(spo))
			{
				spo="3";
			}else if("总经理助理".equals(spo))
			{
				spo="4";
			}else if("主任".equals(spo))
			{
				spo="5";
			}else if("副主任".equals(spo))
			{
				spo="6";
			}else if("主任助理".equals(spo))
			{
				spo="7";
			}else if("科长".equals(spo))
			{
				spo="8";
			}else
			{
				spo="9";
			}
			upvo.setUser_position(spo);
			int up=0;
			try
			{
				up = configService.upUserMsg(upvo);
				if(up ==1)
				{
					
					msg="修改成功！";
				}else
				{
					msg="修改失败！";
				}
			} catch (Exception e)
			{
				e.printStackTrace();
				Utility.Log.e(ConfigUserMsgAction.class, e.getMessage());
				msg="修改失败！";
			}
			return remsg;
		}else if("delete".equals(method))
		{
			//删除
			String userIcid = request.getParameter("delid");
			dreturn = configService.delUset(userIcid);
		}else if("select".equals(method))
		{
			//修改前查询用户信息
			String agid1 = request.getParameter("agid");
			List<UserInfoVo> usevo = new ArrayList<UserInfoVo>();
			
			usevo = configService.getUserMsgByAgid(agid1);
			if( usevo !=null )
			{
				agid = usevo.get(0).getAgid();
				uicid = usevo.get(0).getUser_icid();
				uname = usevo.get(0).getUser_name();
				orgid = usevo.get(0).getUser_deparcode();
			}else
			{
				uname = "读取失败，请稍后再试";
			}
			
			return remsg;
			
		}else if("selectid".equals(method))
		{
			//获取科室人员列表功能
			request.removeAttribute("OrgMsg");
			String orgid1 = request.getParameter("orgid");
			//pageNo =request.getParameter("pageNo");
			String sort = request.getParameter("sort");
			String direction = request.getParameter("direction");
			pageNo = request.getParameter("pager.pageNo");
			String psize = request.getParameter("pager.pageSize");
			List<UserInfoVo> totalrows ;
			//rows = configService.getOrganizeById(orgid);
			totalrows = configService.getOrganizeById(orgid1);
			if( null!=totalrows && 0!=totalrows.size() )
			{
				for(int a=0;a<totalrows.size();a++)
				{
					
					if("3".equals(totalrows.get(a).getUser_position()))
					{
						totalrows.get(a).setUser_position("公司领导");
					}else if("4".equals(totalrows.get(a).getUser_position()))
					{
						totalrows.get(a).setUser_position("总经理助理");
					}else if("5".equals(totalrows.get(a).getUser_position()))
					{
						totalrows.get(a).setUser_position("主任");
					}else if("6".equals(totalrows.get(a).getUser_position()))
					{
						totalrows.get(a).setUser_position("副主任");
					}else if("7".equals(totalrows.get(a).getUser_position()))
					{
						totalrows.get(a).setUser_position("主任助理");
					}else if("8".equals(totalrows.get(a).getUser_position()))
					{
						totalrows.get(a).setUser_position("科长");
					}else
					{
						totalrows.get(a).setUser_position("科员");
					}
				}
				
				//int ps = Integer.parseInt(request.getParameter("pageSize") );
				pageSize = totalrows.size();
				int pages = pageSize/10;
				rows = new ArrayList<UserInfoVo>();
				UserInfoVo uv = new UserInfoVo();
				int pze = Integer.parseInt(psize);
				if( pageSize>Integer.parseInt(psize) )
				{
					if("1".equals(pageNo))
					{
						for(int s=0;s<pze;s++)
						{
							uv = totalrows.get(s);
							rows.add(uv);
						}
					}else
					{
						if( pages == (Integer.parseInt(pageNo)-1) )
						{
							for(int s1=( (Integer.parseInt(pageNo)-1)*pze);s1<pageSize;s1++)
							{
								uv = totalrows.get(s1);
								rows.add(uv);
							}
						}else
						{
							for(int s1=( (Integer.parseInt(pageNo)-1)*pze);s1<Integer.parseInt(pageNo)*pze;s1++)
							{
								uv = totalrows.get(s1);
								rows.add(uv);
							}
						}
						
					}
					
				}else
				{
					rows = totalrows;
				}
				
			}else
			{
				pageNo ="0";
				pageSize = 0;
				request.setAttribute("OrgMsg", "123");
			}
		}else if("sbyid".equals(method))
		{
			String icid = request.getParameter("icid");
			//rows = configService.getUserMsgByIcid(icid);
			if(rows != null && 0 != rows.size())
			{
				/*for(int a=0;a<rows.size();a++)
				{
					if( "1".equals(rows.get(a).getUser_gender()) )
					{
						rows.get(a).setUser_gender("男");
					}else
					{
						rows.get(a).setUser_gender("女");
					}
				}*/
				
				request.setAttribute("userinfor", rows);
			}else
			{
				request.setAttribute("userinfor", "norecords");
				AllocationMsg="error";
			}
			//msg = "sbyid";
		}
		
		
		
		return remsg;
	}
}
