package net.sharesuite.cms.backend.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	@RequestMapping("/index")
	public void index() {
		//just return
	}
}
