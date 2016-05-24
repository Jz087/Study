package com.ysbn.videotrain.managesystem.action;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ysbn.videotrain.managesystem.service.IOperateUserExamInfoService;
import com.ysbn.videotrain.managesystem.service.OperateVideoInfoService;
import com.ysbn.videotrain.managesystem.vo.ExamRecordVo;
import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserCulVo;
import com.ysbn.videotrain.managesystem.vo.UserDepartVo;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;
import com.ysbn.videotrain.managesystem.vo.VideoRecordVo;

public class OperateUserExamInfoAction extends BaseAction {

    /**
     * 
     */
    private static final long           serialVersionUID = 1L;
    private IOperateUserExamInfoService operateUserExamInfoService;
    private OperateVideoInfoService     operateVideoInfoService;

    public IOperateUserExamInfoService getOperateUserExamInfoService() {
        return operateUserExamInfoService;
    }

    public void setOperateUserExamInfoService(IOperateUserExamInfoService operateUserExamInfoService) {
        this.operateUserExamInfoService = operateUserExamInfoService;
    }

    public OperateVideoInfoService getOperateVideoInfoService() {
        return operateVideoInfoService;
    }

    public void setOperateVideoInfoService(OperateVideoInfoService operateVideoInfoService) {
        this.operateVideoInfoService = operateVideoInfoService;
    }

