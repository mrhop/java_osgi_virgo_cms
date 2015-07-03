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
* @ClassName: CmsPageTemplate 
* @Description: TODO
* @author East Huo donghui.huo@eurosinoinvest.com   
* @date Jun 8, 2015 9:05:54 AM 
*  
*/
@Entity
@Table(name="cms_page_template")
public class CmsPageTemplate implements Serializable  {
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id",insertable=false)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="template")
	private String template;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
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
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	/**
	 * @return the cmsWebsite
	 */
	public CmsWebsite getCmsWebsite() {
		return cmsWebsite;
	}
	/**
	 * @param cmsWebsite the cmsWebsite to set
	 */
	public void setCmsWebsite(CmsWebsite cmsWebsite) {
		this.cmsWebsite = cmsWebsite;
	}
	
	
	
}
