package net.sharesuite.cms.backend.service;

import java.util.List;

import net.sharesuite.cms.backend.dto.CmsElementDto;
import net.sharesuite.cms.backend.dto.CmsElementSimpleDto;

public interface CmsElementService {
	
	public List<CmsElementSimpleDto> getElements(Integer websiteId);
	
	public CmsElementDto getElement(Integer id);
	
	public CmsElementDto createElement(CmsElementDto cmsElementDto);
	
	public void updateElement(CmsElementDto cmsElementDto);
	
	public CmsElementDto createElementB(CmsElementDto cmsElementDto);
	
	public void updateElementB(CmsElementDto cmsElementDto);
	
	public void deleteElement(CmsElementSimpleDto cmsElementSimpleDto);

}
