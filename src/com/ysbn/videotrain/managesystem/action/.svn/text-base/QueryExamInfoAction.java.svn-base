package com.ysbn.videotrain.managesystem.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ysbn.videotrain.managesystem.service.IOperateUserExamInfoService;
import com.ysbn.videotrain.managesystem.vo.UserExamInfoVo;

public class QueryExamInfoAction extends BaseAction {

    /**
     * 
     */
    private static final long           serialVersionUID = 1L;
    private IOperateUserExamInfoService operateUserExamInfoService;
    private List<UserExamInfoVo>        userExamInfoVoList;
    private String                      count;
    private int                         pageCount;
    private String                      userName;
    private String                      smartCardNO;

    public List<UserExamInfoVo> getUserExamInfoVoList() {
        return userExamInfoVoList;
    }

    public void setUserExamInfoVoList(List<UserExamInfoVo> userExamInfoVoList) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSmartCardNO() {
        return smartCardNO;
    }

    public void setSmartCardNO(String smartCardNO) {
        this.smartCardNO = smartCardNO;
    }

    public void setOperateUserExamInfoService(IOperateUserExamInfoService operateUserExamInfoService) {
        this.operateUserExamInfoService = operateUserExamInfoService;
    }

    @Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("count");
        String selectFlag = request.getParameter("selectFlag");
        
        String fr = request.getParameter("fr");
        String lr = request.getParameter("lr");
        if ("".equals(fr) || fr == null) {
            fr = "1";
        }
        if ("".equals(lr) || lr == null) {
            lr = "20";
        }

        try {
            if (Integer.parseInt(fr) == 1) {
                //UserExamInfoVoList = new ArrayList<UserExamInfoVo>();
                if (selectFlag.equals("1")) {
                    String uName = request.getParameter("userName");
                    String sCard = request.getParameter("smartCard");
                    if ((uName != null && !("".equals(uName))) && (sCard != null && !("".equals(sCard)))) {
                        userExamInfoVoList = operateUserExamInfoService.queryUserExamInfo(uName, sCard);
                    } else if ((uName != null && !("".equals(uName))) && (sCard == null || "".equals(sCard))) {
                        userExamInfoVoList = operateUserExamInfoService.queryUserExamInfoByName(uName);
                    } else if ((uName == null || "".equals(uName)) && (sCard != null && !("".equals(sCard)))) {
                        userExamInfoVoList = operateUserExamInfoService.queryUserExamInfoBySmartCardNO(sCard);
                    }
                } else if (selectFlag.equals("2")) {
//                    String selectCompany = request.getParameter("selectCompany");
                    String selectDepart = request.getParameter("selectDepart");
                    String selectOffice = request.getParameter("selectOffice");
                    if(selectOffice.equals("all")){
                        userExamInfoVoList = operateUserExamInfoService.queryUserExamInfoByDepart(selectDepart);
                    }else{
                        userExamInfoVoList = operateUserExamInfoService.queryUserExamInfoByDepartAndOffice(selectDepart, selectOffice);
                    }
                } else if (selectFlag.equals("3")) {
                    String selectJob = request.getParameter("selectJob");
                    userExamInfoVoList = operateUserExamInfoService.queryUserExamInfoByJob(selectJob);
                }
                if (userExamInfoVoList != null && userExamInfoVoList.size() != 0) {
                    count = userExamInfoVoList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
//                    userName = uName;
//                    smartCardNO = sCard;
                }
            } else {
                List<UserExamInfoVo> ueList = new ArrayList<UserExamInfoVo>();
                userExamInfoVoList = new ArrayList<UserExamInfoVo>();
                if(selectFlag.equals("1")){
                    String uName = request.getParameter("userName");
                    String sCard = request.getParameter("smartCard");
                    if ((uName != null && !("".equals("uName"))) && (sCard != null && !("".equals("sCard")))) {
                        ueList = operateUserExamInfoService.queryUserExamInfo(uName, sCard);
                    } else if ((uName != null && !("".equals("uName"))) && (sCard == null || "".equals("sCard"))) {
                        ueList = operateUserExamInfoService.queryUserExamInfoByName(uName);
                    } else if ((uName == null || "".equals("uName")) && (sCard != null && !("".equals("sCard")))) {
                        ueList = operateUserExamInfoService.queryUserExamInfoBySmartCardNO(sCard);
                    }
                }else if(selectFlag.equals("2")){
                    String selectDepart = request.getParameter("selectDepart");
                    String selectOffice = request.getParameter("selectOffice");
                    if(selectOffice.equals("all")){
                        ueList = operateUserExamInfoService.queryUserExamInfoByDepart(selectDepart);
                    }else{
                        ueList = operateUserExamInfoService.queryUserExamInfoByDepartAndOffice(selectDepart, selectOffice);
                    }
                }else if(selectFlag.equals("3")){
                    String selectJob = request.getParameter("selectJob");
                    ueList = operateUserExamInfoService.queryUserExamInfoByJob(selectJob);
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
                UserExamInfoVo vo = new UserExamInfoVo();

                if (((ueList.size()) / 20) == 0 || ueList.size() >= Integer.parseInt(lr)) {

                    for (int i = Integer.parseInt(fr) - 1; i < Integer.parseInt(lr); i++) {
                        vo = ueList.get(i);
                        userExamInfoVoList.add(vo);
                    }
                    count = ueList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
//                    userName = uName;
//                    smartCardNO = sCard;
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
        session.removeAttribute("msg");
        return "success";
    }
}
