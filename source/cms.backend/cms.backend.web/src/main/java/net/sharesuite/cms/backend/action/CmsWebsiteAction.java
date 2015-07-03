package net.sharesuite.cms.backend.action;


import net.sharesuite.cms.backend.dto.CmsWebsiteDto;
import net.sharesuite.cms.backend.dto.CmsWebsiteSimpleDto;
import net.sharesuite.cms.backend.service.CmsWebsiteService;
import net.sharesuite.cms.backend.vo.JsonResult;
import net.sharesuite.cms.backend.vo.JsonResultSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/website")
public class CmsWebsiteAction {

	@Autowired
	private CmsWebsiteService cmsWebsiteService;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public JsonResult getWebsites() {
		return new JsonResult(true,cmsWebsiteService.getWebsites());
	}

	@ResponseBody
	@RequestMapping(value = "/single", method = RequestMethod.GET)
	public JsonResult getWebsite(int id) {
		return new JsonResult(true,cmsWebsiteService.getWebsite(id));
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonResultSimple saveWebsite(@RequestBody CmsWebsiteSimpleDto cmsWebsiteSimpleDto) {
		cmsWebsiteService.createWebsite(cmsWebsiteSimpleDto);
		return new JsonResultSimple(true);
	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public JsonResultSimple updateWebsite(
			@RequestBody CmsWebsiteSimpleDto cmsWebsiteSimpleDto) {
		cmsWebsiteService.updateWebsite(cmsWebsiteSimpleDto);
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
	public JsonResultSimple deleteWebsites(
			@RequestBody CmsWebsiteSimpleDto cmsWebsiteSimpleDto) {
		cmsWebsiteService.deleteWebsite(cmsWebsiteSimpleDto);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public JsonResultSimple updateStatus(
			@RequestBody CmsWebsiteDto cmsWebsiteDto) {
		cmsWebsiteService.updatePageStatus(cmsWebsiteDto);
		return new JsonResultSimple(true);
	}

}
