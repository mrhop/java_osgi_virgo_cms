package net.sharesuite.cms.backend.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CmsContentElementIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer elementId;
	private List<Map<String, String>> content;

	public Integer getElementId() {
		return elementId;
	}

	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}

	public List<Map<String, String>> getContent() {
		return content;
	}

	public void setContent(List<Map<String, String>> content) {
		this.content = content;
	}

}
