package com.ysbn.videotrain.managesystem.vo;

public class VideoInfoVo {
    private int    videoID;
    private String videoName;
    private int    videoTotalTime;
    private String videoCreateTime;
    private String videoPublishFlag;
    private int    videoPassMask;
    private int    videoCredit;

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getVideoTotalTime() {
        return videoTotalTime;
    }

    public void setVideoTotalTime(int videoTotalTime) {
        this.videoTotalTime = videoTotalTime;
    }

    public String getVideoCreateTime() {
        return videoCreateTime;
    }

    public void setVideoCreateTime(String videoCreateTime) {
        this.videoCreateTime = videoCreateTime;
    }

    public String getVideoPublishFlag() {
        return videoPublishFlag;
    }

    public void setVideoPublishFlag(String videoPublishFlag) {
        this.videoPublishFlag = videoPublishFlag;
    }

    public int getVideoPassMask() {
        return videoPassMask;
    }

    public void setVideoPassMask(int videoPassMask) {
        this.videoPassMask = videoPassMask;
    }

    public int getVideoCredit() {
        return videoCredit;
    }

    public void setVideoCredit(int videoCredit) {
        this.videoCredit = videoCredit;
    }
}
