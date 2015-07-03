package net.sharesuite.cms.backend.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.sharesuite.cms.backend.util.tool.UtilTool;
/**
 * @ClassName: CmsElement
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:05:31 AM
 * 
 */
@Entity
@Table(name="cms_element")
public class CmsElement implements Serializable {

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
	
	@Column(name="type")
	private Integer type;
	
	@Column(name="element_code")
	private String elementCode = UtilTool.getTimestampUniqueId();
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="element_template_id",referencedColumnName="id")    
	private CmsElementTemplate cmsElementTemplate;
	
	@ManyToOne  
    @JoinColumn(name="website_id",referencedColumnName="id")
	private CmsWebsite cmsWebsite;
	
	@OneToMany(mappedBy = "cmsElement")
	private Set<CmsElementLang> cmsElementLang;

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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getElementCode() {
		return elementCode;
	}

	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
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

	/**
	 * @return the cmsElementTemplate
	 */
	public CmsElementTemplate getCmsElementTemplate() {
		return cmsElementTemplate;
	}

	/**
	 * @param cmsElementTemplate the cmsElementTemplate to set
	 */
	public void setCmsElementTemplate(CmsElementTemplate cmsElementTemplate) {
		this.cmsElementTemplate = cmsElementTemplate;
	}

	public Set<CmsElementLang> getCmsElementLang() {
		return cmsElementLang;
	}

	public void setCmsElementLang(Set<CmsElementLang> cmsElementLang) {
		this.cmsElementLang = cmsElementLang;
	}
}
