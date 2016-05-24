package com.ysbn.videotrain.managesystem.vo;

public class UserRecordVo {
    private String userName;
    private String smartCardNO;
    private String departName;
    private String culName;
    private int    score;
    private String videoName;
    private int    erAgencyID;
    private int    videoID;
    private int    epAgencyID;

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

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getCulName() {
        return culName;
    }

    public void setCulName(String culName) {
        this.culName = culName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getErAgencyID() {
        return erAgencyID;
    }

    public void setErAgencyID(int erAgencyID) {
        this.erAgencyID = erAgencyID;
    }

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public int getEpAgencyID() {
        return epAgencyID;
    }

    public void setEpAgencyID(int epAgencyID) {
        this.epAgencyID = epAgencyID;
    }
}
