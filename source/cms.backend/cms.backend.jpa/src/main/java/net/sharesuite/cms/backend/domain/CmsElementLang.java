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
 * @ClassName: CmsElementLang
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:05:38 AM
 * 
 */
@Entity
@Table(name = "cms_element_lang")
public class CmsElementLang implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false)
	private Integer id;
	@Column(name = "lang_id")
	private Integer langId;
	@Column(name = "content")
	private String content;
	@ManyToOne
	@JoinColumn(name = "element_id", referencedColumnName = "id")
	private CmsElement cmsElement;
	@ManyToOne
	@JoinColumn(name = "page_id", referencedColumnName = "id")
	private CmsPage cmsPage;

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
	public CmsElement getCmsElement() {
		return cmsElement;
	}

	/**
	 * @param cmsElement
	 *            the cmsElement to set
	 */
	public void setCmsElement(CmsElement cmsElement) {
		this.cmsElement = cmsElement;
	}

	public CmsPage getCmsPage() {
		return cmsPage;
	}

	public void setCmsPage(CmsPage cmsPage) {
		this.cmsPage = cmsPage;
	}

}
