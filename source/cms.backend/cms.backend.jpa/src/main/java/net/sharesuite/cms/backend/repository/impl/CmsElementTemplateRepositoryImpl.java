package net.sharesuite.cms.backend.repository.impl;


import org.springframework.stereotype.Repository;

import net.sharesuite.cms.backend.domain.CmsElementTemplate;
import net.sharesuite.cms.backend.repository.CmsElementTemplateRepository;
import net.sharesuite.cms.backend.util.repository.BaseRepository;

@Repository
public class CmsElementTemplateRepositoryImpl extends
		BaseRepository<CmsElementTemplate> implements
		CmsElementTemplateRepository {

}
