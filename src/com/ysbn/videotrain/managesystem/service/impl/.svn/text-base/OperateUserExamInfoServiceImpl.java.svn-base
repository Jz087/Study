package com.ysbn.videotrain.managesystem.service.impl;

import java.util.List;

import com.ysbn.videotrain.managesystem.dao.IOperateUserExamInfoDao;
import com.ysbn.videotrain.managesystem.service.IOperateUserExamInfoService;
import com.ysbn.videotrain.managesystem.vo.DepartVo;
import com.ysbn.videotrain.managesystem.vo.ExamRecordVo;
import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserCulVo;
import com.ysbn.videotrain.managesystem.vo.UserDepartVo;
import com.ysbn.videotrain.managesystem.vo.UserExamInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserRecordVo;
import com.ysbn.videotrain.managesystem.vo.VideoRecordVo;

public class OperateUserExamInfoServiceImpl implements IOperateUserExamInfoService {
    private IOperateUserExamInfoDao operateUserExamInfoDao;

    public IOperateUserExamInfoDao getOperateUserExamInfoDao() {
        return operateUserExamInfoDao;
    }

    public void setOperateUserExamInfoDao(IOperateUserExamInfoDao operateUserExamInfoDao) {
        this.operateUserExamInfoDao = operateUserExamInfoDao;
    }

    @Override
    public List<UserExamInfoVo> queryUserExamInfo(String userName, String smartCardNO)
                                                                                      throws Exception {
        return operateUserExamInfoDao.queryUserExamInfo(userName, smartCardNO);
    }

    @Override
    public List<UserExamInfoVo> queryUserExamInfoByName(String userName) throws Exception {
        return operateUserExamInfoDao.queryUserExamInfoByName(userName);
    }

    @Override
    public List<UserExamInfoVo> queryUserExamInfoBySmartCardNO(String smartCardNO) throws Exception {
        return operateUserExamInfoDao.queryUserExamInfoBySmartCardNO(smartCardNO);
    }

    @Override
    public List<VideoRecordVo> queryVideoRecord(int viagenID) throws Exception {
        return operateUserExamInfoDao.queryVideoRecord(viagenID);
    }

    @Override
    public List<UserCulVo> queryCulByCulName(String culName) throws Exception {
        return operateUserExamInfoDao.queryCulByCulName(culName);
    }

    @Override
    public List<ExamRecordVo> queryExamRecord(int reID, int epID) throws Exception {
        return operateUserExamInfoDao.queryExamRecord(reID, epID);
    }

    @Override
    public List<UserRecordVo> queryUserrecordByCulName(String culName) throws Exception {
        return operateUserExamInfoDao.queryUserrecordByCulName(culName);
    }

    @Override
    public List<UserRecordVo> queryUserrecordByDepartname(String departName) throws Exception {
        return operateUserExamInfoDao.queryUserrecordByDepartname(departName);
    }

    @Override
    public List<UserRecordVo> queryUserrecordByUserName(String userName) throws Exception {
        return operateUserExamInfoDao.queryUserrecordByUserName(userName);
    }

    @Override
    public List<UserRecordVo> queryUserrecordBysmartCardNO(String smartCardNO) throws Exception {
        return operateUserExamInfoDao.queryUserrecordBysmartCardNO(smartCardNO);
    }

    @Override
    public List<UserDepartVo> queryUD(String smartCardNO) throws Exception {
        return operateUserExamInfoDao.queryUD(smartCardNO);
    }

    @Override
    public List<VideoRecordVo> queryViRecord(String smartCardNO, int videoID) throws Exception {
        return operateUserExamInfoDao.queryViRecord(smartCardNO, videoID);
    }

    @Override
    public List<DepartVo> queryDepartByCompany(String companyName) throws Exception {
        return operateUserExamInfoDao.queryDepartByCompany(companyName);
    }

    @Override
    public List<DepartVo> queryOfficeByDepart(String departName) throws Exception {
        return operateUserExamInfoDao.queryOfficeByDepart(departName);
    }

    @Override
    public List<UserExamInfoVo> queryUserExamInfoByDepart(String departCode) throws Exception {
        return operateUserExamInfoDao.queryUserExamInfoByDepart(departCode);
    }

    @Override
    public List<UserExamInfoVo> queryUserExamInfoByDepartAndOffice(String departCode, String OfficeCode) throws Exception {
        return operateUserExamInfoDao.queryUserExamInfoByDepartAndOffice(departCode, OfficeCode);
    }

    @Override
    public List<UserExamInfoVo> queryUserExamInfoByJob(String job) throws Exception {
        return operateUserExamInfoDao.queryUserExamInfoByJob(job);
    }

    @Override
    public List<UserRecordVo> queryUserrecordByDepart(String departCode) throws Exception {
        return operateUserExamInfoDao.queryUserrecordByDepart(departCode);
    }

    @Override
    public List<UserRecordVo> queryUserrecordByDepartAndOffice(String departCode, String OfficeCode) throws Exception {
        return operateUserExamInfoDao.queryUserrecordByDepartAndOffice(departCode, OfficeCode);
    }

    @Override
    public List<UserRecordVo> queryUserrecordByJob(String job) throws Exception {
        return operateUserExamInfoDao.queryUserrecordByJob(job);
    }

    @Override
    public List<QuestionInfoVo> queryQuestionInfoVo(int qID) throws Exception {
        return operateUserExamInfoDao.queryQuestionInfoVo(qID);
    }

}
