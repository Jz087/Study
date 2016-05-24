package com.ysbn.videotrain.managesystem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.ysbn.videotrain.managesystem.service.OperateVideoInfoService;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;

public class OperateVideoInfoAction extends BaseAction {

    /**
     * 
     */
    private static final long       serialVersionUID = 1L;
    private OperateVideoInfoService operateVideoInfoService;

    public OperateVideoInfoService getOperateVideoInfoService() {
        return operateVideoInfoService;
    }

    public void setOperateVideoInfoService(OperateVideoInfoService operateVideoInfoService) {
        this.operateVideoInfoService = operateVideoInfoService;
    }

    @Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("msg");
        String operateFlag = request.getParameter("operateFlag");
        String result = "success";
        int res = 0;
        String msg = "";
        if (operateFlag.equals("add")) {
            String videoName = request.getParameter("videoName");
            int videoTotalTime = Integer.parseInt(request.getParameter("videoTotalTime"));
            String videoPublishFlag = request.getParameter("videoPublishFlag");
            int videoPassMask = Integer.parseInt(request.getParameter("videoPassMask"));
            int videoCredit = Integer.parseInt(request.getParameter("videoCredit"));

            VideoInfoVo videoInfoVo = new VideoInfoVo();
            videoInfoVo.setVideoName(videoName);
            videoInfoVo.setVideoTotalTime(videoTotalTime);
            videoInfoVo.setVideoPublishFlag(videoPublishFlag);
            videoInfoVo.setVideoPassMask(videoPassMask);
            videoInfoVo.setVideoCredit(videoCredit);

            res = operateVideoInfoService.insert(videoInfoVo);
            if (res == 1) {
                msg = "视频信息添加成功！";
            } else {
                msg = "视频信息添加失败！";
            }
            result = "insert";
        } else if (operateFlag.equals("del")) {
            int videoID = Integer.parseInt(request.getParameter("videoID"));
            res = operateVideoInfoService.delete(videoID);
            if (res == 1) {
                msg = "视频信息删除成功！";
            } else {
                msg = "视频信息删除失败！";
            }
            result = "delete";
        } else if (operateFlag.equals("update")) {
            int vID = Integer.parseInt(request.getParameter("videoID"));
            VideoInfoVo videoInfoVo = operateVideoInfoService.queryVideoInfoByID(vID).get(0);
            int videoID = videoInfoVo.getVideoID();
            String videoName = videoInfoVo.getVideoName();
            int videoTotalTime = videoInfoVo.getVideoTotalTime();
            String videoCreateTime = videoInfoVo.getVideoCreateTime();
            String videoPublishFlag = videoInfoVo.getVideoPublishFlag();
            int videoPassMask = videoInfoVo.getVideoPassMask();
            int videoCredit = videoInfoVo.getVideoCredit();

            request.setAttribute("videoID", videoID);
            request.setAttribute("videoName", videoName);
            request.setAttribute("videoTotalTime", videoTotalTime);
            request.setAttribute("videoCreateTime", videoCreateTime);
            request.setAttribute("videoPublishFlag", videoPublishFlag);
            request.setAttribute("videoPassMask", videoPassMask);
            request.setAttribute("videoCredit", videoCredit);

            result = "update";
        } else if (operateFlag.equals("updateVideoInfo")) {
            int videoID = Integer.parseInt(request.getParameter("videoID"));
            String videoName = request.getParameter("videoName");
            int videoTotalTime = Integer.parseInt(request.getParameter("videoTotalTime"));
            String videoCreateTime = request.getParameter("videoCreateTime");
            String videoPublishFlag = request.getParameter("videoPublishFlag");
            int videoPassMask = Integer.parseInt(request.getParameter("videoPassMask"));
            int videoCredit = Integer.parseInt(request.getParameter("videoCredit"));

            VideoInfoVo videoInfoVo = new VideoInfoVo();
            videoInfoVo.setVideoID(videoID);
            videoInfoVo.setVideoName(videoName);
            videoInfoVo.setVideoTotalTime(videoTotalTime);
            videoInfoVo.setVideoCreateTime(videoCreateTime);
            videoInfoVo.setVideoPublishFlag(videoPublishFlag);
            videoInfoVo.setVideoPassMask(videoPassMask);
            videoInfoVo.setVideoCredit(videoCredit);

            res = operateVideoInfoService.update(videoInfoVo);
            if (res == 1) {
                msg = "视频信息修改成功！";
            } else {
                msg = "视频信息修改失败！";
            }
            result = "updateVideoInfo";
        }
        request.setAttribute("msg", msg);
        session.setAttribute("msg", msg);
        return result;
    }
}
