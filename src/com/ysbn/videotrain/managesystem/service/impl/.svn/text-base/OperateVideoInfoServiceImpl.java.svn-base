package com.ysbn.videotrain.managesystem.service.impl;

import java.util.List;

import com.ysbn.videotrain.managesystem.dao.OperateVideoInfoDao;
import com.ysbn.videotrain.managesystem.service.OperateVideoInfoService;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;

public class OperateVideoInfoServiceImpl implements OperateVideoInfoService {
    private OperateVideoInfoDao operateVideoInfoDao;

    public OperateVideoInfoDao getOperateVideoInfoDao() {
        return operateVideoInfoDao;
    }

    public void setOperateVideoInfoDao(OperateVideoInfoDao operateVideoInfoDao) {
        this.operateVideoInfoDao = operateVideoInfoDao;
    }

    @Override
    public int delete(int videoID) throws Exception {
        return operateVideoInfoDao.delete(videoID);
    }

    @Override
    public int insert(VideoInfoVo videoVo) throws Exception {
        return operateVideoInfoDao.insert(videoVo);
    }

    @Override
    public List<VideoInfoVo> queryVideoInfo() throws Exception {
        return operateVideoInfoDao.queryVideoInfo();
    }

    @Override
    public List<VideoInfoVo> queryVideoInfoByID(int videoID) throws Exception {
        return operateVideoInfoDao.queryVideoInfoByID(videoID);
    }

    @Override
    public List<VideoInfoVo> queryVideoInfoByName(String videoName) throws Exception {
        return operateVideoInfoDao.queryVideoInfoByName(videoName);
    }

    @Override
    public int update(VideoInfoVo videoVo) throws Exception {
        return operateVideoInfoDao.update(videoVo);
    }

}
