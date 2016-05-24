package com.ysbn.videotrain.managesystem.vo;

public class VideoRecordVo {
    private int    agencyID;
    private String smartCardNO;
    private int    cragenID;
    private int    crculID;
    private String crCulName;
    private int    viagenID;
    private String videoName;
    private int    progress;
    private String examFlag;
    private String studyTime;

    public int getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }

    public String getSmartCardNO() {
        return smartCardNO;
    }

    public void setSmartCardNO(String smartCardNO) {
        this.smartCardNO = smartCardNO;
    }

    public int getCragenID() {
        return cragenID;
    }

    public void setCragenID(int cragenID) {
        this.cragenID = cragenID;
    }

    public int getCrculID() {
        return crculID;
    }

    public void setCrculID(int crculID) {
        this.crculID = crculID;
    }

    public int getViagenID() {
        return viagenID;
    }

    public void setViagenID(int viagenID) {
        this.viagenID = viagenID;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getExamFlag() {
        return examFlag;
    }

    public void setExamFlag(String examFlag) {
        this.examFlag = examFlag;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getCrCulName() {
        return crCulName;
    }

    public void setCrCulName(String crCulName) {
        this.crCulName = crCulName;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
