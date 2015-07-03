package net.sharesuite.cms.backend.action;


import net.sharesuite.cms.backend.dto.CmsPageTemplateDto;
import net.sharesuite.cms.backend.service.CmsPageTemplateService;
import net.sharesuite.cms.backend.vo.JsonResult;
import net.sharesuite.cms.backend.vo.JsonResultSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pagetemplate")
public class CmsPageTemplateAction {
	
	@Autowired
	private CmsPageTemplateService cmsPageTemplateService;
	
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public JsonResult getPageTemplates(int websiteId) {
		return new JsonResult(true,cmsPageTemplateService.getPageTemplates(websiteId));
	}
	
	@ResponseBody
	@RequestMapping(value = "/single", method = RequestMethod.GET)
	public JsonResult getPage(int id) {
		return new JsonResult(true,cmsPageTemplateService.getPageTemplate(id));
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonResultSimple savePage(@RequestBody CmsPageTemplateDto cmsPageTemplateDto) {
		cmsPageTemplateService.createPageTemplate(cmsPageTemplateDto);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public JsonResultSimple updatePage(
			@RequestBody CmsPageTemplateDto cmsPageTemplateDto) {
		cmsPageTemplateService.updatePageTemplate(cmsPageTemplateDto);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonResultSimple deletePage(
			@RequestBody CmsPageTemplateDto cmsPageTemplateDto) {
		cmsPageTemplateService.deletePageTemplate(cmsPageTemplateDto);
		return new JsonResultSimple(true);
	}

}
