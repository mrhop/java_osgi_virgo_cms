package net.sharesuite.cms.backend.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sharesuite.cms.backend.domain.CmsElement;
import net.sharesuite.cms.backend.domain.CmsElementLang;
import net.sharesuite.cms.backend.domain.CmsPage;
import net.sharesuite.cms.backend.domain.CmsPageTemplate;
import net.sharesuite.cms.backend.domain.CmsWebsite;
import net.sharesuite.cms.backend.dto.CmsContentElementIn;
import net.sharesuite.cms.backend.dto.CmsContentElementOut;
import net.sharesuite.cms.backend.dto.CmsContentPageIn;
import net.sharesuite.cms.backend.dto.CmsContentPageOut;
import net.sharesuite.cms.backend.dto.CmsPageDto;
import net.sharesuite.cms.backend.dto.CmsPageSimpleDto;
import net.sharesuite.cms.backend.repository.CmsElementLangRepository;
import net.sharesuite.cms.backend.repository.CmsElementRepository;
import net.sharesuite.cms.backend.repository.CmsPageRepository;
import net.sharesuite.cms.backend.repository.CmsPageTemplateRepository;
import net.sharesuite.cms.backend.repository.CmsWebsiteRepository;
import net.sharesuite.cms.backend.service.CmsPageService;
import net.sharesuite.cms.backend.util.repository.QueryResult;
import net.sharesuite.cms.backend.util.tool.BeanUtils;
import net.sharesuite.cms.backend.util.tool.JacksonJsonUtil;
import net.sharesuite.cms.backend.util.tool.UtilTool;

@Service("cmsPageService")
public class CmsPageServiceImpl implements CmsPageService {

	@Autowired
	private CmsPageRepository cmsPageRepository;
	@Autowired
	private CmsWebsiteRepository cmsWebsiteRepository;
	@Autowired
	private CmsPageTemplateRepository cmsPageTemplateRepository;
	@Autowired
	private CmsElementRepository cmsElementRepository;
	@Autowired
	private CmsElementLangRepository cmsElementLangRepository;

	@Override
	public List<CmsPageSimpleDto> getPages(Integer websiteId) {
		// TODO Auto-generated method stub
		List<CmsPage> list = cmsPageRepository.getScrollData(CmsPage.class, -1,
				-1, " o.cmsWebsite = ?1 ",
				new Object[] { new CmsWebsite(websiteId) }).getResultlist();
		List<CmsPageSimpleDto> listReturn = new ArrayList<CmsPageSimpleDto>();
		if (list != null && list.size() > 0) {

			for (int i = 0; i < list.size(); i++) {
				CmsPageSimpleDto csd = new CmsPageSimpleDto();
				BeanUtils.copyProperties(list.get(i), csd);
				if (list.get(i).getCmsPageTemplate() != null) {
					csd.setTemplateId(list.get(i).getCmsPageTemplate().getId());
				}
				listReturn.add(csd);
			}
		}
		return listReturn;
	}

	@Override
	public CmsPageDto getPage(Integer id) {
		// TODO Auto-generated method stub
		CmsPage cmsPage = cmsPageRepository.find(CmsPage.class, id);
		if (cmsPage != null) {
			CmsPageDto csd = new CmsPageDto();
			BeanUtils.copyProperties(cmsPage, csd);
			if (cmsPage.getCmsPageTemplate() != null) {
				csd.setTemplateId(cmsPage.getCmsPageTemplate().getId());
			}
			if (cmsPage.getParentPage() != null) {
				csd.setParentPageId(cmsPage.getParentPage().getId());
			}
			return csd;
		}
		return null;
	}

	@Override
	public CmsPageDto createPage(CmsPageDto cmsPageDto) {
		// TODO Auto-generated method stub
		CmsPage cs = new CmsPage();
		BeanUtils.copyProperties(cmsPageDto, cs);
		if (cmsPageDto.getParentPageId() != null) {
			cs.setParentPage(cmsPageRepository.find(CmsPage.class,
					cmsPageDto.getParentPageId()));
		}
		if (cmsPageDto.getTemplateId() != null) {
			// T deal
			cs.setCmsPageTemplate(cmsPageTemplateRepository.find(
					CmsPageTemplate.class, cmsPageDto.getTemplateId()));
		}
		if (cmsPageDto.getWebsiteId() != null) {
			cs.setCmsWebsite(cmsWebsiteRepository.find(CmsWebsite.class,
					cmsPageDto.getWebsiteId()));
		}
		cmsPageRepository.save(cs);
		cmsPageDto.setId(cs.getId());
		return cmsPageDto;
	}

