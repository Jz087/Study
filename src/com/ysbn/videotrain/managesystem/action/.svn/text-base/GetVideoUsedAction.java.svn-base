package com.ysbn.videotrain.managesystem.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.OperateVideoInfoService;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;

public class GetVideoUsedAction extends BaseAction {

    /**
     * 
     */
    private static final long       serialVersionUID = 1L;
    private OperateVideoInfoService operateVideoInfoService;
    private List<VideoInfoVo>       rows;
    private String pageNo;
	private int pageSize;
    public void setOperateVideoInfoService(OperateVideoInfoService operateVideoInfoService) {
        this.operateVideoInfoService = operateVideoInfoService;
    }
    public List<VideoInfoVo> getRows()
	{
		return rows;
	}
	public void setRows(List<VideoInfoVo> rows)
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
	
	@Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        
        String sort = request.getParameter("sort");
		String direction = request.getParameter("direction");
		pageNo = request.getParameter("pager.pageNo");
		String psize = request.getParameter("pager.pageSize");
		List<VideoInfoVo> vList;
        try 
        {
        	vList = operateVideoInfoService.queryVideoInfo();
        	if(null!=vList && 0!=vList.size())
        	{
        		pageSize = vList.size();
        		int pages = pageSize/Integer.parseInt(psize);
        		rows = new ArrayList<VideoInfoVo>();
        		VideoInfoVo vinfo = new VideoInfoVo();
        		int pze = Integer.parseInt(psize);
				if( pageSize>Integer.parseInt(psize) )
				{
					if("1".equals(pageNo))
					{
						for(int s=0;s<pze;s++)
						{
							vinfo = vList.get(s);
							rows.add(vinfo);
						}
					}else
					{
						if( pages == (Integer.parseInt(pageNo)-1) )
						{
							for(int s1=( (Integer.parseInt(pageNo)-1)*pze);s1<pageSize;s1++)
							{
								vinfo = vList.get(s1);
								rows.add(vinfo);
							}
						}else
						{
							for(int s1=( (Integer.parseInt(pageNo)-1)*pze);s1<Integer.parseInt(pageNo)*pze;s1++)
							{
								vinfo = vList.get(s1);
								rows.add(vinfo);
							}
						}
					}
					
				}else
				{
					rows = vList;
				}
        	}else
			{
				pageNo ="0";
				pageSize = 0;
				//request.setAttribute("OrgMsg", "123");
			}
        } catch (Exception e) {
            e.printStackTrace();
            Utility.Log.e(GetVideoUsedAction.class, e.getMessage());
            throw e;
        }
        
        return "success";
    }

}
