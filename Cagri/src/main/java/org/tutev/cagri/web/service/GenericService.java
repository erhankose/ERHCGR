package org.tutev.cagri.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.dto.genel.Il;

@Service("genericService")
public class GenericService  {

	@Autowired
	private transient BaseDao baseDao;
	
	
	public Il getIlById(Long id) {
		return (Il)baseDao.getById(id, Il.class);
	}
}
