package com.ysbn.videotrain.managesystem.vo;

public class TrainInfoVo
{
	//培训相关信息
	
	private String ci_id;			//表主键
	private String culid;			//培训期
	private String culname;			//培训名称
	private String studytime;		//学习开始时间
	private String studyend;		//学习结束时间
	private String createtime;		//创建时间
	private String describe;		//描述
	public String getCi_id()
	{
		return ci_id;
	}
	public void setCi_id(String ci_id)
	{
		this.ci_id = ci_id;
	}
	public String getCulid()
	{
		return culid;
	}
	public void setCulid(String culid)
	{
		this.culid = culid;
	}
	public String getCulname()
	{
		return culname;
	}
	public void setCulname(String culname)
	{
		this.culname = culname;
	}
	public String getStudytime()
	{
		return studytime;
	}
	public void setStudytime(String studytime)
	{
		this.studytime = studytime;
	}
	public String getStudyend()
	{
		return studyend;
	}
	public void setStudyend(String studyend)
	{
		this.studyend = studyend;
	}
	public String getCreatetime()
	{
		return createtime;
	}
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime;
	}
	public String getDescribe()
	{
		return describe;
	}
	public void setDescribe(String describe)
	{
		this.describe = describe;
	}

}
