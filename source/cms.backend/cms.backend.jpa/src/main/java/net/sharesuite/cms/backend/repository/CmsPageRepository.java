package net.sharesuite.cms.backend.repository;

import net.sharesuite.cms.backend.domain.CmsPage;
import net.sharesuite.cms.backend.util.repository.BaseRepositoryI;

public interface CmsPageRepository extends BaseRepositoryI<CmsPage> {
	
	public Long getCountByWebsiteId(final Integer websiteId);

}
