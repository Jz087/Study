package com.ysbn.videotrain.managesystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ysbn.videotrain.managesystem.dao.OperateVideoInfoDao;
import com.ysbn.videotrain.managesystem.vo.VideoInfoVo;

public class OperateVideoInfoDaoImpl implements OperateVideoInfoDao {
    private PersistDao persistDao;

    public PersistDao getPersistDao() {
        return persistDao;
    }

    public void setPersistDao(PersistDao persistDao) {
        this.persistDao = persistDao;
    }

    @Override
    public int delete(int videoID) throws Exception {
        String sql = "DELETE FROM DVIDEOINFO WHERE VI_AGENCYID=?";
        Object[] args = new Object[] { videoID };
        return persistDao.delete(sql, args);
    }

    @Override
    public int insert(VideoInfoVo videoVo) throws Exception {
        String sql = "INSERT INTO DVIDEOINFO (VI_AGENCYID, VI_NAME, VI_TOTALTIME, VI_CREATETIME, VI_PUBLISHFLAG, VI_PASSMASK, VI_CREDIT) VALUES (VI_ID.NEXTVAL,?,?,TO_CHAR(SYSDATE, 'YYYY-MM-DD'),?,?,?)";
        Object[] args = new Object[] { videoVo.getVideoName(), videoVo.getVideoTotalTime(),
                videoVo.getVideoPublishFlag(), videoVo.getVideoPassMask(), videoVo.getVideoCredit() };
        return persistDao.insert(sql, args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VideoInfoVo> queryVideoInfo() throws Exception {
        String sql = "SELECT VI_AGENCYID, VI_NAME, VI_TOTALTIME, VI_CREATETIME, VI_PUBLISHFLAG, VI_PASSMASK, VI_CREDIT FROM DVIDEOINFO ORDER BY VI_AGENCYID DESC";
        Object[] args = new Object[] {};
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                VideoInfoVo videoVo = new VideoInfoVo();
                try {
                    videoVo.setVideoID(Integer.parseInt(rs.getString(1)));
                    videoVo.setVideoName(rs.getString(2));
                    videoVo.setVideoTotalTime(Integer.parseInt(rs.getString(3)));
                    videoVo.setVideoCreateTime(rs.getString(4));
                    videoVo.setVideoPublishFlag(rs.getString(5));
                    videoVo.setVideoPassMask(Integer.parseInt(rs.getString(6)));
                    videoVo.setVideoCredit(Integer.parseInt(rs.getString(7)));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return videoVo;
            }
        };
        List<VideoInfoVo> videoInfoVoList = persistDao.selectListBySQL(sql, null, rowMapper1);
        return videoInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VideoInfoVo> queryVideoInfoByName(String videoName) throws Exception {
        String sql = "SELECT VI_AGENCYID, VI_NAME, VI_TOTALTIME, VI_CREATETIME, VI_PUBLISHFLAG, VI_PASSMASK, VI_CREDIT FROM DVIDEOINFO WHERE VI_NAME LIKE '%"
                     + videoName + "%' ORDER BY VI_AGENCYID";
        Object[] args = new Object[] {};
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                VideoInfoVo videoVo = new VideoInfoVo();
                try {
                    videoVo.setVideoID(Integer.parseInt(rs.getString(1)));
                    videoVo.setVideoName(rs.getString(2));
                    videoVo.setVideoTotalTime(Integer.parseInt(rs.getString(3)));
                    videoVo.setVideoCreateTime(rs.getString(4));
                    videoVo.setVideoPublishFlag(rs.getString(5));
                    videoVo.setVideoPassMask(Integer.parseInt(rs.getString(6)));
                    videoVo.setVideoCredit(Integer.parseInt(rs.getString(7)));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return videoVo;
            }
        };
        List<VideoInfoVo> videoInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return videoInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VideoInfoVo> queryVideoInfoByID(int videoID) throws Exception {
        String sql = "SELECT VI_AGENCYID, VI_NAME, VI_TOTALTIME, VI_CREATETIME, VI_PUBLISHFLAG, VI_PASSMASK, VI_CREDIT FROM DVIDEOINFO WHERE VI_AGENCYID=?";
        Object[] args = new Object[] { videoID };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                VideoInfoVo videoVo = new VideoInfoVo();
                try {
                    videoVo.setVideoID(Integer.parseInt(rs.getString(1)));
                    videoVo.setVideoName(rs.getString(2));
                    videoVo.setVideoTotalTime(Integer.parseInt(rs.getString(3)));
                    videoVo.setVideoCreateTime(rs.getString(4));
                    videoVo.setVideoPublishFlag(rs.getString(5));
                    videoVo.setVideoPassMask(Integer.parseInt(rs.getString(6)));
                    videoVo.setVideoCredit(Integer.parseInt(rs.getString(7)));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return videoVo;
            }
        };
        List<VideoInfoVo> videoInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return videoInfoVoList;
    }

    @Override
    public int update(VideoInfoVo videoVo) throws Exception {
        String sql = "UPDATE DVIDEOINFO SET VI_NAME=?, VI_TOTALTIME=?, VI_PUBLISHFLAG=?, VI_PASSMASK=?, VI_CREDIT=? WHERE VI_AGENCYID=?";
        Object[] args = new Object[] { videoVo.getVideoName(), videoVo.getVideoTotalTime(),
                videoVo.getVideoPublishFlag(), videoVo.getVideoPassMask(),
                videoVo.getVideoCredit(), videoVo.getVideoID() };
        return persistDao.update(sql, args);
    }

}
