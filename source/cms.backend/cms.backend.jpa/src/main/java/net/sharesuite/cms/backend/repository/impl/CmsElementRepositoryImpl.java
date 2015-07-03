package net.sharesuite.cms.backend.repository.impl;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import net.sharesuite.cms.backend.domain.CmsElement;
import net.sharesuite.cms.backend.domain.CmsWebsite;
import net.sharesuite.cms.backend.repository.CmsElementRepository;
import net.sharesuite.cms.backend.util.repository.BaseRepository;

@Repository
public class CmsElementRepositoryImpl extends BaseRepository<CmsElement> implements
		CmsElementRepository {

	@Override
	public Long getCountByWebsiteId(Integer websiteId) {
		// TODO Auto-generated method stub
		EntityManager em = entityManagerFactory.createEntityManager();
		return (Long) em.createQuery(
				"select count(" + getCountField(CmsElement.class) + ") from "
						+ getEntityName(CmsElement.class) + " o where o.cmsWebsite = ?1 ").setParameter(1, new CmsWebsite(websiteId)).getSingleResult();
	}
	
}
