package com.ysbn.videotrain.managesystem.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ysbn.videotrain.managesystem.service.IOperateUserExamInfoService;
import com.ysbn.videotrain.managesystem.vo.UserRecordVo;

public class QueryUserRecordAction extends BaseAction {

    /**
     * 
     */
    private static final long           serialVersionUID = 1L;
    private IOperateUserExamInfoService operateUserExamInfoService;
    private List<UserRecordVo>          userExamInfoVoList;
    private String                      count;
    private int                         pageCount;

    public List<UserRecordVo> getUserExamInfoVoList() {
        return userExamInfoVoList;
    }

    public void setUserExamInfoVoList(List<UserRecordVo> userExamInfoVoList) {
        this.userExamInfoVoList = userExamInfoVoList;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setOperateUserExamInfoService(IOperateUserExamInfoService operateUserExamInfoService) {
        this.operateUserExamInfoService = operateUserExamInfoService;
    }

    @Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String fr = request.getParameter("fr");
        String lr = request.getParameter("lr");
        String selVal = request.getParameter("selVal");
        String sele = request.getParameter("sele");

        try {
            if (Integer.parseInt(fr) == 1) {
                if (selVal.equals("1")) {
                    userExamInfoVoList = operateUserExamInfoService.queryUserrecordByUserName(sele);
                } else if (selVal.equals("2")) {
                    userExamInfoVoList = operateUserExamInfoService
                        .queryUserrecordBysmartCardNO(sele);
                } else if (selVal.equals("3")) {
                    userExamInfoVoList = operateUserExamInfoService
                        .queryUserrecordByDepartname(sele);
                } else if (selVal.equals("4")) {
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
                if (userExamInfoVoList != null || userExamInfoVoList.size() != 0) {
                    count = userExamInfoVoList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
                }
            } else {
                List<UserRecordVo> ueList = new ArrayList<UserRecordVo>();
                userExamInfoVoList = new ArrayList<UserRecordVo>();
                if (selVal.equals("1")) {
                    ueList = operateUserExamInfoService.queryUserrecordByUserName(sele);
                } else if (selVal.equals("2")) {
                    ueList = operateUserExamInfoService.queryUserrecordBysmartCardNO(sele);
                } else if (selVal.equals("3")) {
                    ueList = operateUserExamInfoService.queryUserrecordByDepartname(sele);
                } else if (selVal.equals("4")) {
                    ueList = operateUserExamInfoService.queryUserrecordByCulName(sele);
                }

                if (userExamInfoVoList != null && userExamInfoVoList.size() != 0) {
                    for (int l = 0; l < userExamInfoVoList.size(); l++) {
                        l = 0;
                        userExamInfoVoList.remove(l);
                    }
                    if (userExamInfoVoList.size() == 1) {
                        userExamInfoVoList.remove(0);
                    }
                }
                UserRecordVo vo = new UserRecordVo();

                if (((ueList.size()) / 20) == 0 || ueList.size() >= Integer.parseInt(lr)) {

                    for (int i = Integer.parseInt(fr) - 1; i < Integer.parseInt(lr); i++) {
                        vo = ueList.get(i);
                        userExamInfoVoList.add(vo);
                    }
                    count = ueList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
                } else {
                    for (int i = Integer.parseInt(fr) - 1; i < ueList.size(); i++) {
                        vo = ueList.get(i);
                        userExamInfoVoList.add(vo);
                    }
                    count = ueList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("count", count);
        session.setAttribute("pageCount", pageCount);
        return "success";
    }
}
