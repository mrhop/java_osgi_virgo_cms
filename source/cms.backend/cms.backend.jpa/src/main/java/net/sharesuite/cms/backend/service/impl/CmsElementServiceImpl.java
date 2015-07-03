package net.sharesuite.cms.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sharesuite.cms.backend.domain.CmsElement;
import net.sharesuite.cms.backend.domain.CmsElementTemplate;
import net.sharesuite.cms.backend.domain.CmsWebsite;
import net.sharesuite.cms.backend.dto.CmsElementDto;
import net.sharesuite.cms.backend.dto.CmsElementSimpleDto;
import net.sharesuite.cms.backend.repository.CmsElementRepository;
import net.sharesuite.cms.backend.repository.CmsElementTemplateRepository;
import net.sharesuite.cms.backend.repository.CmsWebsiteRepository;
import net.sharesuite.cms.backend.service.CmsElementService;
import net.sharesuite.cms.backend.util.tool.BeanUtils;

@Service("cmsElementService")
public class CmsElementServiceImpl implements CmsElementService {

	@Autowired
	private CmsElementRepository cmsElementRepository;
	@Autowired
	private CmsWebsiteRepository cmsWebsiteRepository;
	@Autowired
	private CmsElementTemplateRepository cmsElementTemplateRepository;

	@Override
	public List<CmsElementSimpleDto> getElements(Integer websiteId) {
		// TODO Auto-generated method stub
		List<CmsElement> list = cmsElementRepository.getScrollData(
				CmsElement.class, -1, -1, " o.cmsWebsite = ?1 ",
				new Object[] { new CmsWebsite(websiteId) }).getResultlist();
		List<CmsElementSimpleDto> listReturn = new ArrayList<CmsElementSimpleDto>();
		if (list != null && list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				CmsElementSimpleDto csd = new CmsElementSimpleDto();
				BeanUtils.copyProperties(list.get(i), csd);
				listReturn.add(csd);
			}
		}
		return listReturn;
	}

	@Override
	public CmsElementDto getElement(Integer id) {
		// TODO Auto-generated method stub
		CmsElement cmsElement = cmsElementRepository.find(CmsElement.class, id);
		if (cmsElement != null) {
			CmsElementDto csd = new CmsElementDto();
			BeanUtils.copyProperties(cmsElement, csd);
			if (cmsElement.getCmsElementTemplate() != null) {
				csd.setTemplate(cmsElement.getCmsElementTemplate()
						.getTemplate());
			}
			return csd;
		}
		return null;
	}

	@Override
	public CmsElementDto createElement(CmsElementDto cmsElementDto) {
		// TODO Auto-generated method stub
		CmsElement cs = new CmsElement();
		BeanUtils.copyProperties(cmsElementDto, cs);
		if (cmsElementDto.getTemplate() != null) {
			cs.setCmsElementTemplate(cmsElementTemplateRepository.find(
					CmsElementTemplate.class,
					Integer.parseInt(cmsElementDto.getTemplate())));
		}
		if (cmsElementDto.getWebsiteId() != null) {
			cs.setCmsWebsite(cmsWebsiteRepository.find(CmsWebsite.class,
					cmsElementDto.getWebsiteId()));
		}
		cmsElementRepository.save(cs);
		cmsElementDto.setId(cs.getId());
		return cmsElementDto;
	}

	@Override
	public void updateElement(CmsElementDto cmsElementDto) {
		// TODO Auto-generated method stub
		CmsElement cs = cmsElementRepository.find(CmsElement.class,
				cmsElementDto.getId());
		if (cs != null) {
			BeanUtils.copyProperties(cmsElementDto, cs);
			if (cmsElementDto.getTemplate() != null) {
				cs.setCmsElementTemplate(cmsElementTemplateRepository.find(
						CmsElementTemplate.class,
						Integer.parseInt(cmsElementDto.getTemplate())));
			}
			cmsElementRepository.update(cs);
		}
	}

	@Override
	public void deleteElement(CmsElementSimpleDto cmsElementSimpleDto) {
		// TODO Auto-generated method stub
		cmsElementRepository.delete(CmsElement.class,
				cmsElementSimpleDto.getId());
	}

	@Override
	public CmsElementDto createElementB(CmsElementDto cmsElementDto) {
		// TODO Auto-generated method stub
		CmsElement cs = new CmsElement();
		BeanUtils.copyProperties(cmsElementDto, cs);
		if (cmsElementDto.getTemplate() != null) {
			CmsElementTemplate cet =new CmsElementTemplate();
			cet.setName(cmsElementDto.getName());
			cet.setTemplate(cmsElementDto.getTemplate());
			//cmsElementTemplateRepository.save(cet);
			cs.setCmsElementTemplate(cet);
		}
		if (cmsElementDto.getWebsiteId() != null) {
			cs.setCmsWebsite(cmsWebsiteRepository.find(CmsWebsite.class,
					cmsElementDto.getWebsiteId()));
		}
		cmsElementRepository.save(cs);
		cmsElementDto.setId(cs.getId());
		return cmsElementDto;
	}

	@Override
	public void updateElementB(CmsElementDto cmsElementDto) {
		// TODO Auto-generated method stub
		CmsElement cs = cmsElementRepository.find(CmsElement.class,
				cmsElementDto.getId());
		if (cs != null) {
			BeanUtils.copyProperties(cmsElementDto, cs);
			if (cmsElementDto.getTemplate() != null) {
				cs.getCmsElementTemplate().setName(cmsElementDto.getName());
				cs.getCmsElementTemplate().setTemplate(cmsElementDto.getTemplate());				
			}
			cmsElementRepository.update(cs);
		}
	}

}
