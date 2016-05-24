package com.ysbn.videotrain.managesystem.action;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.ysbn.videotrain.managesystem.service.IOperateUserExamInfoService;
import com.ysbn.videotrain.managesystem.vo.UserExamInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserRecordVo;

public class GetExcelAction extends BaseAction {

    /**
     * 
     */
    private static final long    serialVersionUID = 1L;
    private IOperateUserExamInfoService operateUserExamInfoService;

    public IOperateUserExamInfoService getOperateUserExamInfoService() {
        return operateUserExamInfoService;
    }
    public void setOperateUserExamInfoService(IOperateUserExamInfoService operateUserExamInfoService) {
        this.operateUserExamInfoService = operateUserExamInfoService;
    }


    @Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String excelFlag = request.getParameter("excelFlag");
        if (excelFlag.equals("examRecord")) {
            List<UserExamInfoVo> userExamInfoList = new ArrayList<UserExamInfoVo>();
            String selectFlag = request.getParameter("selectFlag");
            if (selectFlag.equals("1")) {
                String uName = request.getParameter("userName");
                String sCard = request.getParameter("smartCard");
                if ((uName != null && !("".equals(uName))) && (sCard != null && !("".equals(sCard)))) {
                    userExamInfoList = operateUserExamInfoService.queryUserExamInfo(uName, sCard);
                } else if ((uName != null && !("".equals(uName))) && (sCard == null || "".equals(sCard))) {
                    userExamInfoList = operateUserExamInfoService.queryUserExamInfoByName(uName);
                } else if ((uName == null || "".equals(uName)) && (sCard != null && !("".equals(sCard)))) {
                    userExamInfoList = operateUserExamInfoService.queryUserExamInfoBySmartCardNO(sCard);
                }
            } else if(selectFlag.equals("2")){
                String selectDepart = request.getParameter("selectDepart");
                String selectOffice = request.getParameter("selectOffice");
                if(selectOffice.equals("all")){
                    userExamInfoList = operateUserExamInfoService.queryUserExamInfoByDepart(selectDepart);
                }else{
                    userExamInfoList = operateUserExamInfoService.queryUserExamInfoByDepartAndOffice(selectDepart, selectOffice);
                }
            }else if(selectFlag.equals("3")){
                String selectJob = request.getParameter("selectJob");
                userExamInfoList = operateUserExamInfoService.queryUserExamInfoByJob(selectJob);
            }
            
            if (userExamInfoList != null) {
                int listLen = userExamInfoList.size();
                String fileName = "考试记录查询.xls";
                fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
                response.reset();
                response.setHeader("Content-Disposition", "attachment;filename=" + fileName);//指定下载的文件名   
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
                OutputStream output = response.getOutputStream();
                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);

                //定义单元格报头   
                String worksheetTitle = "员工考试记录";

                HSSFWorkbook wb = new HSSFWorkbook();

                //创建列标头LIST   
                List<String> fialList = new ArrayList<String>();
                fialList.add("培训编号");
                fialList.add("员工姓名");
                fialList.add("部门名称");
                fialList.add("智能卡号");
                fialList.add("视频编号");
                fialList.add("试卷编号");
                fialList.add("试卷总分");
                fialList.add("员工答案");
                fialList.add("培训学分");
                fialList.add("培训时间");

                // 计算该报表的列数   
                int number = fialList.size() - 1;
                //==================================================================   
                // 创建单元格样式   
                HSSFCellStyle cellStyleTitle = wb.createCellStyle();
                // 指定单元格居中对齐   
                cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                // 指定单元格垂直居中对齐   
                cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                // 指定当单元格内容显示不下时自动换行   
                cellStyleTitle.setWrapText(true);
                //------------------------------------------------------------------   
                HSSFCellStyle cellStyle = wb.createCellStyle();
                // 指定单元格居中对齐   
                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                // 指定单元格垂直居中对齐   
                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                // 指定当单元格内容显示不下时自动换行   
                cellStyle.setWrapText(true);
                //------------------------------------------------------------------   
                // 设置单元格字体   
                HSSFFont font = wb.createFont();
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                font.setFontName("宋体");
                font.setFontHeight((short) 200);
                cellStyleTitle.setFont(font);
                int sheetCount = 0;
                int sheetRowNum = 65000;
                int res = listLen % sheetRowNum;
                if (res == 0) {
                    sheetCount = listLen / sheetRowNum;
                } else {
                    sheetCount = (listLen / sheetRowNum) + 1;
                }

                for (int z = 0; z < sheetCount; z++) {
                    //工作表名   
                    String worksheet = "表" + (z + 1);

                    HSSFSheet sheet = wb.createSheet(worksheet);
                    sheet.setColumnWidth(0, 6666);
                    sheet.setColumnWidth(1, 6666);
                    sheet.setColumnWidth(2, 6666);
                    sheet.setColumnWidth(3, 6666);
                    sheet.setColumnWidth(4, 6666);
                    sheet.setColumnWidth(5, 6666);
                    sheet.setColumnWidth(6, 6666);
                    sheet.setColumnWidth(7, 6666);
                    sheet.setColumnWidth(8, 6666);
                    sheet.setColumnWidth(9, 6666);

                    ExportExcel exportExcel = new ExportExcel(wb, sheet);

                    // 创建报表头部   
                    exportExcel.createNormalHead(worksheetTitle, number);
                    //定义第一行   
                    HSSFRow row1 = sheet.createRow(1);
                    HSSFCell cell1 = null;

                    for (int i = 0; i < fialList.size(); i++) {
                        cell1 = row1.createCell(i);
                        cell1.setCellStyle(cellStyleTitle);
                        cell1.setCellValue(new HSSFRichTextString(fialList.get(i).toString()));
                    }
                    HSSFRow row = sheet.createRow(2);
                    HSSFCell cell = row.createCell(1);
                    UserExamInfoVo domain = new UserExamInfoVo();
                    int startNum = z * sheetRowNum;
                    int endNum = (z + 1) * sheetRowNum;
                    if (z == (sheetCount - 1)) {
                        endNum = listLen;
                    }
                    for (int i = startNum; i < endNum; i++) {
                        domain = userExamInfoList.get(i);
                        row = sheet.createRow(i + 2);
                        cell = row.createCell(0);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue(new HSSFRichTextString(domain.getAgencyid()+""));
                        cell = row.createCell(1);
                        cell.setCellValue(new HSSFRichTextString(domain.getUserName()));
                        cell = row.createCell(2);
                        cell.setCellValue(new HSSFRichTextString(domain.getDepartname()));
                        cell = row.createCell(3);
                        cell.setCellValue(new HSSFRichTextString(domain.getSmartCardNO()));
                        cell = row.createCell(4);
                        cell.setCellValue(new HSSFRichTextString(domain.getViagenID()+""));
                        cell = row.createCell(5);
                        cell.setCellValue(new HSSFRichTextString(domain.getEpagenID()+""));
                        cell = row.createCell(6);
                        cell.setCellValue(new HSSFRichTextString(domain.getScore()+""));
                        cell = row.createCell(7);
                        cell.setCellValue(new HSSFRichTextString(domain.getAnswer()));
                        cell = row.createCell(8);
                        cell.setCellValue(new HSSFRichTextString(domain.getCredit()+""));
                        cell = row.createCell(9);
                        cell.setCellValue(new HSSFRichTextString(domain.getExamTime()));
                    }
                }
                try {
                    bufferedOutPut.flush();
                    wb.write(bufferedOutPut);
                    bufferedOutPut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Output   is   closed ");
                } finally {
                    userExamInfoList.clear();
                }
            }
        } else if (excelFlag.equals("userRecord")) {
            List<UserRecordVo> userExamInfoVoList = new ArrayList<UserRecordVo>();
            String selVal = request.getParameter("selVal");
            if (selVal.equals("1")) {
                String sele = request.getParameter("sele");
                userExamInfoVoList = operateUserExamInfoService.queryUserrecordByUserName(sele);
            } else if (selVal.equals("2")) {
                String sele = request.getParameter("sele");
                userExamInfoVoList = operateUserExamInfoService.queryUserrecordBysmartCardNO(sele);
            } else if (selVal.equals("3")) {
                String sele = request.getParameter("sele");
                userExamInfoVoList = operateUserExamInfoService.queryUserrecordByDepartname(sele);
            } else if (selVal.equals("4")) {
                String sele = request.getParameter("sele");
                userExamInfoVoList = operateUserExamInfoService.queryUserrecordByCulName(sele);
            }else if(selVal.equals("5")){
                String selectDepart = request.getParameter("selectDepart");
                String selectOffice = request.getParameter("selectOffice");
                if(selectOffice.equals("all")){
                    userExamInfoVoList = operateUserExamInfoService.queryUserrecordByDepart(selectDepart);
                }else{
                    userExamInfoVoList = operateUserExamInfoService.queryUserrecordByDepartAndOffice(selectDepart, selectOffice);
                }
            }else if(selVal.equals("6")){
                String selectJob = request.getParameter("selectJob");
                userExamInfoVoList = operateUserExamInfoService.queryUserrecordByJob(selectJob);
            }
            
            if (userExamInfoVoList != null) {
                int listLen = userExamInfoVoList.size();
                String fileName = "人员培训记录.xls";
                fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
                response.reset();
                response.setHeader("Content-Disposition", "attachment;filename=" + fileName);//指定下载的文件名   
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
                OutputStream output = response.getOutputStream();
                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);

                //定义单元格报头   
                String worksheetTitle = "员工培训记录";

                HSSFWorkbook wb = new HSSFWorkbook();

                //创建列标头LIST   
                List<String> fialList = new ArrayList<String>();
                fialList.add("员工姓名");
                fialList.add("智能卡号");
                fialList.add("部门名称");
                fialList.add("培训名称");
                fialList.add("试卷总分");
                fialList.add("培训视频");

                // 计算该报表的列数   
                int number = fialList.size() - 1;
                //==================================================================   
                // 创建单元格样式   
                HSSFCellStyle cellStyleTitle = wb.createCellStyle();
                // 指定单元格居中对齐   
                cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                // 指定单元格垂直居中对齐   
                cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                // 指定当单元格内容显示不下时自动换行   
                cellStyleTitle.setWrapText(true);
                //------------------------------------------------------------------   
                HSSFCellStyle cellStyle = wb.createCellStyle();
                // 指定单元格居中对齐   
                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                // 指定单元格垂直居中对齐   
                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                // 指定当单元格内容显示不下时自动换行   
                cellStyle.setWrapText(true);
                //------------------------------------------------------------------   
                // 设置单元格字体   
                HSSFFont font = wb.createFont();
                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                font.setFontName("宋体");
                font.setFontHeight((short) 200);
                cellStyleTitle.setFont(font);
                int sheetCount = 0;
                int sheetRowNum = 65000;
                int res = listLen % sheetRowNum;
                if (res == 0) {
                    sheetCount = listLen / sheetRowNum;
                } else {
                    sheetCount = (listLen / sheetRowNum) + 1;
                }

                for (int z = 0; z < sheetCount; z++) {
                    //工作表名   
                    String worksheet = "表" + (z + 1);

                    HSSFSheet sheet = wb.createSheet(worksheet);
                    sheet.setColumnWidth(0, 6666);
                    sheet.setColumnWidth(1, 6666);
                    sheet.setColumnWidth(2, 6666);
                    sheet.setColumnWidth(3, 6666);
                    sheet.setColumnWidth(4, 6666);
                    sheet.setColumnWidth(5, 9666);

                    ExportExcel exportExcel = new ExportExcel(wb, sheet);

                    // 创建报表头部   
                    exportExcel.createNormalHead(worksheetTitle, number);
                    //定义第一行   
                    HSSFRow row1 = sheet.createRow(1);
                    HSSFCell cell1 = null;

                    for (int i = 0; i < fialList.size(); i++) {
                        cell1 = row1.createCell(i);
                        cell1.setCellStyle(cellStyleTitle);
                        cell1.setCellValue(new HSSFRichTextString(fialList.get(i).toString()));
                    }
                    HSSFRow row = sheet.createRow(2);
                    HSSFCell cell = row.createCell(1);
                    UserRecordVo domain = new UserRecordVo();
                    int startNum = z * sheetRowNum;
                    int endNum = (z + 1) * sheetRowNum;
                    if (z == (sheetCount - 1)) {
                        endNum = listLen;
                    }
                    for (int i = startNum; i < endNum; i++) {
                        domain = userExamInfoVoList.get(i);
                        row = sheet.createRow(i + 2);
                        cell = row.createCell(0);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue(new HSSFRichTextString(domain.getUserName()));
                        cell = row.createCell(1);
                        cell.setCellValue(new HSSFRichTextString(domain.getSmartCardNO()));
                        cell = row.createCell(2);
                        cell.setCellValue(new HSSFRichTextString(domain.getDepartName()));
                        cell = row.createCell(3);
                        cell.setCellValue(new HSSFRichTextString(domain.getCulName()));
                        cell = row.createCell(4);
                        cell.setCellValue(new HSSFRichTextString(domain.getScore()+""));
                        cell = row.createCell(5);
                        cell.setCellValue(new HSSFRichTextString(domain.getVideoName()));
                    }
                }
                try {
                    bufferedOutPut.flush();
                    wb.write(bufferedOutPut);
                    bufferedOutPut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Output   is   closed ");
                } finally {
                    userExamInfoVoList.clear();
                }
            }
        }
        return null;
    }
}