	@Override
	public void updatePage(CmsPageDto cmsPageDto) {
		// TODO Auto-generated method stub
		CmsPage cs = cmsPageRepository.find(CmsPage.class, cmsPageDto.getId());
		if (cs != null) {
			BeanUtils.copyProperties(cmsPageDto, cs);
			if (cmsPageDto.getParentPageId() != null) {
				cs.setParentPage(cmsPageRepository.find(CmsPage.class,
						cmsPageDto.getParentPageId()));
			}
			if (cmsPageDto.getTemplateId() != null) {
				// T deal
				cs.setCmsPageTemplate(cmsPageTemplateRepository.find(
						CmsPageTemplate.class, cmsPageDto.getTemplateId()));
			}
			cmsPageRepository.update(cs);
		}

	}

	@Override
	public void deletePage(CmsPageSimpleDto cmsPageSimpleDto) {
		// TODO Auto-generated method stub
		cmsPageRepository.delete(CmsPage.class, cmsPageSimpleDto.getId());
	}

	@Override
	public Map<String, String> formatPage(Integer id, Integer langId) {
		// TODO Auto-generated method stub
		Map<String, String> mapReturn = new HashMap<String, String>();
		CmsPage cmsPage = cmsPageRepository.find(CmsPage.class, id);
		if (cmsPage == null || cmsPage.getCmsPageTemplate() == null) {
			mapReturn.put("content", "");
			return mapReturn;
		}
		String tpl = cmsPage.getCmsPageTemplate().getTemplate();
		// find matches
		List<String> listE = UtilTool.getMatches(tpl,
				"\\$\\{element:[a-zA-Z_0-9]*\\}");
		if (listE != null && listE.size() > 0) {
			Map<String, Integer> mapRepeat = new HashMap<String, Integer>();
			// 进行element的迭代
			for (String elementRegex : listE) {
				if (mapRepeat.get(elementRegex) == null) {
					mapRepeat.put(elementRegex, 0);
				} else {
					mapRepeat
							.put(elementRegex, mapRepeat.get(elementRegex) + 1);
				}
				String eleValue = null;
				String elementCode = elementRegex.replaceAll("\\$\\{element:",
						"").replaceAll("\\}", "");
				QueryResult<CmsElement> els = cmsElementRepository
						.getScrollData(CmsElement.class, 0, 1,
								" o.elementCode = ?1 ",
								new Object[] { elementCode });
				if (els.getResultlist() != null
						&& els.getResultlist().size() > 0) {
					CmsElement e = els.getResultlist().get(0);

					eleValue = this.iterateElement(e, langId, cmsPage,
							mapRepeat.get(elementRegex));
				}
				if (eleValue != null) {
					tpl = tpl.replaceFirst(elementRegex.replace("$", "\\$").replace("{", "\\{").replace("}", "\\}"), eleValue);
				}
			}
		}
		mapReturn.put("content", tpl);
		return mapReturn;
	}

