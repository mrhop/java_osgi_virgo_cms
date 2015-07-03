package net.sharesuite.cms.backend.repository;

import net.sharesuite.cms.backend.domain.CmsElement;
import net.sharesuite.cms.backend.util.repository.BaseRepositoryI;

public interface CmsElementRepository extends BaseRepositoryI<CmsElement> {
	
	public Long getCountByWebsiteId(final Integer websiteId);

}
