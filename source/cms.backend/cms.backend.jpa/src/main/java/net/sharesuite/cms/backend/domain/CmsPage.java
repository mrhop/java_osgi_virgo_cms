package net.sharesuite.cms.backend.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** 
* @ClassName: CmsPage 
* @Description: TODO
* @author East Huo donghui.huo@eurosinoinvest.com   
* @date Jun 8, 2015 9:05:49 AM 
*  
*/
@Entity
@Table(name="cms_page")
public class CmsPage implements Serializable {
	
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
	
	@ManyToOne  
    @JoinColumn(name="parent_page_id",referencedColumnName="id")  
	private CmsPage parentPage;
	
	@ManyToOne  
    @JoinColumn(name="website_id",referencedColumnName="id")  
	private CmsWebsite cmsWebsite;
	
	@ManyToOne  
    @JoinColumn(name="page_template_id",referencedColumnName="id")  
	private CmsPageTemplate cmsPageTemplate;
	
	@Column(name="status")
	private Boolean status;
	
	@OneToMany(mappedBy = "parentPage")
	private List<CmsPage> childrenPages;
	
	@OneToMany(mappedBy = "cmsPage")
	private Set<CmsPageLang> cmsPageLang;
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
	 * @return the parentPage
	 */
	public CmsPage getParentPage() {
		return parentPage;
	}
	/**
	 * @param parentPage the parentPage to set
	 */
	public void setParentPage(CmsPage parentPage) {
		this.parentPage = parentPage;
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
	 * @return the cmsPageTemplate
	 */
	public CmsPageTemplate getCmsPageTemplate() {
		return cmsPageTemplate;
	}
	/**
	 * @param cmsPageTemplate the cmsPageTemplate to set
	 */
	public void setCmsPageTemplate(CmsPageTemplate cmsPageTemplate) {
		this.cmsPageTemplate = cmsPageTemplate;
	}
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	

	public List<CmsPage> getChildrenPages() {
		return childrenPages;
	}
	public void setChildrenPages(List<CmsPage> childrenPages) {
		this.childrenPages = childrenPages;
	}

}
