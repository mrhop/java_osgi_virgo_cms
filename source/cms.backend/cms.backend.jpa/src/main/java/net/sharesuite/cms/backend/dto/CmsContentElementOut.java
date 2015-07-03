package net.sharesuite.cms.backend.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CmsContentElementOut implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer elementId;

	private String name;

	private Integer type;

	private String template;

	private String elementCode;

	private List<Map<String,String>> content;

	public Integer getElementId() {
		return elementId;
	}

	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}

	public List<Map<String,String>> getContent() {
		return content;
	}

	public void setContent(List<Map<String,String>> content) {
		this.content = content;
	}

}
