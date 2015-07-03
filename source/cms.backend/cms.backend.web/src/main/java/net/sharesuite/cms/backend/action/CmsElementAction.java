package net.sharesuite.cms.backend.action;


import net.sharesuite.cms.backend.dto.CmsElementDto;
import net.sharesuite.cms.backend.dto.CmsElementSimpleDto;
import net.sharesuite.cms.backend.service.CmsElementService;
import net.sharesuite.cms.backend.vo.JsonResult;
import net.sharesuite.cms.backend.vo.JsonResultSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/element")
public class CmsElementAction {
	
	@Autowired
	private CmsElementService cmsElementService;
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public JsonResult getElements(int websiteId) {
		return new JsonResult(true,cmsElementService.getElements(websiteId));
	}
	
	@ResponseBody
	@RequestMapping(value = "/single", method = RequestMethod.GET)
	public JsonResult getElement(int id) {
		return new JsonResult(true,cmsElementService.getElement(id));
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonResultSimple saveElement(@RequestBody CmsElementDto cmsElementDto) {
		cmsElementService.createElement(cmsElementDto);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public JsonResultSimple updateElement(
			@RequestBody CmsElementDto cmsElementDto) {
		cmsElementService.updateElement(cmsElementDto);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonResultSimple deleteElement(
			@RequestBody CmsElementSimpleDto cmsElementSimpleDto) {
		cmsElementService.deleteElement(cmsElementSimpleDto);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveb", method = RequestMethod.POST)
	public JsonResultSimple saveElementB(@RequestBody CmsElementDto cmsElementDto) {
		cmsElementService.createElementB(cmsElementDto);
		return new JsonResultSimple(true);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateb", method = RequestMethod.POST)
	public JsonResultSimple updateElementB(
			@RequestBody CmsElementDto cmsElementDto) {
		cmsElementService.updateElementB(cmsElementDto);
		return new JsonResultSimple(true);
	}
}
