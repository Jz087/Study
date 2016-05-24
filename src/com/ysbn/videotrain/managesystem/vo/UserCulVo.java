package com.ysbn.videotrain.managesystem.vo;

public class UserCulVo {
    private int    culID;
    private String culName;
    private String studyTime;
    private String studyEnd;
    private String createTime;
    private String describe;

    public int getCulID() {
        return culID;
    }

    public void setCulID(int culID) {
        this.culID = culID;
    }

    public String getCulName() {
        return culName;
    }

    public void setCulName(String culName) {
        this.culName = culName;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getStudyEnd() {
        return studyEnd;
    }

    public void setStudyEnd(String studyEnd) {
        this.studyEnd = studyEnd;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
