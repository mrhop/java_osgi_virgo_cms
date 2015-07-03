package net.sharesuite.cms.backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 
* @ClassName: CmsWebsiteConfig 
* @Description: TODO
* @author East Huo donghui.huo@eurosinoinvest.com   
* @date Jun 8, 2015 9:06:33 AM 
*  
*/
@Entity
@Table(name="cms_website_config")
public class CmsWebsiteConfig implements Serializable  {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",insertable=false)
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="websiteId")
	private String websiteId;
	@ManyToOne  
    @JoinColumn(name="website_id",referencedColumnName="id") 
	private CmsWebsite cmsWebsite;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
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
	 * @param username the username to set
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
	 * @param password the password to set
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
	 * @param websiteId the websiteId to set
	 */
	public void setWebsiteId(String websiteId) {
		this.websiteId = websiteId;
	}
	public CmsWebsite getCmsWebsite() {
		return cmsWebsite;
	}
	public void setCmsWebsite(CmsWebsite cmsWebsite) {
		this.cmsWebsite = cmsWebsite;
	}

	
	
}