    @Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String operateFlag = request.getParameter("operateFlag");
        String result = "success";
        if (operateFlag.equals("detail")) {
            int videoID = Integer.parseInt(request.getParameter("videoID"));
            List<VideoInfoVo> videoInfoList = operateVideoInfoService.queryVideoInfoByID(videoID);
            String videoName = videoInfoList.get(0).getVideoName();
            int totalTime = videoInfoList.get(0).getVideoTotalTime();
            List<VideoRecordVo> videoRecordVoList = operateUserExamInfoService.queryVideoRecord(videoID);
            VideoRecordVo vo = videoRecordVoList.get(0);
            request.setAttribute("agencyID", vo.getAgencyID());
            request.setAttribute("videoName", videoName);
            request.setAttribute("smartCardNO", vo.getSmartCardNO());
            request.setAttribute("cragenID", vo.getCragenID());
            request.setAttribute("crculID", vo.getCrculID());
            request.setAttribute("viagenID", vo.getViagenID());
            String Progress = vo.getProgress()+"%";
            request.setAttribute("progress", Progress);
            String toTime = totalTime + "";
            request.setAttribute("totalTime", toTime);
            //String re = this.getPercent(vo.getProgress(), totalTime);
            //request.setAttribute("pro", re);
            request.setAttribute("examFlag", vo.getExamFlag());
            request.setAttribute("studyTime", vo.getStudyTime());

            result = "deta";
        } else if (operateFlag.equals("userDepartDetail")) {
            String smartCardNO = request.getParameter("smartCardNO");
            List<UserDepartVo> udList = operateUserExamInfoService.queryUD(smartCardNO);

            request.setAttribute("userName", udList.get(0).getUserName());
            request.setAttribute("smartCardNO", udList.get(0).getSmartCardNO());
            //request.setAttribute("sex", udList.get(0).getSex());
            request.setAttribute("position", udList.get(0).getPosition());
            request.setAttribute("birthday", udList.get(0).getBirthday());
            request.setAttribute("phone", udList.get(0).getPhone());
            request.setAttribute("email", udList.get(0).getEmail());
            request.setAttribute("polstatus", udList.get(0).getPolstatus());
            request.setAttribute("departName", udList.get(0).getDepartName());
            request.setAttribute("level", udList.get(0).getLevel());
            request.setAttribute("belong", udList.get(0).getBelong());
            request.setAttribute("useFlag", udList.get(0).getUseFlag());
            request.setAttribute("describe", udList.get(0).getDescribe());

            result = "userDepartDetail";
        } else if (operateFlag.equals("culDetail")) {
            String culName = request.getParameter("culName");
            List<UserCulVo> cuList = operateUserExamInfoService.queryCulByCulName(culName);
            request.setAttribute("culID", cuList.get(0).getCulID());
            request.setAttribute("culName", cuList.get(0).getCulName());
            request.setAttribute("studyTime", cuList.get(0).getStudyTime());
            request.setAttribute("studyEnd", cuList.get(0).getStudyEnd());
            request.setAttribute("createTime", cuList.get(0).getCreateTime());
            request.setAttribute("describe", cuList.get(0).getDescribe());

            result = "culDetail";
        } else if (operateFlag.equals("examRecordDetail")) {
            //考试记录ID
            int erID = Integer.parseInt(request.getParameter("erID"));
            //试卷ID
            int epID = Integer.parseInt(request.getParameter("epID"));
            List<ExamRecordVo> examList = operateUserExamInfoService.queryExamRecord(erID, epID);
            
            if(examList==null || examList.size()==0){
                result = "examRecordDetail";
            }else{
                String qiAgencyID = examList.get(0).getQiAgenID();
                List<QuestionInfoVo> questionInfoList = new ArrayList<QuestionInfoVo>();
                if(qiAgencyID.contains(",")){
                    String[] qIDS = qiAgencyID.split(",");
                    for(int i=0;i<qIDS.length;i++){
                        List<QuestionInfoVo> qList = operateUserExamInfoService.queryQuestionInfoVo(Integer.parseInt(qIDS[i]));
                        if(qList!=null && qList!=null){
                            questionInfoList.add(qList.get(0));
                        }
                    }
                }else{
                    List<QuestionInfoVo> qList = operateUserExamInfoService.queryQuestionInfoVo(Integer.parseInt(qiAgencyID));
                    if(qList!=null && qList!=null){
                        questionInfoList.add(qList.get(0));
                    }
                }
                
                request.setAttribute("smartCardNO", examList.get(0).getSmartCardNO());
                request.setAttribute("epName", examList.get(0).getEpName());
                request.setAttribute("score", examList.get(0).getScore());
                request.setAttribute("answer", examList.get(0).getAnswer());
                request.setAttribute("credit", examList.get(0).getCredit());
                request.setAttribute("examTime", examList.get(0).getExamTime());
                request.setAttribute("questionInfoList", questionInfoList);
                request.setAttribute("beginNum", 0);
                if(questionInfoList!=null && questionInfoList.size()>0){
                    request.setAttribute("endNum", questionInfoList.size()-1);
                }else{
                    request.setAttribute("endNum", 0);
                }
            }

            result = "examRecordDetail";
        } else if (operateFlag.equals("videoDetail")) {
            String smartCardNO = request.getParameter("smartCardNO");
            int videoID = Integer.parseInt(request.getParameter("videoID"));

            List<VideoInfoVo> videoInfoList = operateVideoInfoService.queryVideoInfoByID(videoID);
            String videoName = videoInfoList.get(0).getVideoName();
            int totalTime = videoInfoList.get(0).getVideoTotalTime();
            List<VideoRecordVo> videoRecordVoList = operateUserExamInfoService.queryViRecord(smartCardNO, videoID);
            VideoRecordVo vo = videoRecordVoList.get(0);
            request.setAttribute("videoName", videoName);
            request.setAttribute("smartCardNO", vo.getSmartCardNO());
            String Progress = vo.getProgress()+"%";
            request.setAttribute("progress", Progress);
            String toTime = this.changeSecond(totalTime);
            request.setAttribute("totalTime", toTime);
            //String re = this.getPercent(vo.getProgress(), totalTime);
            //request.setAttribute("pro", re);
            request.setAttribute("examFlag", vo.getExamFlag());
            request.setAttribute("studyTime", vo.getStudyTime());

            result = "videoDetail";
        }

        return result;
    }

    public String getPercent(int num1, int num2) {
        //        int num1 = 12;
        //        int num2 = 50;
        // 创建一个数值格式化对象   
        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位   
        numberFormat.setMaximumFractionDigits(2);

        String res = numberFormat.format((float) num1 / (float) num2 * 100);
        int index = 0;
        String str = res;
        String subStr = ".";
        int len = str.indexOf(subStr, index);
        if (res.contains(".")) {
            res = res.substring(0, len);
        }

        String result = res + "%";
        return result;
    }

    //秒转时分秒
    public String changeSecond(int second) {
//        String str = "";
        int hour = 0;
        int minute = 0;
        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }

        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String strtime = hour + "小时" + minute + "分钟" + second + "秒";
        return strtime;
    }
}