	@SuppressWarnings("unchecked")
	protected String iterateElement(CmsElement element, Integer langId,
			CmsPage cmsPage, Integer index) {
		String tpl = element.getCmsElementTemplate().getTemplate();
		List<String> listE = UtilTool.getMatches(tpl,
				"\\$\\{element:[a-zA-Z_0-9]*\\}");
		for (String elementRegex : listE) {
			String eleValue = "";
			String elementCode = elementRegex.replaceAll("\\$\\{element:", "")
					.replaceAll("\\}", "");
			QueryResult<CmsElement> els = cmsElementRepository.getScrollData(
					CmsElement.class, 0, 1, " o.elementCode = ?1 ",
					new Object[] { elementCode });
			if (els.getResultlist() != null && els.getResultlist().size() > 0) {
				CmsElement e = els.getResultlist().get(0);
				eleValue = this.iterateElement(e, langId);
			}
			if (eleValue != null) {
				tpl = tpl.replaceFirst(elementRegex.replace("$", "\\$").replace("{", "\\{").replace("}", "\\}"), eleValue);
			}
		}
		List<String> listV = UtilTool.getMatches(tpl,
				"\\$\\{(?!element:)[:a-zA-Z_0-9]*\\}");
		System.out.println("tpl"+tpl);
		System.out.println("size"+listV.size());
		if (listV != null && listV.size() > 0) {
			QueryResult<CmsElementLang> elr = cmsElementLangRepository
					.getScrollData(
							CmsElementLang.class,
							0,
							1,
							" o.cmsPage = ?1 and o.cmsElement = ?2 and o.langId = ?3 ",
							new Object[] { cmsPage, element, langId });
			List<HashMap<String, String>> listContent = new ArrayList<HashMap<String, String>>();
			if (elr.getResultlist() != null && elr.getResultlist().size() > 0) {
				CmsElementLang el = elr.getResultlist().get(0);
				String contentJson = el.getContent();
				try {
					listContent = (List<HashMap<String, String>>) JacksonJsonUtil
							.jsonToBean(contentJson, List.class);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// Content no need
					e.printStackTrace();
				}
			} else {
				// maybe sth else
			}
			Map<String, String> mapContent = listContent.get(index);
			if (mapContent != null) {
				for (String v : listV) {
					System.out.println("valueK:"+v);
					String value = mapContent.get(v.replaceAll("\\$", "")
							.replaceAll("\\{", "").replaceAll("\\}", "")
							.split(":")[0]);
					if (value != null) {
						tpl = tpl.replaceFirst(v.replace("$", "\\$").replace("{", "\\{").replace("}", "\\}"), value);
					}
				}
			}
		}
		return tpl;
	}

