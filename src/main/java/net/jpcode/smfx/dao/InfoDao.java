/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.dao;

import java.util.List;

import net.jpcode.smfx.domain.Info;

/**
 * 资讯数据访问接口
 * @author Billy Zhang
 *
 */
public interface InfoDao {

	List<Info> selectInfoList(String keyword, int offset, int limit);

	Info selectInfoById(int id);

	void insertInfo(Info info);

	int deleteInfo(int id);

	int updateInfo(Info info);

	int selectInfoCount(String keyword);
	
}
