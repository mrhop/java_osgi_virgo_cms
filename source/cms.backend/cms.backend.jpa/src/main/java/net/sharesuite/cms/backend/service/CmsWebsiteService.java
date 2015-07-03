package net.sharesuite.cms.backend.service;

import java.util.List;

import net.sharesuite.cms.backend.dto.CmsWebsiteDto;
import net.sharesuite.cms.backend.dto.CmsWebsiteSimpleDto;

public interface CmsWebsiteService {

	public List<CmsWebsiteSimpleDto> getWebsites();

	public CmsWebsiteDto getWebsite(Integer id);

	public CmsWebsiteSimpleDto createWebsite(CmsWebsiteSimpleDto cmsWebsiteSimpleDto);

	public void updateWebsite(CmsWebsiteSimpleDto cmsWebsiteSimpleDto);
	
	public void deleteWebsite(CmsWebsiteSimpleDto cmsWebsiteSimpleDto);
	
	public void updatePageStatus(CmsWebsiteDto cmsWebsiteDto);
	
}
