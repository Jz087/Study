package com.ysbn.videotrain.managesystem.vo;

public class QuestionInfoVo
{

	private String ei_id;			//表主键
	private String qname;			//区分不同答卷
	private String viid;			//对应不同视频id
	private String question;		//问题
	private String answera;			//选项a
	private String answerb;			//选项b
	private String answerc;			//选项c
	private String answerd;			//选项d
	private String answer;			//答案
	private int question_nums;		//问题条数
	private int juanzi;
	private int vv;
	public int getVv()
	{
		return vv;
	}
	public void setVv(int vv)
	{
		this.vv = vv;
	}
	public int getQuestion_nums()
	{
		return question_nums;
	}
	public void setQuestion_nums(int question_nums)
	{
		this.question_nums = question_nums;
	}
	public int getJuanzi()
	{
		return juanzi;
	}
	public void setJuanzi(int juanzi)
	{
		this.juanzi = juanzi;
	}
	public String getQname()
	{
		return qname;
	}
	public void setQname(String qname)
	{
		this.qname = qname;
	}
	public String getViid()
	{
		return viid;
	}
	public void setViid(String viid)
	{
		this.viid = viid;
	}
	public String getEi_id()
	{
		return ei_id;
	}
	public void setEi_id(String ei_id)
	{
		this.ei_id = ei_id;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}
	public String getAnswera()
	{
		return answera;
	}
	public void setAnswera(String answera)
	{
		this.answera = answera;
	}
	public String getAnswerb()
	{
		return answerb;
	}
	public void setAnswerb(String answerb)
	{
		this.answerb = answerb;
	}
	public String getAnswerc()
	{
		return answerc;
	}
	public void setAnswerc(String answerc)
	{
		this.answerc = answerc;
	}
	public String getAnswerd()
	{
		return answerd;
	}
	public void setAnswerd(String answerd)
	{
		this.answerd = answerd;
	}
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
}
