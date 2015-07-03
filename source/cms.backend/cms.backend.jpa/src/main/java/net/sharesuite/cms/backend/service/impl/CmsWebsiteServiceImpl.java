package net.sharesuite.cms.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sharesuite.cms.backend.domain.CmsWebsite;
import net.sharesuite.cms.backend.dto.CmsWebsiteDto;
import net.sharesuite.cms.backend.dto.CmsWebsiteSimpleDto;
import net.sharesuite.cms.backend.repository.CmsElementRepository;
import net.sharesuite.cms.backend.repository.CmsPageRepository;
import net.sharesuite.cms.backend.repository.CmsPageTemplateRepository;
import net.sharesuite.cms.backend.repository.CmsWebsiteRepository;
import net.sharesuite.cms.backend.service.CmsWebsiteService;
import net.sharesuite.cms.backend.util.tool.BeanUtils;

@Service("cmsWebsiteService")
public class CmsWebsiteServiceImpl implements CmsWebsiteService {

	@Autowired
	private CmsWebsiteRepository cmsWebsiteRepository;
	@Autowired
	private CmsPageRepository cmsPageRepository;
	@Autowired
	private CmsPageTemplateRepository cmsPageTemplateRepository;
	@Autowired
	private CmsElementRepository cmsElementRepository;

	@Override
	public List<CmsWebsiteSimpleDto> getWebsites() {
		// TODO Auto-generated method stub
		List<CmsWebsite> list = cmsWebsiteRepository.getScrollData(
				CmsWebsite.class).getResultlist();
		List<CmsWebsiteSimpleDto> listReturn = new ArrayList<CmsWebsiteSimpleDto>();
		if (list != null && list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				CmsWebsiteSimpleDto csd = new CmsWebsiteSimpleDto();
				BeanUtils.copyProperties(list.get(i), csd);
				listReturn.add(csd);
			}
		}
		return listReturn;
	}

	@Override
	public CmsWebsiteDto getWebsite(Integer id) {
		// TODO Auto-generated method stub
		CmsWebsite cmsWebsite = cmsWebsiteRepository.find(CmsWebsite.class, id);
		if (cmsWebsite != null) {
			CmsWebsiteDto csd = new CmsWebsiteDto();
			BeanUtils.copyProperties(cmsWebsite, csd);
			csd.setCount_elements(cmsElementRepository.getCountByWebsiteId(id));
			csd.setCount_pages(cmsPageRepository.getCountByWebsiteId(id));
			csd.setCount_templates(cmsPageTemplateRepository.getCountByWebsiteId(id));
			return csd;
		}
		return null;
	}

	@Override
	public CmsWebsiteSimpleDto createWebsite(
			CmsWebsiteSimpleDto cmsWebsiteSimpleDto) {
		// TODO Auto-generated method stub
		CmsWebsite cs = new CmsWebsite();
		BeanUtils.copyProperties(cmsWebsiteSimpleDto, cs);
		cmsWebsiteRepository.save(cs);
		cmsWebsiteSimpleDto.setId(cs.getId());
		return cmsWebsiteSimpleDto;
	}

	@Override
	public void updateWebsite(CmsWebsiteSimpleDto cmsWebsiteSimpleDto) {
		// TODO Auto-generated method stub
		CmsWebsite cs = cmsWebsiteRepository.find(CmsWebsite.class, cmsWebsiteSimpleDto.getId());
		if(cs!=null){
			BeanUtils.copyProperties(cmsWebsiteSimpleDto, cs);
			cmsWebsiteRepository.update(cs);
		}
	}

	@Override
	public void deleteWebsite(CmsWebsiteSimpleDto cmsWebsiteSimpleDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePageStatus(CmsWebsiteDto cmsWebsiteDto) {
		// TODO Auto-generated method stub
		CmsWebsite cmsWebsite = cmsWebsiteRepository.find(CmsWebsite.class, cmsWebsiteDto.getId());
		if(cmsWebsite!=null){
			cmsWebsite.setStatus(cmsWebsiteDto.getStatus());
			cmsWebsiteRepository.update(cmsWebsite);
		}
	}

}
