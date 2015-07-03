package net.sharesuite.cms.backend.action;

import net.sharesuite.cms.backend.dto.CmsContentPageIn;
import net.sharesuite.cms.backend.dto.CmsPageDto;
import net.sharesuite.cms.backend.dto.CmsPageSimpleDto;
import net.sharesuite.cms.backend.service.CmsPageService;
import net.sharesuite.cms.backend.vo.JsonResult;
import net.sharesuite.cms.backend.vo.JsonResultSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/page")
public class CmsPageAction {

	@Autowired
	private CmsPageService cmsPageService;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public JsonResult getPages(int websiteId) {
		return new JsonResult(true,cmsPageService.getPages(websiteId));
	}

	@ResponseBody
	@RequestMapping(value = "/single", method = RequestMethod.GET)
	public JsonResult getPage(int id) {
		return new JsonResult(true,cmsPageService.getPage(id));
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonResultSimple savePage(@RequestBody CmsPageDto cmsPageDto) {
		cmsPageService.createPage(cmsPageDto);
		return new JsonResultSimple(true);
	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public JsonResultSimple updatePage(
			@RequestBody CmsPageDto cmsPageDto) {
		cmsPageService.updatePage(cmsPageDto);
		return new JsonResultSimple(true);
	}

	// just use get
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/delete",method = RequestMethod.GET) public void
	 * deleteWebsites(int id) { CmsWebsiteSimpleDto csd = new
	 * CmsWebsiteSimpleDto(); csd.setId(id);
	 * cmsElementService.deleteWebsite(csd);; }
	 */

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonResultSimple deletePage(
			@RequestBody CmsPageSimpleDto cmsPageSimpleDto) {
		cmsPageService.deletePage(cmsPageSimpleDto);
		return new JsonResultSimple(true);
	}

	@ResponseBody
	@RequestMapping(value = "/parsePage", method = RequestMethod.GET)
	public JsonResult parsePage(Integer id,Integer langId) {
		return new JsonResult(true,cmsPageService.formatPage(id, langId));
	}
	
	@ResponseBody
	@RequestMapping(value = "/getContent", method = RequestMethod.GET)
	public JsonResult getContent(Integer id,Integer langId) {
		return new JsonResult(true,cmsPageService.getContentByPageIdAndLangId(id, langId));
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveContent", method = RequestMethod.POST)
	public JsonResultSimple savePage(@RequestBody CmsContentPageIn cmsContentPageIn) {
		cmsPageService.saveContentOfOnePage(cmsContentPageIn);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public JsonResultSimple updateStatus(@RequestBody CmsPageSimpleDto cmsPageSimpleDto) {
		cmsPageService.updatePageStatus(cmsPageSimpleDto);
		return new JsonResultSimple(true);
	}


}
