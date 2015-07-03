package net.sharesuite.cms.backend.dto;

import java.io.Serializable;

/**
 * @ClassName: CmsElementTemplate
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:05:44 AM
 * 
 */

public class CmsElementTemplateDto implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String template;

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
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template
	 *            the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

}
