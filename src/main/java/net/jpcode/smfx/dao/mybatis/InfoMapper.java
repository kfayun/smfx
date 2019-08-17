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

import net.jpcode.smfx.dao.InfoDao;
import net.jpcode.smfx.domain.Info;

/**
 * 资讯Mapper接口
 * @author Billy Zhang
 *
 */
public interface InfoMapper extends InfoDao {
	
	@Override
	List<Info> selectInfoList(
			@Param("keyword")String keyword, 
			@Param("offset")int offset, 
			@Param("limit")int limit);

	@Override
	Info selectInfoById(int id);

	@Override
	void insertInfo(Info info);

	@Override
	int deleteInfo(int id);

	@Override
	int updateInfo(Info info);

	@Override
	int selectInfoCount(
			@Param("keyword")String keyword);
	
}
