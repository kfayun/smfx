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
import net.jpcode.smfx.domain.Info;

/**
 * 资讯服务接口
 * @author Billy Zhang
 *
 */
public interface InfoService {

	PageList<Info> selectInfoList(String keyword, Pager pager);

	Info selectInfoById(int id);

	void insertInfo(Info info);

	int deleteInfo(int id);

	int updateInfo(Info info);
}
