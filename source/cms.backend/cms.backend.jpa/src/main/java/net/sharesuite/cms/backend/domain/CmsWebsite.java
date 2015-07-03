package net.sharesuite.cms.backend.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @ClassName: CmsWebsite
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:06:00 AM
 * 
 */
@Entity
@Table(name = "cms_website")
public class CmsWebsite implements Serializable {

	public CmsWebsite() {
	};

	public CmsWebsite(Integer id) {
		this.id = id;
	};

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "base_url")
	private String baseUrl;

	@Column(name = "status")
	private Boolean status;

	@OneToMany(mappedBy = "cmsWebsite")
	private Set<CmsPage> cmsPages;

	@OneToMany(mappedBy = "cmsWebsite")
	private Set<CmsElement> cmsElements;

	@OneToMany(mappedBy = "cmsWebsite")
	private Set<CmsPageTemplate> cmsPageTemplates;

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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<CmsPage> getCmsPages() {
		return cmsPages;
	}

	public void setCmsPages(Set<CmsPage> cmsPages) {
		this.cmsPages = cmsPages;
	}

	public Set<CmsElement> getCmsElements() {
		return cmsElements;
	}

	public void setCmsElements(Set<CmsElement> cmsElements) {
		this.cmsElements = cmsElements;
	}

	public Set<CmsPageTemplate> getCmsPageTemplates() {
		return cmsPageTemplates;
	}

	public void setCmsPageTemplates(Set<CmsPageTemplate> cmsPageTemplates) {
		this.cmsPageTemplates = cmsPageTemplates;
	}

}
