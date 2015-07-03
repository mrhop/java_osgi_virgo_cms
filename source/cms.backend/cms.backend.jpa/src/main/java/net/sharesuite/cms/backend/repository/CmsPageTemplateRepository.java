package net.sharesuite.cms.backend.repository;

import net.sharesuite.cms.backend.domain.CmsPageTemplate;
import net.sharesuite.cms.backend.util.repository.BaseRepositoryI;

public interface CmsPageTemplateRepository extends
		BaseRepositoryI<CmsPageTemplate> {
	
	public Long getCountByWebsiteId(final Integer websiteId);

}
