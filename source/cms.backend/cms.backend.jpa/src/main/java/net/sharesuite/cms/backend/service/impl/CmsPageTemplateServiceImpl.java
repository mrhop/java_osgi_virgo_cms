package net.sharesuite.cms.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sharesuite.cms.backend.domain.CmsPageTemplate;
import net.sharesuite.cms.backend.domain.CmsWebsite;
import net.sharesuite.cms.backend.dto.CmsPageTemplateDto;
import net.sharesuite.cms.backend.dto.CmsPageTemplateSimpleDto;
import net.sharesuite.cms.backend.repository.CmsPageTemplateRepository;
import net.sharesuite.cms.backend.repository.CmsWebsiteRepository;
import net.sharesuite.cms.backend.service.CmsPageTemplateService;
import net.sharesuite.cms.backend.util.tool.BeanUtils;

@Service("cmsPageTemplateService")
public class CmsPageTemplateServiceImpl implements CmsPageTemplateService {

	@Autowired
	private CmsPageTemplateRepository cmsPageTemplateRepository;
	@Autowired
	private CmsWebsiteRepository cmsWebsiteRepository;

	@Override
	public List<CmsPageTemplateSimpleDto> getPageTemplates(Integer websiteId) {
		// TODO Auto-generated method stub
		List<CmsPageTemplate> list = cmsPageTemplateRepository.getScrollData(
				CmsPageTemplate.class, -1, -1, " o.cmsWebsite = ?1 ",
				new Object[] { new CmsWebsite(websiteId) }).getResultlist();
		List<CmsPageTemplateSimpleDto> listReturn = new ArrayList<CmsPageTemplateSimpleDto>();
		if (list != null && list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				CmsPageTemplateSimpleDto csd = new CmsPageTemplateSimpleDto();
				BeanUtils.copyProperties(list.get(i), csd);
				listReturn.add(csd);
			}
		}
		return listReturn;
	}

	@Override
	public CmsPageTemplateDto getPageTemplate(Integer id) {
		// TODO Auto-generated method stub
		CmsPageTemplate cmsPageTemplate = cmsPageTemplateRepository.find(
				CmsPageTemplate.class, id);
		if (cmsPageTemplate != null) {
			CmsPageTemplateDto csd = new CmsPageTemplateDto();
			BeanUtils.copyProperties(cmsPageTemplate, csd);
			return csd;
		}
		return null;
	}

	@Override
	public CmsPageTemplateDto createPageTemplate(
			CmsPageTemplateDto cmsPageTemplateDto) {
		// TODO Auto-generated method stub
		CmsPageTemplate cs = new CmsPageTemplate();
		BeanUtils.copyProperties(cmsPageTemplateDto, cs);

		if (cmsPageTemplateDto.getWebsiteId() != null) {
			cs.setCmsWebsite(cmsWebsiteRepository.find(CmsWebsite.class,
					cmsPageTemplateDto.getWebsiteId()));
		}
		cmsPageTemplateRepository.save(cs);
		cmsPageTemplateDto.setId(cs.getId());
		return cmsPageTemplateDto;
	}

	@Override
	public void updatePageTemplate(CmsPageTemplateDto cmsPageTemplateDto) {
		// TODO Auto-generated method stub
		CmsPageTemplate cs = cmsPageTemplateRepository.find(
				CmsPageTemplate.class, cmsPageTemplateDto.getId());
		if (cs != null) {
			BeanUtils.copyProperties(cmsPageTemplateDto, cs);
			cmsPageTemplateRepository.update(cs);
		}
	}

	@Override
	public void deletePageTemplate(CmsPageTemplateDto cmsPageTemplateDto) {
		// TODO Auto-generated method stub
		cmsPageTemplateRepository.delete(CmsPageTemplate.class,
				cmsPageTemplateDto.getId());
	}

}
