package net.sharesuite.cms.backend.dto;

import java.io.Serializable;
import java.util.List;

public class CmsContentPageOut implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String template;

	private List<CmsContentElementOut> elements;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public List<CmsContentElementOut> getElements() {
		return elements;
	}

	public void setElements(List<CmsContentElementOut> elements) {
		this.elements = elements;
	}

}
