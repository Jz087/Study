package com.ysbn.videotrain.managesystem.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.hctn.dev.toolkit.util.Utility;

public class PersistDao  extends JdbcDaoSupport {


	/**
	 * 插入数据
	 * 
	 * @param sql
	 *            要插入的SQL语句
	 * @param args
	 *            传递到SQL中的参数
	 * @return 受影响的行数
	 */
	public int insert(String sql, Object[] args) {
		int count = 0;
		try {
			count = this.getJdbcTemplate().update(sql, args);
			Utility.Log.i(PersistDao.class, "PersistDao: 执行更新  " + sql + " 参数  " + args
					+ " 影响了: " + count + " 行");

		} catch (Exception e) {
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e);
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e.getMessage());
		}
		return count;
	}

	/**
	 * 事务型插入数据
	 * 
	 * @param sql
	 *            要插入的SQL语句
	 * @param args
	 *            传递到SQL中的参数
	 * @return 受影响的行数
	 * @throws Exception
	 */
	public int insertWithTransaction(String sql, Object[] args)
			throws Exception {
		int count = this.updateWithTransaction(sql, args);
		return count;
	}

	/**
	 * 事务型更新数据(增加、修改、删除)
	 * 
	 * @param sql
	 *            要使用SQL语句
	 * @param args
	 *            传递到SQL语句中的参数
	 * @return 返回受影响的行数
	 * @throws Exception
	 */
	public int updateWithTransaction(String sql, Object[] args)
			throws Exception {
		int count = 0;
		try { 
			count = this.getJdbcTemplate().update(sql, args);

			Utility.Log.i(PersistDao.class, "PersistDao: 执行更新  " + sql + " 参数  " + args);

		} catch (Exception e) {
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e);
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e.getMessage());
			throw e;
		}
		return count;
	}

	/**
	 * 删除数据
	 * 
	 * @param sql
	 *            要删除的SQL语句
	 * @param args
	 *            传递到SQL中的参数
	 * @return 受影响的行数
	 */
	public int delete(String sql, Object[] args) {
		int count = this.update(sql, args);
		return count;
	}

	/**
	 * 更新数据(增加、修改、删除)
	 * 
	 * @param sql
	 *            要使用SQL语句
	 * @param args
	 *            传递到SQL语句中的参数
	 * @return 返回受影响的行数
	 */
	public int update(String sql, Object[] args) {
		int count = 0;
		try {
			count = this.getJdbcTemplate().update(sql, args);

			Utility.Log.i(PersistDao.class, "PersistDao: 执行更新  " + sql + " 参数  " + args
					+ " 影响了: " + count + " 行");

		} catch (Exception e) {
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e);
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e.getMessage());
		}
		return count;
	}

	/**
	 * 根据SQL语句查询数据并形成PO对象
	 * 
	 * @param sql
	 *            查询使用的SQL语句
	 * @param args
	 *            查询中的?参数
	 * @param rowMapper
	 *            行映射接口 例如： new RowMapper(){ public Object mapRow(ResultSet
	 *            rs,int index) throws SQLException{ int replies =
	 *            rs.getInt("topic_replies"); int views =
	 *            rs.getInt("topic_views"); } }
	 * 
	 * @return 得到的PO集合对象
	 */
	@SuppressWarnings({ "rawtypes" })
	public List selectListBySQL(String sql, Object[] args,
			RowMapper<?> rowMapper) {

		List result = null;
		try {
			result = this.getJdbcTemplate().query(sql, args, rowMapper);
			Utility.Log.i(PersistDao.class, "PersistDao: 执行查询对象集合  " + sql + " 参数 :"
					+ args + " 集合大小: " + (result == null ? -1 : result.size()));
		} catch (Exception e) {
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e);
			Utility.Log.e(PersistDao.class, "PersistDao: 错误! " + e.getMessage());
		}
		return result;
	}
	
	
	
	


	/**
	 * 批量执行SQL更新操作
	 * 
	 * @param sql
	 *            要执行的SQL语句集
	 * @return 各语句影响的行数
	 */
	public int[] batchUpdate(String[] sql) {
		int[] counts = this.getJdbcTemplate().batchUpdate(sql);
		Utility.Log.i(PersistDao.class, "PersistDao: 执行批量更新SQL语句  " + sql);

		return counts;
	}
	
	/**
	 *  
	 *  调用存储过程，获取返回值
	 *    
	 **/
	public Map<String,Object> getProcedure(String ProcedureName , Map<String,String> map) throws Exception{
		 SimpleJdbcCall procReadActor = new SimpleJdbcCall(this.getJdbcTemplate()).withProcedureName(ProcedureName);
		 MapSqlParameterSource ms = new MapSqlParameterSource();
		 Set<Entry<String,String>> set = map.entrySet();
	        for (Iterator<Entry<String, String>> it = set.iterator(); it.hasNext();) {
	            Map.Entry<String,String> entry = (Map.Entry<String,String>) it.next();
	            ms.addValue((String) entry.getKey(), entry.getValue());
	            Utility.Log.i(PersistDao.class,entry.getKey()+" "+entry.getValue());
	        }
		 SqlParameterSource in  = ms ;
		 Map<String,Object> out = procReadActor.execute(in);
		 return out ;
	}
}
