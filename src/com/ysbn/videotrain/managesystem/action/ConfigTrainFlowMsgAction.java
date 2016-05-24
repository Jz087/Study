package com.ysbn.videotrain.managesystem.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.IConfigFlowService;
import com.ysbn.videotrain.managesystem.service.IConfigUserMsgService;
import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;


public class ConfigTrainFlowMsgAction extends BaseAction{

	/**
	 * @author jiangyi
	 * 1.获取培训信息
	 * 2.修改培训流程（暂时只能修改培训名称、培训期、开始时间、结束时间 ）
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IConfigFlowService configFlowService;
	private List<TrainInfoVo> rows;
	private String pageNo;
	private int pageSize;
	private String cid;
	private String fname;
	private String fid;
	private String sttime;
	private String endtime;
	private String succFlag;
	private String msg;
	public String getFname()
	{
		return fname;
	}
	public void setFname(String fname)
	{
		this.fname = fname;
	}
	public String getFid()
	{
		return fid;
	}
	public void setFid(String fid)
	{
		this.fid = fid;
	}
	public String getSttime()
	{
		return sttime;
	}
	public void setSttime(String sttime)
	{
		this.sttime = sttime;
	}
	public String getEndtime()
	{
		return endtime;
	}
	public void setEndtime(String endtime)
	{
		this.endtime = endtime;
	}
	public String getSuccFlag()
	{
		return succFlag;
	}
	public void setSuccFlag(String succFlag)
	{
		this.succFlag = succFlag;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
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
	public String getCid()
	{
		return cid;
	}
	public void setCid(String cid)
	{
		this.cid = cid;
	}
	public List<TrainInfoVo> getRows()
	{
		return rows;
	}
	public void setRows(List<TrainInfoVo> rows)
	{
		this.rows = rows;
	}
	public void setConfigFlowService(IConfigFlowService configFlowService)
	{
		this.configFlowService = configFlowService;
	}

	String process() throws Exception{
		
		HttpServletRequest request = this.getHttpServletRequest();
		//HttpSession session =  request.getSession();
		//String flows = request.getParameter("ftep");
		String method = request.getParameter("method");
		if("selects".equals(method))
		{
			String sort = request.getParameter("sort");
			String direction = request.getParameter("direction");
			pageNo = request.getParameter("pager.pageNo");
			String psize = request.getParameter("pager.pageSize");
			//获取表单元素
			List<TrainInfoVo> trainList; 	
			try 
	        {
	        	trainList = configFlowService.getFlowMsg();
	        	if(null!=trainList && 0!=trainList.size())
	        	{
	        		pageSize = trainList.size();
	        		int pages = pageSize/Integer.parseInt(psize);
	        		rows = new ArrayList<TrainInfoVo>();
	        		TrainInfoVo tinfo = new TrainInfoVo();
	        		int pze = Integer.parseInt(psize);
					if( pageSize>Integer.parseInt(psize) )
					{
						if("1".equals(pageNo))
						{
							for(int s=0;s<pze;s++)
							{
								tinfo = trainList.get(s);
								rows.add(tinfo);
							}
						}else
						{
							if( pages == (Integer.parseInt(pageNo)-1) )
							{
								for(int s1=( (Integer.parseInt(pageNo)-1)*pze);s1<pageSize;s1++)
								{
									tinfo = trainList.get(s1);
									rows.add(tinfo);
								}
							}else
							{
								for(int s1=( (Integer.parseInt(pageNo)-1)*pze);s1<Integer.parseInt(pageNo)*pze;s1++)
								{
									tinfo = trainList.get(s1);
									rows.add(tinfo);
								}
							}
						}
						
					}else
					{
						rows = trainList;
					}
	        	}else
				{
					pageNo ="0";
					pageSize = 0;
					msg="没有记录";
				}
	        } catch (Exception e) {
	            e.printStackTrace();
	            Utility.Log.e(GetVideoUsedAction.class, e.getMessage());
	            throw e;
	        }
			trainList = configFlowService.getFlowMsg();
		}else if("select".equals(method))
		{
			String agid = request.getParameter("cid");
			rows = configFlowService.getMsg(agid);
			if( null!=rows )
			{
				cid=rows.get(0).getCi_id();
				fname=rows.get(0).getCulname();
				fid = rows.get(0).getCulid();
				sttime = rows.get(0).getStudytime();
				endtime = rows.get(0).getStudyend();
				succFlag="1";
				msg="修改成功";
			}else
			{
				succFlag="2";
				msg="修改失败";
			}
		}else if("update".equals(method))
		{
			String cid=request.getParameter("agencyid");
			String clid = request.getParameter("culid");
			String culname = request.getParameter("culname");
			String sttime = request.getParameter("sttime");
			String endtime = request.getParameter("endtime");
			TrainInfoVo tvo = new TrainInfoVo();
			tvo.setCi_id(cid);
			tvo.setCulid(clid);
			tvo.setCulname(culname);
			tvo.setStudytime(sttime.replace("-", ""));
			tvo.setStudyend(endtime.replace("-", ""));
			int ti = configFlowService.updateFlowMsg(tvo);
			if(1==ti)
			{
				succFlag="1";
				msg="修改成功";
			}else
			{
				succFlag="2";
				msg="修改失败";
			}
		}
		//rows = configFlowService.getFlowMsg();
		return "success";
	}
}
