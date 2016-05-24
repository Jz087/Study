package com.ysbn.videotrain.managesystem.service;

import java.util.List;

import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;

public interface OperateVideoInfoService {
    public List<VideoInfoVo> queryVideoInfo() throws Exception;

    public List<VideoInfoVo> queryVideoInfoByName(String videoName) throws Exception;

    public List<VideoInfoVo> queryVideoInfoByID(int videoID) throws Exception;

    public int insert(VideoInfoVo videoVo) throws Exception;

    public int delete(int videoID) throws Exception;

    public int update(VideoInfoVo videoVo) throws Exception;
}
