/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.service;

import net.jpcode.smfx.PageList;
import net.jpcode.smfx.Pager;
import net.jpcode.smfx.domain.AdminLog;
import net.jpcode.smfx.domain.Administrator;

/**
 * 管理员服务接口
 * @author Billy Zhang
 *
 */
public interface AdminService {

	/**
	 */
	Administrator selectAdminById(int adminId);
	
	/**
	 */
	Administrator selectAdminByName(String loginname);

	/**
	 */
	Administrator selectAdminByNameAndPassword(String loginName, String password);

	/**
	 */
	void insertAdmin(Administrator user);

	/**
	 * @return 
	 */
	int updateAdmin(Administrator user);

	/**
	 * @return 
	 */
	int deleteAdmin(int adminId);

	/**
	 */
	PageList<Administrator> selectAdminList(String keyword, Pager pager);

	/**
	 */
	void insertAdminLog(AdminLog log);


	/**
	 */
	PageList<AdminLog> selectAdminLogList(String category, Pager pager);
}
