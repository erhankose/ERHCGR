package org.tutev.cagri.web.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tutev.cagri.web.base.BaseDao;
import org.tutev.cagri.web.base.Exception;
import org.tutev.cagri.web.dto.genel.Il;
import org.tutev.cagri.web.dto.genel.Ilce;
import org.tutev.cagri.web.dto.kullanici.Role;

@Service("genericService")
@Transactional
public class GenericService  {

	@Autowired
	private transient BaseDao baseDao;
	
	
	public Il getIlById(Long id) {
		return (Il)baseDao.getById(id, Il.class);
	}

	@Transactional
	public Role getRoleById(Long id) {
		return (Role)baseDao.getById(id, Role.class);
	}

	public List<Ilce> getIlceByIlId(Long id) {
		Criteria criteria=baseDao.getSession().createCriteria(Ilce.class);
		criteria.add(Restrictions.eq("il.id", id));
		return criteria.list();
	}
	
	public List<Il> getIlByName(String name) {
		Criteria criteria=baseDao.getSession().createCriteria(Il.class);
		criteria.add(Restrictions.ilike("tanim", name,MatchMode.ANYWHERE));
		criteria.setMaxResults(10);
		return criteria.list();
	}


	public Ilce getIlceById(Long id) {
		return (Ilce)baseDao.getById(id, Ilce.class);
	}
	
	public void addException(Exception exc) {
		exc.setTarih(new Date());
		baseDao.save(exc);
	}
}
