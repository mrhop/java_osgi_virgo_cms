package net.sharesuite.cms.backend.dto;

import java.io.Serializable;
import java.util.List;

public class CmsContentPageIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pageId;

	private Integer langId;

	private List<CmsContentElementIn> content;

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public Integer getLangId() {
		return langId;
	}

	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	public List<CmsContentElementIn> getContent() {
		return content;
	}

	public void setContent(List<CmsContentElementIn> content) {
		this.content = content;
	}

}
