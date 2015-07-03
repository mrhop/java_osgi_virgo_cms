package net.sharesuite.cms.backend.dto;

import java.io.Serializable;

/**
 * @ClassName: CmsElementLang
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:05:38 AM
 * 
 */
public class CmsElementLangDto implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer langId;
	private String content;
	private CmsElementDto cmsElement;
	private CmsPageDto cmsPage;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the langId
	 */
	public Integer getLangId() {
		return langId;
	}

	/**
	 * @param langId
	 *            the langId to set
	 */
	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the cmsElement
	 */
	public CmsElementDto getCmsElement() {
		return cmsElement;
	}

	/**
	 * @param cmsElement
	 *            the cmsElement to set
	 */
	public void setCmsElement(CmsElementDto cmsElement) {
		this.cmsElement = cmsElement;
	}

	public CmsPageDto getCmsPage() {
		return cmsPage;
	}

	public void setCmsPage(CmsPageDto cmsPage) {
		this.cmsPage = cmsPage;
	}

}
