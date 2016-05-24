package com.ysbn.videotrain.managesystem.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hctn.dev.toolkit.util.Utility;
import com.ysbn.videotrain.managesystem.service.OperateVideoInfoService;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;

public class QueryVideoInfoAction extends BaseAction {

    /**
     * 
     */
    private static final long       serialVersionUID = 1L;
    private OperateVideoInfoService operateVideoInfoService;
    private List<VideoInfoVo>       videoInfoList;
    private String                  count;
    private int                     pageCount;

    public void setOperateVideoInfoService(OperateVideoInfoService operateVideoInfoService) {
        this.operateVideoInfoService = operateVideoInfoService;
    }

    public List<VideoInfoVo> getVideoInfoList() {
        return videoInfoList;
    }

    public void setVideoInfoList(List<VideoInfoVo> videoInfoList) {
        this.videoInfoList = videoInfoList;
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

    @Override
    String process() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute("count");
        String videoName = request.getParameter("videoName");
        String fr = request.getParameter("fr");
        String lr = request.getParameter("lr");
        String msg = (String) session.getAttribute("msg");
        if (fr == null || "".equals(fr) || fr.length() == 0) {
            fr = "1";
        }
        if (lr == null || "".equals(lr) || lr.length() == 0) {
            lr = "20";
        }

        try {
            if (Integer.parseInt(fr) == 1) {
                if (videoName == null || "".equals(videoName) || videoName.length() == 0) {
                    videoInfoList = operateVideoInfoService.queryVideoInfo();
                } else {
                    videoInfoList = operateVideoInfoService.queryVideoInfoByName(videoName);
                }
                if (videoInfoList.size() != 0) {
                    count = videoInfoList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
                }
            } else {
                List<VideoInfoVo> vList = new ArrayList<VideoInfoVo>();
                videoInfoList = new ArrayList<VideoInfoVo>();
                if (videoName == null || "".equals(videoName) || videoName.length() == 0) {
                    vList = operateVideoInfoService.queryVideoInfo();
                } else {
                    vList = operateVideoInfoService.queryVideoInfoByName(videoName);
                }
                VideoInfoVo vo = new VideoInfoVo();

                if (videoInfoList != null && videoInfoList.size() != 0) {
                    for (int l = 0; l < videoInfoList.size(); l++) {
                        l = 0;
                        videoInfoList.remove(l);
                    }
                    if (videoInfoList.size() == 1) {
                        videoInfoList.remove(0);
                    }
                }
                if (((vList.size()) / 20) == 0 || vList.size() >= Integer.parseInt(lr)) {

                    for (int i = Integer.parseInt(fr) - 1; i < Integer.parseInt(lr); i++) {
                        vo = vList.get(i);
                        videoInfoList.add(vo);
                    }
                    count = vList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
                } else {
                    for (int i = Integer.parseInt(fr) - 1; i < vList.size(); i++) {
                        vo = vList.get(i);
                        videoInfoList.add(vo);
                    }
                    count = vList.size() + "";
                    pageCount = (int) Math.ceil((Double.parseDouble(count)) / 20);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Utility.Log.e(QueryVideoInfoAction.class, e.getMessage());
            throw e;
        }
        session.setAttribute("count", count);
        session.setAttribute("pageCount", pageCount);
        request.setAttribute("msg", msg);
        session.removeAttribute("msg");
        return "success";
    }

    public static void main(String[] args) {
        String a = "insert into dvideoinfo (vi_agencyid, vi_name, vi_totaltime, vi_createtime, vi_publishflag, vi_passmask, vi_credit) values (VI_ID.nextval,?,?,TO_CHAR(SYSDATE, 'yyyy-mm-dd'),?,?,?)";
        System.out.println(a.toUpperCase());
    }
}
