package net.sharesuite.cms.backend.dto;

import java.io.Serializable;

/**
 * @ClassName: CmsWebsite
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:06:00 AM
 * 
 */

public class CmsWebsiteDto implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String baseUrl;
	private Boolean status;
	private Long count_pages = 0l;
	private Long count_elements = 0l;
	private Long count_templates = 0l;


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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl
	 *            the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Long getCount_pages() {
		return count_pages;
	}

	public void setCount_pages(Long count_pages) {
		this.count_pages = count_pages;
	}

	public Long getCount_elements() {
		return count_elements;
	}

	public void setCount_elements(Long count_elements) {
		this.count_elements = count_elements;
	}

	public Long getCount_templates() {
		return count_templates;
	}

	public void setCount_templates(Long count_templates) {
		this.count_templates = count_templates;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
