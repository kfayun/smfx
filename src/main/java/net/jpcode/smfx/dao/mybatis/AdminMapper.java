/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import net.jpcode.smfx.dao.AdminDao;
import net.jpcode.smfx.domain.AdminLog;
import net.jpcode.smfx.domain.Administrator;

/**
 * 管理员Mapper接口
 * @author Billy Zhang
 *
 */
public interface AdminMapper extends AdminDao {

	@Override
	Administrator selectAdminById(int adminId) throws DataAccessException;

	@Override
	Administrator selectAdminByName(String loginname) throws DataAccessException;

	@Override
	Administrator selectAdminByNameAndPassword(
			@Param("loginName")String loginName, 
			@Param("password")String password) throws DataAccessException;

	@Override
	void insertAdmin(Administrator admin) throws DataAccessException;

	@Override
	int updateAdmin(Administrator admin) throws DataAccessException;

	@Override
	int deleteAdmin(int adminId) throws DataAccessException;

	@Override
	int selectAdminCount(
			@Param("keyword")String keyword);

	@Override
	List<Administrator> selectAdminList(
			@Param("keyword")String keyword, 
			@Param("offset")int offset, 
			@Param("limit")int limit);

	@Override
	void insertAdminLog(AdminLog log);

	@Override
	int selectAdminLogCount(
			@Param("category")String category);

	@Override
	List<AdminLog> selectAdminLogList(
			@Param("category")String category, 
			@Param("offset")int offset, 
			@Param("limit")int limit);
	
}
