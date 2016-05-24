package com.ysbn.videotrain.managesystem.dao;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.DepartVo;
import com.ysbn.videotrain.managesystem.vo.ExamRecordVo;
import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserCulVo;
import com.ysbn.videotrain.managesystem.vo.UserDepartVo;
import com.ysbn.videotrain.managesystem.vo.UserExamInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserRecordVo;
import com.ysbn.videotrain.managesystem.vo.VideoRecordVo;

public interface IOperateUserExamInfoDao {
    public List<UserExamInfoVo> queryUserExamInfoByName(String userName) throws Exception;

    public List<UserExamInfoVo> queryUserExamInfoBySmartCardNO(String smartCardNO) throws Exception;

    public List<UserExamInfoVo> queryUserExamInfo(String userName, String smartCardNO) throws Exception;
    
    public List<UserExamInfoVo> queryUserExamInfoByDepart(String departCode) throws Exception;
    
    public List<UserExamInfoVo> queryUserExamInfoByDepartAndOffice(String departCode, String OfficeCode) throws Exception;
    
    public List<UserExamInfoVo> queryUserExamInfoByJob(String job) throws Exception;

    public List<VideoRecordVo> queryVideoRecord(int viagenID) throws Exception;

    public List<UserRecordVo> queryUserrecordByUserName(String userName) throws Exception;

    public List<UserRecordVo> queryUserrecordBysmartCardNO(String smartCardNO) throws Exception;

    public List<UserRecordVo> queryUserrecordByDepartname(String departName) throws Exception;

    public List<UserRecordVo> queryUserrecordByCulName(String culName) throws Exception;
    
    public List<UserRecordVo> queryUserrecordByDepart(String departCode) throws Exception;
    
    public List<UserRecordVo> queryUserrecordByDepartAndOffice(String departCode, String OfficeCode) throws Exception;
    
    public List<UserRecordVo> queryUserrecordByJob(String job) throws Exception;

    public List<UserCulVo> queryCulByCulName(String culName) throws Exception;

    public List<ExamRecordVo> queryExamRecord(int reID, int epID) throws Exception;

    public List<UserDepartVo> queryUD(String smartCardNO) throws Exception;

    public List<VideoRecordVo> queryViRecord(String smartCardNO, int videoID) throws Exception;
    
    public List<DepartVo> queryDepartByCompany(String companyName) throws Exception;
    
    public List<DepartVo> queryOfficeByDepart(String departName) throws Exception;
    
    public List<QuestionInfoVo> queryQuestionInfoVo(int qID) throws Exception;
}
