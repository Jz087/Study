package com.ysbn.videotrain.managesystem.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import jxl.Sheet;
import jxl.Workbook;

import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.ICreateTrainFlowService;
import com.ysbn.videotrain.managesystem.util.TVUtility;
import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.TrainInfoVo;


public class CreateTrainFlowAction extends BaseAction{

	/**
	 * @author jiangyi
	 * 新建培训流程
	 * 1.培训信息
	 * 2.视频信息
	 * 3.答卷（文件）
	 * 4.人员信息
	 */
	private static final long serialVersionUID = 1L;
	private ICreateTrainFlowService ctfService;
	private File[] uploadFile;							//上传文件
	private String[] uploadFileFileName; 				//上传文件名称
	public void setCtfService(ICreateTrainFlowService ctfService)
	{
		this.ctfService = ctfService;
	}
	public File[] getUploadFile()
	{
		return uploadFile;
	}
	public void setUploadFile(File[] uploadFile)
	{
		this.uploadFile = uploadFile;
	}
	public String[] getUploadFileFileName()
	{
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String[] uploadFileFileName)
	{
		this.uploadFileFileName = uploadFileFileName;
	}



	String process() throws Exception{
		
		HttpServletRequest request = this.getHttpServletRequest();
		//HttpSession session =  request.getSession();
		
		
		//获取表单元素
		
		//flow1 trainInfo
		
		TrainInfoVo tvo = new TrainInfoVo();			//dculrecord培训表所需参数
		String culname = request.getParameter("train_name");		//培训名称
		String culid = request.getParameter("train_culid");			//培训期
		String sttime = request.getParameter("sttime");				//开始时间
		String endtime = request.getParameter("endtime");			//结束时间
		sttime = sttime.replace("-", "");
		endtime = endtime.replace("-", "");
		tvo.setCulname(culname);
		tvo.setCulid(culid);
		tvo.setStudytime(sttime);
		tvo.setStudyend(endtime);
		tvo.setDescribe("备注");
		
		
		//flow2 videoInfo
		
		String vv = request.getParameter("vlength");		//視頻數量
		int vl = Integer.parseInt(vv) ;	
		String vid="";
		//String vname="";
		if( 1 == vl )
		{
			vid=request.getParameter("viid0");
			//vname=request.getParameter("vname0");
		}else
		{
			for(int i=0;i<vl;i++)
			{
				vid = vid+request.getParameter("viid"+i)+",";
				//vname = vname+request.getParameter("vname"+i)+",";
			}
			vid = vid.substring(0,vid.length()-1);
		}
		
		//flow3 paper
		List<QuestionInfoVo> qvs = new ArrayList<QuestionInfoVo>();			//答卷信息
		if( 1 == vl )
		{
			//单条视频时
			String fnums = request.getParameter("fnums");
			int forvs = Integer.parseInt(fnums);
			String v_id = request.getParameter("viid0");
			List<QuestionInfoVo> qvo = new ArrayList<QuestionInfoVo>();
			for(int j=0;j<forvs;j++)
			{
				String fnames = uploadFileFileName[j].trim();
				String directory = "/upload/xls";  
				String targetDirectory = this.getServletContext().getRealPath(directory);  
				File file = new File(targetDirectory,fnames);
				FileUtils.copyFile(uploadFile[j], file);		//文件保存到tomcat目录下
			    File target = new File(targetDirectory,fnames); 
				String v_nums = request.getParameter("vis"+v_id);
				String targetPath = this.getServletContext().getRealPath("\\");
				InputStream is = new FileInputStream(target);
				//String v_nums = request.getParameter("vis"+v_id);
				String filePath = request.getParameter("a"+(v_id+(j+1)) );
				jxl.Workbook rwb = Workbook.getWorkbook(is);
				Sheet rs = rwb.getSheet(0);
				//int vnums = Integer.parseInt(v_nums);
				int ques = rs.getRows();
				for(int k=0;k<rs.getRows();k++)
				{
					QuestionInfoVo qs = new QuestionInfoVo();
					qs.setVv(vl);
					qs.setViid(v_id);
					qs.setQname((fnames.replace(".xls", "")));
					qs.setQuestion_nums(ques);
					qs.setJuanzi(forvs);
					qs.setQuestion((rs.getCell(0,k).getContents()));
					qs.setAnswera((rs.getCell(1,k).getContents()));
					qs.setAnswerb((rs.getCell(2,k).getContents()));
					qs.setAnswerc((rs.getCell(3,k).getContents()));
					qs.setAnswerd((rs.getCell(4,k).getContents()));
					qs.setAnswer(rs.getCell(5,k).getContents());
					qvo.add(qs);
				}
				rwb.close();
			}
			qvs.addAll(qvo);
			
		}else
		{
			//多个视频时
/*			String fnums = request.getParameter("fnums");
			int forvs = Integer.parseInt(fnums);*/
			List<QuestionInfoVo> qvo = new ArrayList<QuestionInfoVo>();
			String v_id =request.getParameter("viid0");
			int fi = 0 ;
			int fs = uploadFileFileName.length;
			for(int j=0;j<vl;j++)
			{
				String v_ids = request.getParameter("viid"+j);
				if(!v_id.equals(v_ids))
				{
					v_id = v_ids;
				}
				String v_nums = request.getParameter("vis"+v_id);
				int vnums = Integer.parseInt(v_nums);
				
				for(int f=0;f<vnums;f++)
				{
					String fnames = uploadFileFileName[fs-1].trim();
					String directory = "/upload/xls";  
					String targetDirectory = this.getServletContext().getRealPath(directory);  
					File file = new File(targetDirectory,fnames);
					FileUtils.copyFile(uploadFile[fs-1], file);		
				    File target = new File(targetDirectory,fnames); 
					//String targetPath = this.getServletContext().getRealPath("\\");
					InputStream is = new FileInputStream(target);
					//String filePath = request.getParameter("a"+(v_id+(f+1)) );
					String filePath = request.getParameter("a271");
					
					System.out.println(fi+"----fnames is:"+fnames+"-----filePath is:"+filePath);
					//InputStream is = new FileInputStream("D:\\"+filePath);
					jxl.Workbook rwb = Workbook.getWorkbook(is);
					Sheet rs = rwb.getSheet(0);
					//int vnums = Integer.parseInt(v_nums);
					for(int k=0;k<rs.getRows();k++)
					{
						QuestionInfoVo qs = new QuestionInfoVo();
						qs.setVv(vl);
						qs.setViid(v_id);
						qs.setQname(fnames.replace(".xls", ""));
						qs.setQuestion_nums(rs.getRows());
						qs.setJuanzi(vnums);
						qs.setQuestion(rs.getCell(0,k).getContents());
						qs.setAnswera(rs.getCell(1,k).getContents());
						qs.setAnswerb(rs.getCell(2,k).getContents());
						qs.setAnswerc(rs.getCell(3,k).getContents());
						qs.setAnswerd(rs.getCell(4,k).getContents());
						qs.setAnswer(rs.getCell(5,k).getContents());
						qvo.add(qs);
					}
					rwb.close();
					fs = fs -1;
				}
			}
			qvs.addAll(qvo);
		}
		System.out.println("xls toJson is:-----------"+TVUtility.toJson(qvs));
		
		//flow4 person
		//String selectNames = request.getParameter("selectname");
		String sfor = request.getParameter("sfor");
		String selectIds = request.getParameter("selectid");
		//System.out.println(sfor+"-------------"+selectIds);
		
		try
		{
			ctfService.Flow_All(tvo, vid, qvs, sfor,selectIds);
			request.setAttribute("Flows", "培训创建成功");
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			Utility.Log.e(CreateTrainFlowAction.class, "sql error:"+e.getMessage());
			throw e;
		}
		
		
		
		
		return CreateTrainFlowAction.SUCCESS;
	}
}
