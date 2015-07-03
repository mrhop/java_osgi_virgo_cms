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
* @ClassName: CmsPageLang 
* @Description: TODO
* @author East Huo donghui.huo@eurosinoinvest.com   
* @date Jun 8, 2015 9:05:41 AM 
*  
*/
@Entity
@Table(name="cms_page_lang")
public class CmsPageLang  implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="id",insertable=false)
	private Integer id;
	@Column(name="lang_id")
	private Integer langId;
	@ManyToOne  
    @JoinColumn(name="page_id",referencedColumnName="id") 
	private CmsPage cmsPage;
	@Column(name="title")
	private String title;
	@Column(name="keywords")
	private String keywords;
	@Column(name="page_url")
	private String pageUrl;
	@Column(name="description")
	private String description;
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
	 * @return the langId
	 */
	public Integer getLangId() {
		return langId;
	}
	/**
	 * @param langId the langId to set
	 */
	public void setLangId(Integer langId) {
		this.langId = langId;
	}
	/**
	 * @return the cmsPage
	 */
	public CmsPage getCmsPage() {
		return cmsPage;
	}
	/**
	 * @param cmsPage the cmsPage to set
	 */
	public void setCmsPage(CmsPage cmsPage) {
		this.cmsPage = cmsPage;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * @return the pageUrl
	 */
	public String getPageUrl() {
		return pageUrl;
	}
	/**
	 * @param pageUrl the pageUrl to set
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
