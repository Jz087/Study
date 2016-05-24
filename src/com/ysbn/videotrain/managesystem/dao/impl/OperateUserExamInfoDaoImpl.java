package com.ysbn.videotrain.managesystem.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ysbn.videotrain.managesystem.dao.IOperateUserExamInfoDao;
import com.ysbn.videotrain.managesystem.vo.DepartVo;
import com.ysbn.videotrain.managesystem.vo.ExamRecordVo;
import com.ysbn.videotrain.managesystem.vo.QuestionInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserCulVo;
import com.ysbn.videotrain.managesystem.vo.UserDepartVo;
import com.ysbn.videotrain.managesystem.vo.UserExamInfoVo;
import com.ysbn.videotrain.managesystem.vo.UserRecordVo;
import com.ysbn.videotrain.managesystem.vo.VideoRecordVo;

public class OperateUserExamInfoDaoImpl implements IOperateUserExamInfoDao {
    private PersistDao persistDao;

    public PersistDao getPersistDao() {
        return persistDao;
    }

    public void setPersistDao(PersistDao persistDao) {
        this.persistDao = persistDao;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserExamInfoVo> queryUserExamInfo(String userName, String smartCardNO) throws Exception {
        String sql = "SELECT E.ER_AGENCYID, U.UM_ICID, U.UM_USERNAME, D.DC_DEPARNAME, E.ER_VIAGENID, E.ER_EPAGENID, E.ER_SCORE, E.ER_ANSWER, E.ER_CREDIT, E.ER_EXAMTIME FROM DUSERMSG U, SDEPARCONFIG D, DEXAMRECORD E WHERE U.UM_ICID=? AND U.UM_USERNAME=? AND U.UM_DEPARCODE=D.DC_DEPARCODE AND U.UM_ICID=E.ER_ICID ORDER BY E.ER_AGENCYID";
        Object[] args = new Object[] { smartCardNO, userName };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserExamInfoVo vo = new UserExamInfoVo();
                try {
                    vo.setAgencyid(Integer.parseInt(rs.getString(1)));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setUserName(rs.getString(3));
                    vo.setDepartname(rs.getString(4));
                    vo.setViagenID(Integer.parseInt(rs.getString(5)));
                    vo.setEpagenID(Integer.parseInt(rs.getString(6)));
                    vo.setScore(Integer.parseInt(rs.getString(7)));
                    vo.setAnswer(rs.getString(8));
                    vo.setCredit(Integer.parseInt(rs.getString(9)));
                    vo.setExamTime(rs.getString(10));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserExamInfoVo> UserExamInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return UserExamInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserExamInfoVo> queryUserExamInfoByName(String userName) throws Exception {
        String sql = "SELECT E.ER_AGENCYID, U.UM_ICID, U.UM_USERNAME, D.DC_DEPARNAME, E.ER_VIAGENID, E.ER_EPAGENID, E.ER_SCORE, E.ER_ANSWER, E.ER_CREDIT, E.ER_EXAMTIME FROM DUSERMSG U, SDEPARCONFIG D, DEXAMRECORD E WHERE U.UM_USERNAME=? AND U.UM_DEPARCODE=D.DC_DEPARCODE AND U.UM_ICID=E.ER_ICID ORDER BY E.ER_AGENCYID";
        Object[] args = new Object[] { userName };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserExamInfoVo vo = new UserExamInfoVo();
                try {
                    vo.setAgencyid(Integer.parseInt(rs.getString(1)));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setUserName(rs.getString(3));
                    vo.setDepartname(rs.getString(4));
                    vo.setViagenID(Integer.parseInt(rs.getString(5)));
                    vo.setEpagenID(Integer.parseInt(rs.getString(6)));
                    vo.setScore(Integer.parseInt(rs.getString(7)));
                    vo.setAnswer(rs.getString(8));
                    vo.setCredit(Integer.parseInt(rs.getString(9)));
                    vo.setExamTime(rs.getString(10));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserExamInfoVo> UserExamInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return UserExamInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserExamInfoVo> queryUserExamInfoBySmartCardNO(String smartCardNO) throws Exception {
        String sql = "SELECT E.ER_AGENCYID, U.UM_ICID, U.UM_USERNAME, D.DC_DEPARNAME, E.ER_VIAGENID, E.ER_EPAGENID, E.ER_SCORE, E.ER_ANSWER, E.ER_CREDIT, E.ER_EXAMTIME FROM DUSERMSG U, SDEPARCONFIG D, DEXAMRECORD E WHERE U.UM_ICID=? AND U.UM_DEPARCODE=D.DC_DEPARCODE AND U.UM_ICID=E.ER_ICID ORDER BY E.ER_AGENCYID";
        Object[] args = new Object[] { smartCardNO };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserExamInfoVo vo = new UserExamInfoVo();
                try {
                    vo.setAgencyid(Integer.parseInt(rs.getString(1)));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setUserName(rs.getString(3));
                    vo.setDepartname(rs.getString(4));
                    vo.setViagenID(Integer.parseInt(rs.getString(5)));
                    vo.setEpagenID(Integer.parseInt(rs.getString(6)));
                    vo.setScore(Integer.parseInt(rs.getString(7)));
                    vo.setAnswer(rs.getString(8));
                    vo.setCredit(Integer.parseInt(rs.getString(9)));
                    vo.setExamTime(rs.getString(10));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserExamInfoVo> UserExamInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return UserExamInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VideoRecordVo> queryVideoRecord(int viagenID) throws Exception {
        String sql = "SELECT VR_AGENCYID, VR_ICID, VR_CRAGENID, VR_CRCULID, VR_VIAGENID, VR_PROGRESS, VR_EXAMFLAG, VR_STUDYTIME FROM DVIDEORECORD WHERE VR_VIAGENID=?";
        Object[] args = new Object[] { viagenID };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                VideoRecordVo vo = new VideoRecordVo();
                try {
                    vo.setAgencyID(Integer.parseInt(rs.getString(1)));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setCragenID(Integer.parseInt(rs.getString(3)));
                    vo.setCrculID(Integer.parseInt(rs.getString(4)));
                    vo.setViagenID((Integer.parseInt(rs.getString(5))));
                    vo.setProgress(Integer.parseInt(rs.getString(6)));
                    vo.setExamFlag(rs.getString(7));
                    vo.setStudyTime(rs.getString(8));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<VideoRecordVo> VideoRecordVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return VideoRecordVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserCulVo> queryCulByCulName(String culName) throws Exception {
        String sql = "SELECT CR_CULID, CR_CULNAME, CR_STUDYSTART, CR_STUDYEND, CR_CREATETIME, CR_DESCRIBE FROM DCULRECORD WHERE CR_CULNAME=?";
        Object[] args = new Object[] { culName };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserCulVo vo = new UserCulVo();
                try {
                    vo.setCulID(Integer.parseInt(rs.getString(1)));
                    vo.setCulName(rs.getString(2));
                    vo.setStudyTime(rs.getString(3));
                    vo.setStudyEnd(rs.getString(4));
                    vo.setCreateTime(rs.getString(5));
                    vo.setDescribe(rs.getString(6));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserCulVo> cuList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return cuList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExamRecordVo> queryExamRecord(int reID, int epID) throws Exception {
        String sql = "SELECT ER.ER_ICID, EP.EP_NAME, ER.ER_SCORE, ER.ER_ANSWER, ER.ER_CREDIT, ER.ER_EXAMTIME, EP.EP_QIAGENID FROM DEXAMRECORD ER, DEXAMPAPER EP WHERE ER.ER_AGENCYID=? AND EP.EP_AGENCYID=?";
        Object[] args = new Object[] { reID, epID };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                ExamRecordVo vo = new ExamRecordVo();
                try {
                    vo.setSmartCardNO(rs.getString(1));
                    vo.setEpName(rs.getString(2));
                    vo.setScore(Integer.parseInt(rs.getString(3)));
                    vo.setAnswer(rs.getString(4));
                    vo.setCredit(Integer.parseInt(rs.getString(5)));
                    vo.setExamTime(rs.getString(6));
                    vo.setQiAgenID(rs.getString(7));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<ExamRecordVo> examRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return examRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRecordVo> queryUserrecordByCulName(String culName) throws Exception {
        String sql = "SELECT DUM.UM_USERNAME, DUM.UM_ICID, SDC.DC_DEPARNAME, DCR.CR_CULNAME, DER.ER_SCORE,DVI.VI_NAME,DER.ER_AGENCYID,DER.ER_VIAGENID,DER.ER_EPAGENID FROM DUSERMSG DUM, SDEPARCONFIG SDC, DUSERCUL DUC, DCULRECORD DCR, DEXAMRECORD DER, SCULVIDEORELAT SCVR, DVIDEOINFO DVI, DVIDEORECORD DVR WHERE DCR.CR_CULNAME=? AND SDC.DC_DEPARCODE=DUM.UM_DEPARCODE AND DUM.UM_ICID=DUC.EC_ICID AND DUC.EC_CRAGENID = DCR.CR_AGENCYID AND DVR.VR_ICID = DUC.EC_ICID AND DER.ER_ICID=DUC.EC_ICID AND SCVR.CVR_CRAGENID = DCR.CR_AGENCYID AND (TO_CHAR(DVI.VI_AGENCYID) IN SCVR.CVR_SETVIAGENID) AND DVR.VR_VIAGENID = DVI.VI_AGENCYID ORDER BY DCR.CR_CULNAME";
        Object[] args = new Object[] { culName };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserRecordVo vo = new UserRecordVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setDepartName(rs.getString(3));
                    vo.setCulName(rs.getString(4));
                    vo.setScore((Integer.parseInt(rs.getString(5))));
                    vo.setVideoName(rs.getString(6));
                    vo.setErAgencyID((Integer.parseInt(rs.getString(7))));
                    vo.setVideoID((Integer.parseInt(rs.getString(8))));
                    vo.setEpAgencyID((Integer.parseInt(rs.getString(9))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserRecordVo> userRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return userRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRecordVo> queryUserrecordByDepartname(String departName) throws Exception {
        String sql = "SELECT DUM.UM_USERNAME, DUM.UM_ICID, SDC.DC_DEPARNAME, DCR.CR_CULNAME, DER.ER_SCORE,DVI.VI_NAME,DER.ER_AGENCYID,DER.ER_VIAGENID,DER.ER_EPAGENID FROM DUSERMSG DUM, SDEPARCONFIG SDC, DUSERCUL DUC, DCULRECORD DCR, DEXAMRECORD DER, SCULVIDEORELAT SCVR, DVIDEOINFO DVI, DVIDEORECORD DVR WHERE SDC.DC_DEPARNAME=? AND SDC.DC_DEPARCODE = DUM.UM_DEPARCODE AND DUM.UM_ICID = DUC.EC_ICID AND DVR.VR_ICID = DUC.EC_ICID AND DUC.EC_CRAGENID = DCR.CR_AGENCYID AND DER.ER_ICID = DUC.EC_ICID AND SCVR.CVR_CRAGENID = DCR.CR_AGENCYID AND (TO_CHAR(DVI.VI_AGENCYID) IN SCVR.CVR_SETVIAGENID) AND DVR.VR_VIAGENID = DVI.VI_AGENCYID ORDER BY DCR.CR_CULNAME";
        Object[] args = new Object[] { departName };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserRecordVo vo = new UserRecordVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setDepartName(rs.getString(3));
                    vo.setCulName(rs.getString(4));
                    vo.setScore((Integer.parseInt(rs.getString(5))));
                    vo.setVideoName(rs.getString(6));
                    vo.setErAgencyID((Integer.parseInt(rs.getString(7))));
                    vo.setVideoID((Integer.parseInt(rs.getString(8))));
                    vo.setEpAgencyID((Integer.parseInt(rs.getString(9))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserRecordVo> userRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return userRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRecordVo> queryUserrecordByUserName(String userName) throws Exception {
        String sql = "SELECT DUM.UM_USERNAME, DUM.UM_ICID, SDC.DC_DEPARNAME, DCR.CR_CULNAME, DER.ER_SCORE,DVI.VI_NAME,DER.ER_AGENCYID,DER.ER_VIAGENID,DER.ER_EPAGENID FROM DUSERMSG DUM, SDEPARCONFIG SDC, DUSERCUL DUC, DCULRECORD DCR, DEXAMRECORD DER, SCULVIDEORELAT SCVR, DVIDEOINFO DVI, DVIDEORECORD DVR WHERE DUM.UM_USERNAME =? AND SDC.DC_DEPARCODE = DUM.UM_DEPARCODE AND DUM.UM_ICID = DUC.EC_ICID AND DVR.VR_ICID = DUC.EC_ICID AND DUC.EC_CRAGENID = DCR.CR_AGENCYID AND DER.ER_ICID = DUC.EC_ICID AND SCVR.CVR_CRAGENID = DCR.CR_AGENCYID AND (TO_CHAR(DVI.VI_AGENCYID) IN SCVR.CVR_SETVIAGENID) AND DVR.VR_VIAGENID = DVI.VI_AGENCYID ORDER BY DCR.CR_CULNAME";
        Object[] args = new Object[] { userName };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserRecordVo vo = new UserRecordVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setDepartName(rs.getString(3));
                    vo.setCulName(rs.getString(4));
                    vo.setScore((Integer.parseInt(rs.getString(5))));
                    vo.setVideoName(rs.getString(6));
                    vo.setErAgencyID((Integer.parseInt(rs.getString(7))));
                    vo.setVideoID((Integer.parseInt(rs.getString(8))));
                    vo.setEpAgencyID((Integer.parseInt(rs.getString(9))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserRecordVo> userRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return userRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRecordVo> queryUserrecordBysmartCardNO(String smartCardNO) throws Exception {
        String sql = "SELECT DUM.UM_USERNAME, DUM.UM_ICID, SDC.DC_DEPARNAME, DCR.CR_CULNAME, DER.ER_SCORE,DVI.VI_NAME,DER.ER_AGENCYID,DER.ER_VIAGENID,DER.ER_EPAGENID FROM DUSERMSG DUM, SDEPARCONFIG SDC, DUSERCUL DUC, DCULRECORD DCR, DEXAMRECORD DER, SCULVIDEORELAT SCVR, DVIDEOINFO DVI, DVIDEORECORD DVR WHERE DUM.UM_ICID=? AND SDC.DC_DEPARCODE = DUM.UM_DEPARCODE AND DUM.UM_ICID = DUC.EC_ICID AND DVR.VR_ICID = DUC.EC_ICID AND DUC.EC_CRAGENID = DCR.CR_AGENCYID AND DER.ER_ICID = DUC.EC_ICID AND SCVR.CVR_CRAGENID = DCR.CR_AGENCYID AND (TO_CHAR(DVI.VI_AGENCYID) IN SCVR.CVR_SETVIAGENID) AND DVR.VR_VIAGENID = DVI.VI_AGENCYID ORDER BY DCR.CR_CULNAME";
        Object[] args = new Object[] { smartCardNO };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserRecordVo vo = new UserRecordVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setDepartName(rs.getString(3));
                    vo.setCulName(rs.getString(4));
                    vo.setScore((Integer.parseInt(rs.getString(5))));
                    vo.setVideoName(rs.getString(6));
                    vo.setErAgencyID((Integer.parseInt(rs.getString(7))));
                    vo.setVideoID((Integer.parseInt(rs.getString(8))));
                    vo.setEpAgencyID((Integer.parseInt(rs.getString(9))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserRecordVo> userRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return userRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDepartVo> queryUD(String smartCardNO) throws Exception {
        String sql = "SELECT U.UM_USERNAME, U.UM_ICID, U.UM_SEX, U.UM_POSITION, U.UM_BIRTHDAY, U.UM_PHONE, U.UM_EMAIL, U.UM_POLSTATUS, D.DC_DEPARNAME, D.DC_LEVEL, D.DC_BELONG, D.DC_USEFLAG, D.DC_DESCRIBE FROM DUSERMSG U, SDEPARCONFIG D WHERE U.UM_ICID=? AND U.UM_DEPARCODE=D.DC_DEPARCODE";
        Object[] args = new Object[] { smartCardNO };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserDepartVo vo = new UserDepartVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setSex(rs.getString(3));
                    vo.setPosition(rs.getString(4));
                    vo.setBirthday(rs.getString(5));
                    vo.setPhone(rs.getString(6));
                    vo.setEmail(rs.getString(7));
                    vo.setPolstatus(rs.getString(8));
                    vo.setDepartName(rs.getString(9));
                    vo.setLevel(rs.getString(10));
                    vo.setBelong(rs.getString(11));
                    vo.setUseFlag(rs.getString(12));
                    vo.setDescribe(rs.getString(13));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserDepartVo> udList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return udList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VideoRecordVo> queryViRecord(String smartCardNO, int videoID) throws Exception {
        String sql = "SELECT VR_ICID, VR_PROGRESS, VR_EXAMFLAG, VR_STUDYTIME FROM DVIDEORECORD WHERE VR_ICID=? AND VR_VIAGENID=?";
        Object[] args = new Object[] { smartCardNO, videoID };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                VideoRecordVo vo = new VideoRecordVo();
                try {
                    vo.setSmartCardNO(rs.getString(1));
                    vo.setProgress(Integer.parseInt(rs.getString(2)));
                    vo.setExamFlag(rs.getString(3));
                    vo.setStudyTime(rs.getString(4));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<VideoRecordVo> videoRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return videoRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DepartVo> queryDepartByCompany(String companyName) throws Exception {
        String sql = "";
//        Object[] args = new Object[] { };
        if(companyName.equals("1")){
            sql = "SELECT DC_AGENCYID, DC_DEPARCODE, DC_LEVEL, DC_BELONG, DC_DEPARNAME, DC_USEFLAG, DC_DESCRIBE FROM SDEPARCONFIG WHERE DC_DEPARCODE LIKE '1__00' ORDER BY DC_AGENCYID";
        }else{
            sql = "SELECT DC_AGENCYID, DC_DEPARCODE, DC_LEVEL, DC_BELONG, DC_DEPARNAME, DC_USEFLAG, DC_DESCRIBE FROM SDEPARCONFIG WHERE DC_DEPARCODE LIKE '2__00' ORDER BY DC_AGENCYID";
        }
        
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                DepartVo vo = new DepartVo();
                try {
                    vo.setId(Integer.parseInt(rs.getString(1)));
                    vo.setDepartCode(rs.getString(2));
                    vo.setLevel(rs.getString(3));
                    vo.setBelong(rs.getString(4));
                    vo.setDepartName(rs.getString(5));
                    vo.setUseFlag(rs.getString(6));
                    vo.setDescribe(rs.getString(7));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<DepartVo> departList = persistDao.selectListBySQL(sql, null, rowMapper1);
        return departList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DepartVo> queryOfficeByDepart(String departName) throws Exception {
        String departCode = departName + "__";
        String sql = "SELECT DC_AGENCYID, DC_DEPARCODE, DC_LEVEL, DC_BELONG, DC_DEPARNAME, DC_USEFLAG, DC_DESCRIBE FROM SDEPARCONFIG WHERE DC_LEVEL='3' AND DC_DEPARCODE LIKE '"+departCode+"'";
        
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                DepartVo vo = new DepartVo();
                try {
                    vo.setId(Integer.parseInt(rs.getString(1)));
                    vo.setDepartCode(rs.getString(2));
                    vo.setLevel(rs.getString(3));
                    vo.setBelong(rs.getString(4));
                    vo.setDepartName(rs.getString(5));
                    vo.setUseFlag(rs.getString(6));
                    vo.setDescribe(rs.getString(7));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<DepartVo> departList = persistDao.selectListBySQL(sql, null, rowMapper1);
        return departList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserExamInfoVo> queryUserExamInfoByDepart(String departCode) throws Exception {
        String departAll = departCode.substring(0, 3)+"%";
        String sql = "SELECT E.ER_AGENCYID, U.UM_ICID, U.UM_USERNAME, D.DC_DEPARNAME, E.ER_VIAGENID, E.ER_EPAGENID, E.ER_SCORE, E.ER_ANSWER, E.ER_CREDIT, E.ER_EXAMTIME FROM DUSERMSG U, SDEPARCONFIG D, DEXAMRECORD E WHERE D.DC_DEPARCODE like '"+departAll+"' AND U.UM_DEPARCODE=D.DC_DEPARCODE AND U.UM_ICID=E.ER_ICID ORDER BY E.ER_AGENCYID";
        Object[] args = new Object[] {  };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserExamInfoVo vo = new UserExamInfoVo();
                try {
                    vo.setAgencyid(Integer.parseInt(rs.getString(1)));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setUserName(rs.getString(3));
                    vo.setDepartname(rs.getString(4));
                    vo.setViagenID(Integer.parseInt(rs.getString(5)));
                    vo.setEpagenID(Integer.parseInt(rs.getString(6)));
                    vo.setScore(Integer.parseInt(rs.getString(7)));
                    vo.setAnswer(rs.getString(8));
                    vo.setCredit(Integer.parseInt(rs.getString(9)));
                    vo.setExamTime(rs.getString(10));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserExamInfoVo> UserExamInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return UserExamInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserExamInfoVo> queryUserExamInfoByDepartAndOffice(String departCode, String OfficeCode) throws Exception {
        String sql = "SELECT E.ER_AGENCYID, U.UM_ICID, U.UM_USERNAME, D.DC_DEPARNAME, E.ER_VIAGENID, E.ER_EPAGENID, E.ER_SCORE, E.ER_ANSWER, E.ER_CREDIT, E.ER_EXAMTIME FROM DUSERMSG U, SDEPARCONFIG D, DEXAMRECORD E WHERE D.DC_DEPARCODE=? AND U.UM_DEPARCODE=D.DC_DEPARCODE AND U.UM_ICID=E.ER_ICID ORDER BY E.ER_AGENCYID";
        Object[] args = new Object[] { OfficeCode };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserExamInfoVo vo = new UserExamInfoVo();
                try {
                    vo.setAgencyid(Integer.parseInt(rs.getString(1)));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setUserName(rs.getString(3));
                    vo.setDepartname(rs.getString(4));
                    vo.setViagenID(Integer.parseInt(rs.getString(5)));
                    vo.setEpagenID(Integer.parseInt(rs.getString(6)));
                    vo.setScore(Integer.parseInt(rs.getString(7)));
                    vo.setAnswer(rs.getString(8));
                    vo.setCredit(Integer.parseInt(rs.getString(9)));
                    vo.setExamTime(rs.getString(10));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserExamInfoVo> UserExamInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return UserExamInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserExamInfoVo> queryUserExamInfoByJob(String job) throws Exception {
        String sql = "SELECT E.ER_AGENCYID, U.UM_ICID, U.UM_USERNAME, D.DC_DEPARNAME, E.ER_VIAGENID, E.ER_EPAGENID, E.ER_SCORE, E.ER_ANSWER, E.ER_CREDIT, E.ER_EXAMTIME FROM DUSERMSG U, SDEPARCONFIG D, DEXAMRECORD E WHERE U.UM_POSITION=? AND U.UM_DEPARCODE=D.DC_DEPARCODE AND U.UM_ICID=E.ER_ICID ORDER BY E.ER_AGENCYID";
        Object[] args = new Object[] { job };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserExamInfoVo vo = new UserExamInfoVo();
                try {
                    vo.setAgencyid(Integer.parseInt(rs.getString(1)));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setUserName(rs.getString(3));
                    vo.setDepartname(rs.getString(4));
                    vo.setViagenID(Integer.parseInt(rs.getString(5)));
                    vo.setEpagenID(Integer.parseInt(rs.getString(6)));
                    vo.setScore(Integer.parseInt(rs.getString(7)));
                    vo.setAnswer(rs.getString(8));
                    vo.setCredit(Integer.parseInt(rs.getString(9)));
                    vo.setExamTime(rs.getString(10));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserExamInfoVo> UserExamInfoVoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return UserExamInfoVoList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRecordVo> queryUserrecordByDepart(String departCode) throws Exception {
        String sql = "SELECT DUM.UM_USERNAME, DUM.UM_ICID, SDC.DC_DEPARNAME, DCR.CR_CULNAME, DER.ER_SCORE,DVI.VI_NAME,DER.ER_AGENCYID,DER.ER_VIAGENID,DER.ER_EPAGENID FROM DUSERMSG DUM, SDEPARCONFIG SDC, DUSERCUL DUC, DCULRECORD DCR, DEXAMRECORD DER, SCULVIDEORELAT SCVR, DVIDEOINFO DVI, DVIDEORECORD DVR WHERE SDC.DC_BELONG=? AND SDC.DC_DEPARCODE = DUM.UM_DEPARCODE AND DUM.UM_ICID = DUC.EC_ICID AND DVR.VR_ICID = DUC.EC_ICID AND DUC.EC_CRAGENID = DCR.CR_AGENCYID AND DER.ER_ICID = DUC.EC_ICID AND SCVR.CVR_CRAGENID = DCR.CR_AGENCYID AND （TO_CHAR(DVI.VI_AGENCYID) IN SCVR.CVR_SETVIAGENID） AND DVR.VR_VIAGENID = DVI.VI_AGENCYID ORDER BY DCR.CR_CULNAME";
        Object[] args = new Object[] { departCode };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserRecordVo vo = new UserRecordVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setDepartName(rs.getString(3));
                    vo.setCulName(rs.getString(4));
                    vo.setScore((Integer.parseInt(rs.getString(5))));
                    vo.setVideoName(rs.getString(6));
                    vo.setErAgencyID((Integer.parseInt(rs.getString(7))));
                    vo.setVideoID((Integer.parseInt(rs.getString(8))));
                    vo.setEpAgencyID((Integer.parseInt(rs.getString(9))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserRecordVo> userRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return userRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRecordVo> queryUserrecordByDepartAndOffice(String departCode, String OfficeCode) throws Exception {
        String sql = "SELECT DUM.UM_USERNAME, DUM.UM_ICID, SDC.DC_DEPARNAME, DCR.CR_CULNAME, DER.ER_SCORE,DVI.VI_NAME,DER.ER_AGENCYID,DER.ER_VIAGENID,DER.ER_EPAGENID FROM DUSERMSG DUM, SDEPARCONFIG SDC, DUSERCUL DUC, DCULRECORD DCR, DEXAMRECORD DER, SCULVIDEORELAT SCVR, DVIDEOINFO DVI, DVIDEORECORD DVR WHERE SDC.DC_DEPARCODE=? AND SDC.DC_DEPARCODE = DUM.UM_DEPARCODE AND DUM.UM_ICID = DUC.EC_ICID AND DVR.VR_ICID = DUC.EC_ICID AND DUC.EC_CRAGENID = DCR.CR_AGENCYID AND DER.ER_ICID = DUC.EC_ICID AND SCVR.CVR_CRAGENID = DCR.CR_AGENCYID AND （TO_CHAR(DVI.VI_AGENCYID) IN SCVR.CVR_SETVIAGENID） AND DVR.VR_VIAGENID = DVI.VI_AGENCYID ORDER BY DCR.CR_CULNAME";
        Object[] args = new Object[] { OfficeCode };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserRecordVo vo = new UserRecordVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setDepartName(rs.getString(3));
                    vo.setCulName(rs.getString(4));
                    vo.setScore((Integer.parseInt(rs.getString(5))));
                    vo.setVideoName(rs.getString(6));
                    vo.setErAgencyID((Integer.parseInt(rs.getString(7))));
                    vo.setVideoID((Integer.parseInt(rs.getString(8))));
                    vo.setEpAgencyID((Integer.parseInt(rs.getString(9))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserRecordVo> userRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return userRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRecordVo> queryUserrecordByJob(String job) throws Exception {
        String sql = "SELECT DUM.UM_USERNAME, DUM.UM_ICID, SDC.DC_DEPARNAME, DCR.CR_CULNAME, DER.ER_SCORE,DVI.VI_NAME,DER.ER_AGENCYID,DER.ER_VIAGENID,DER.ER_EPAGENID FROM DUSERMSG DUM, SDEPARCONFIG SDC, DUSERCUL DUC, DCULRECORD DCR, DEXAMRECORD DER, SCULVIDEORELAT SCVR, DVIDEOINFO DVI, DVIDEORECORD DVR WHERE DUM.UM_POSITION=? AND SDC.DC_DEPARCODE = DUM.UM_DEPARCODE AND DUM.UM_ICID = DUC.EC_ICID AND DVR.VR_ICID = DUC.EC_ICID AND DUC.EC_CRAGENID = DCR.CR_AGENCYID AND DER.ER_ICID = DUC.EC_ICID AND SCVR.CVR_CRAGENID = DCR.CR_AGENCYID AND （TO_CHAR(DVI.VI_AGENCYID) IN SCVR.CVR_SETVIAGENID） AND DVR.VR_VIAGENID = DVI.VI_AGENCYID ORDER BY DCR.CR_CULNAME";
        Object[] args = new Object[] { job };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                UserRecordVo vo = new UserRecordVo();
                try {
                    vo.setUserName(rs.getString(1));
                    vo.setSmartCardNO(rs.getString(2));
                    vo.setDepartName(rs.getString(3));
                    vo.setCulName(rs.getString(4));
                    vo.setScore((Integer.parseInt(rs.getString(5))));
                    vo.setVideoName(rs.getString(6));
                    vo.setErAgencyID((Integer.parseInt(rs.getString(7))));
                    vo.setVideoID((Integer.parseInt(rs.getString(8))));
                    vo.setEpAgencyID((Integer.parseInt(rs.getString(9))));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<UserRecordVo> userRecordList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return userRecordList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<QuestionInfoVo> queryQuestionInfoVo(int qID) throws Exception {
        String sql = "SELECT EI_AGENCYID, EI_QUESTION, EI_ANSWERA, EI_ANSWERB, EI_ANSWERC, EI_ANSWERD, EI_ANSWER FROM DQUESTIONINFO WHERE EI_AGENCYID=?";
        Object[] args = new Object[] { qID };
        RowMapper<Object> rowMapper1 = new RowMapper<Object>() {
            public Object mapRow(ResultSet rs, int rowNum) {
                QuestionInfoVo vo = new QuestionInfoVo();
                try {
                    vo.setEi_id(rs.getString(1));
                    vo.setQuestion(rs.getString(2));
                    vo.setAnswera(rs.getString(3));
                    vo.setAnswerb(rs.getString(4));
                    vo.setAnswerc(rs.getString(5));
                    vo.setAnswerd(rs.getString(6));
                    vo.setAnswer(rs.getString(7));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return vo;
            }
        };
        List<QuestionInfoVo> questionInfoList = persistDao.selectListBySQL(sql, args, rowMapper1);
        return questionInfoList;
    }
}
