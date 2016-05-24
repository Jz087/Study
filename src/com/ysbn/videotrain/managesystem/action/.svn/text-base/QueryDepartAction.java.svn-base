package com.ysbn.videotrain.managesystem.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ysbn.videotrain.managesystem.service.IOperateUserExamInfoService;
import com.ysbn.videotrain.managesystem.vo.DepartVo;

public class QueryDepartAction extends BaseAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IOperateUserExamInfoService operateUserExamInfoService;
    private List<DepartVo>        departVoList;
    

    public List<DepartVo> getDepartVoList() {
        return departVoList;
    }
    public void setDepartVoList(List<DepartVo> departVoList) {
        this.departVoList = departVoList;
    }

    public void setOperateUserExamInfoService(IOperateUserExamInfoService operateUserExamInfoService) {
        this.operateUserExamInfoService = operateUserExamInfoService;
    }

    @Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String selectFlag = request.getParameter("selectFlag");
        if(selectFlag.equals("1")){
            String companyCode = request.getParameter("companyFlag");
            departVoList = operateUserExamInfoService.queryDepartByCompany(companyCode);
        }else if(selectFlag.equals("2")){
            String departFlag = request.getParameter("departFlag");
            departFlag = departFlag.substring(0, 3);
            departVoList = operateUserExamInfoService.queryOfficeByDepart(departFlag);
        }
        return "success";
    }
}