	@SuppressWarnings("unchecked")
	protected String iterateElement(CmsElement element, Integer langId) {
		String tpl = element.getCmsElementTemplate().getTemplate();
		List<String> listE = UtilTool.getMatches(tpl,
				"\\$\\{element:[a-zA-Z_0-9]*\\}");
		for (String elementRegex : listE) {
			String eleValue = "";
			String elementCode = elementRegex.replaceAll("\\$\\{element:", "")
					.replaceAll("\\}", "");
			QueryResult<CmsElement> els = cmsElementRepository.getScrollData(
					CmsElement.class, 0, 1, " o.elementCode = ?1 ",
					new Object[] { elementCode });
			if (els.getResultlist() != null && els.getResultlist().size() > 0) {
				CmsElement e = els.getResultlist().get(0);
				eleValue = this.iterateElement(e, langId);
			}
			if (eleValue != null) {
				tpl = tpl.replaceFirst(elementRegex.replace("$", "\\$").replace("{", "\\{").replace("}", "\\}"), eleValue);
			}
		}
		List<String> listV = UtilTool.getMatches(tpl,
				"\\$\\{(?!element:)[:a-zA-Z_0-9]*\\}");
		if (listV != null && listV.size() > 0) {
			QueryResult<CmsElementLang> elr = cmsElementLangRepository
					.getScrollData(
							CmsElementLang.class,
							0,
							1,
							" o.cmsElement = ?1 and o.langId = ?2 ",
							new Object[] { element, langId });
			List<HashMap<String, String>> listContent = new ArrayList<HashMap<String, String>>();
			if (elr.getResultlist() != null && elr.getResultlist().size() > 0) {
				CmsElementLang el = elr.getResultlist().get(0);
				String contentJson = el.getContent();
				try {
					listContent = (List<HashMap<String, String>>) JacksonJsonUtil
							.jsonToBean(contentJson, List.class);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// Content no need
					e.printStackTrace();
				}
			} else {
				// maybe sth else
			}
			Map<String, String> mapContent = listContent.get(0);
			if (mapContent != null) {
				for (String v : listV) {
					String value = mapContent.get(v.replaceAll("\\$", "")
							.replaceAll("\\{", "").replaceAll("\\}", "")
							.split(":")[0]);
					if (value != null) {
						tpl = tpl.replaceFirst(v.replace("$", "\\$").replace("{", "\\{").replace("}", "\\}"), value);
					}
				}
			}
		}
		return tpl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CmsContentPageOut getContentByPageIdAndLangId(Integer id,
			Integer langId) {
		// TODO Auto-generated method stub
		// 首先获取page
		CmsPage cmsPage = cmsPageRepository.find(CmsPage.class, id);
		if (cmsPage != null) {
			CmsContentPageOut ccp = new CmsContentPageOut();
			ccp.setName(cmsPage.getName());
			ccp.setTemplate(cmsPage.getCmsPageTemplate().getTemplate());
			if (cmsPage.getCmsPageTemplate() != null) {
				String tpl = cmsPage.getCmsPageTemplate().getTemplate();
				// find matches
				List<String> listE = UtilTool.getMatches(tpl,
						"\\$\\{element:[a-zA-Z_0-9]*\\}");
				// 根据tpl获取element
				if (listE != null && listE.size() > 0) {
					Map<String, Integer> mapRepeat = new HashMap<String, Integer>();
					List<CmsContentElementOut> elements = new ArrayList<CmsContentElementOut>();
					// 进行element的迭代
					for (String elementRegex : listE) {
						if (mapRepeat.get(elementRegex) == null) {
							mapRepeat.put(elementRegex, 0);
						} else {
							continue;
						}
						String elementCode = elementRegex.replaceAll(
								"\\$\\{element:", "").replaceAll("\\}", "");
						QueryResult<CmsElement> els = cmsElementRepository
								.getScrollData(CmsElement.class, 0, 1,
										" o.elementCode = ?1 ",
										new Object[] { elementCode });
						if (els.getResultlist() != null
								&& els.getResultlist().size() > 0) {
							CmsElement e = els.getResultlist().get(0);
							CmsContentElementOut cceo = new CmsContentElementOut();
							BeanUtils.copyProperties(e, cceo);
							cceo.setElementId(e.getId());
							cceo.setTemplate(e.getCmsElementTemplate() != null ? e
									.getCmsElementTemplate().getTemplate()
									: null);
							QueryResult<CmsElementLang> elr = cmsElementLangRepository
									.getScrollData(
											CmsElementLang.class,
											0,
											1,
											" o.cmsPage = ?1 and o.cmsElement = ?2 and o.langId = ?3 ",
											new Object[] { cmsPage, e, langId });
							System.out.println("cmsPage:"+cmsPage.getId()+"element:"+e.getId()+"langId:"+langId+"size:"+elr.getResultlist().size());
							if (elr.getResultlist() != null
									&& elr.getResultlist().size() > 0) {
								CmsElementLang el = elr.getResultlist().get(0);
								try {
									cceo.setContent((List<Map<String, String>>) JacksonJsonUtil
											.jsonToBean(el.getContent(), List.class));
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							elements.add(cceo);
						}
					}
					ccp.setElements(elements);
				}
			}
			return ccp;
		}
		return null;
	}

	@Override
	public void saveContentOfOnePage(CmsContentPageIn cmsContentPageIn) {
		// TODO Auto-generated method stub
		CmsPage cp = cmsPageRepository.find(CmsPage.class,
				cmsContentPageIn.getPageId());
		for (CmsContentElementIn cceL : cmsContentPageIn.getContent()) {
			CmsElement ce = cmsElementRepository.find(CmsElement.class,
					cceL.getElementId());
			CmsElementLang cel = new CmsElementLang();
			cel.setCmsElement(ce);
			cel.setCmsPage(cp);
			cel.setLangId(cmsContentPageIn.getLangId());
			try {
				cel.setContent(JacksonJsonUtil.beanToJson(cceL.getContent()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cmsElementLangRepository.save(cel);
		}

	}

	public static void main(String[] args) {
		String bc = "<div>${txt1:textarea}abc${txt2:textarea}def<div>element1-txt1abc${txt2:textarea}</div></div> ";;
		bc =bc.replaceFirst("${txt2:textarea}".replace("$", "\\$").replace("{", "\\{").replace("}", "\\}"), "ttt");

		System.out.println(bc);
	}

	@Override
	public void updatePageStatus(CmsPageSimpleDto cmsPageSimpleDto) {
		// TODO Auto-generated method stub
		CmsPage cs = cmsPageRepository.find(CmsPage.class, cmsPageSimpleDto.getId());
		if(cs!=null){
			cs.setStatus(cmsPageSimpleDto.getStatus());
			cmsPageRepository.update(cs);
		}
	}

	

}
