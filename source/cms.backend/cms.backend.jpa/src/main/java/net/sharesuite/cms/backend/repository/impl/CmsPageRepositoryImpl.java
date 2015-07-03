package net.sharesuite.cms.backend.repository.impl;



import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import net.sharesuite.cms.backend.domain.CmsPage;
import net.sharesuite.cms.backend.domain.CmsWebsite;
import net.sharesuite.cms.backend.repository.CmsPageRepository;
import net.sharesuite.cms.backend.util.repository.BaseRepository;

@Repository
public class CmsPageRepositoryImpl extends BaseRepository<CmsPage> implements CmsPageRepository {

	@Override
	public Long getCountByWebsiteId(final Integer websiteId) {
		// TODO Auto-generated method stub\
		EntityManager em = entityManagerFactory.createEntityManager();
		return (Long) em.createQuery(
				"select count(" + getCountField(CmsPage.class) + ") from "
						+ getEntityName(CmsPage.class) + " o where o.cmsWebsite = ?1 ").setParameter(1, new CmsWebsite(websiteId)).getSingleResult();
		
	}
	
}
