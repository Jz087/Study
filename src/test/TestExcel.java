package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ysbn.videotrain.managesystem.vo.UserInfoVo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class TestExcel {

	
	jxl.Workbook readwb = null;
	
	@SuppressWarnings("null")
	public static void main(String[] args)
	{
		
		try
		{
			InputStream is = new FileInputStream("D:\\test.xls");
			jxl.Workbook rwb = Workbook.getWorkbook(is);
			//获取第一张Sheet表
			Sheet rs = rwb.getSheet(0);
			//create list
			
			
			//获取第一行，第一列的值
			Cell c00 = rs.getCell(0, 0);
			String strc00 = c00.getContents();

			//获取第一行，第二列的值
			Cell c10 = rs.getCell(1, 0);
			String strc10 = c10.getContents();

			//获取第二行，第二列的值
			Cell c11 = rs.getCell(1, 1);
			String strc11 = c11.getContents();

			//System.out.println(rs.getColumns()+"@"+rs.getRows());
			List<UserInfoVo> uservo = new ArrayList<UserInfoVo>();
			
			for(int i=0;i<rs.getRows();i++)
			{
				UserInfoVo us = new UserInfoVo() ;
			
				us.setUser_icid(rs.getCell(0,i).getContents());
				us.setUser_name(rs.getCell(1,i).getContents());
				us.setUser_phone(rs.getCell(2,i).getContents());
				
				uservo.add(us);
			}
			
			Gson gson = new Gson();
			System.out.println(gson.toJson(uservo));
			/*System.out.println("Cell(0, 0)" + " value : " + strc00 + "; type : " + c00.getType());
			System.out.println("Cell(1, 0)" + " value : " + strc10 + "; type : " + c10.getType());
			System.out.println("Cell(1, 1)" + " value : " + strc11 + "; type : " + c11.getType());*/
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
}
