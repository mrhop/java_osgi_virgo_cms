package net.sharesuite.cms.backend.service;

import java.util.List;

import net.sharesuite.cms.backend.dto.CmsPageTemplateDto;
import net.sharesuite.cms.backend.dto.CmsPageTemplateSimpleDto;

public interface CmsPageTemplateService {
	
	public List<CmsPageTemplateSimpleDto> getPageTemplates(Integer websiteId);
	
	public CmsPageTemplateDto getPageTemplate(Integer id);
	
	public CmsPageTemplateDto createPageTemplate(CmsPageTemplateDto cmsPageTemplateDto);

	public void updatePageTemplate(CmsPageTemplateDto cmsPageTemplateDto);
	
	public void deletePageTemplate(CmsPageTemplateDto cmsPageTemplateDto);

}
