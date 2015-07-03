package net.sharesuite.cms.backend.dto;

import java.io.Serializable;

/**
 * @ClassName: CmsWebsiteConfig
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:06:33 AM
 * 
 */
public class CmsWebsiteConfig implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String websiteId;
	private CmsWebsiteDto cmsWebsite;

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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the websiteId
	 */
	public String getWebsiteId() {
		return websiteId;
	}

	/**
	 * @param websiteId
	 *            the websiteId to set
	 */
	public void setWebsiteId(String websiteId) {
		this.websiteId = websiteId;
	}

	public CmsWebsiteDto getCmsWebsite() {
		return cmsWebsite;
	}

	public void setCmsWebsite(CmsWebsiteDto cmsWebsite) {
		this.cmsWebsite = cmsWebsite;
	}

}
