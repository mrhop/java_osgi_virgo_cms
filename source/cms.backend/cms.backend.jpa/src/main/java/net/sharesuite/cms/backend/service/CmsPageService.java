package net.sharesuite.cms.backend.service;

import java.util.List;
import java.util.Map;

import net.sharesuite.cms.backend.dto.CmsContentPageIn;
import net.sharesuite.cms.backend.dto.CmsContentPageOut;
import net.sharesuite.cms.backend.dto.CmsPageDto;
import net.sharesuite.cms.backend.dto.CmsPageSimpleDto;

public interface CmsPageService {

	public List<CmsPageSimpleDto> getPages(Integer websiteId);

	public CmsPageDto getPage(Integer id);

	public CmsPageDto createPage(CmsPageDto cmsPageDto);

	public void updatePage(CmsPageDto cmsPageDto);
	
	public void deletePage(CmsPageSimpleDto cmsPageSimpleDto);
	
	public Map<String,String> formatPage(Integer id,Integer langId);
	
	public CmsContentPageOut getContentByPageIdAndLangId(Integer id,Integer langId);
	
	public void saveContentOfOnePage(CmsContentPageIn cmsContentPageIn);
	
	public void updatePageStatus(CmsPageSimpleDto cmsPageSimpleDto);
	
}
