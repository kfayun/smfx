/*******************************************************
 * Copyright 2018 jpcode
 * contact http://www.jpcode.net/
 * 
 * --- smfx
 * 
 ********************************************************/

package net.jpcode.smfx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import net.jpcode.smfx.PageList;
import net.jpcode.smfx.Pager;
import net.jpcode.smfx.dao.InfoDao;
import net.jpcode.smfx.domain.Info;
import net.jpcode.smfx.service.InfoService;

/**
 * 资讯服务实现类
 * @author Billy Zhang
 *
 */
@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDao infoDao;

	@Cacheable(value="infoCache", key="#keyword.concat(#pager.cacheKey)")
	@Override
	public PageList<Info> selectInfoList(String keyword, Pager pager) {
		PageList<Info> plist = new PageList<>();
		plist.setTotal( infoDao.selectInfoCount(keyword) );
		if (plist.getTotal() > 0) {
			plist.setList( infoDao.selectInfoList(keyword, pager.getOffset(), pager.getPageSize()) );
		}
		
		return plist;
	}

	@Cacheable(value="infoCache", key="#id")
	@Override
	public Info selectInfoById(int id) {
		return infoDao.selectInfoById(id);
	}

	@CacheEvict(value="infoCache", allEntries=true)
	@Override
	public void insertInfo(Info info) {
		infoDao.insertInfo(info);
	}

	@CacheEvict(value="infoCache", allEntries=true)
	@Override
	public int deleteInfo(int id) {
		return infoDao.deleteInfo(id);
	}

	@CacheEvict(value="infoCache", allEntries=true)
	@Override
	public int updateInfo(Info info) {
		return infoDao.updateInfo(info);
	}

}
