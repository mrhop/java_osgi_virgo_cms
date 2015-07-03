package net.sharesuite.cms.backend.dto;

import java.io.Serializable;

/**
 * @ClassName: CmsUser
 * @Description: TODO
 * @author East Huo donghui.huo@eurosinoinvest.com
 * @date Jun 8, 2015 9:05:56 AM
 * 
 */
public class CmsUserDto implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean privilegeContent;
	private Boolean privilegeTemplate;
	private Boolean privilegeElement;
	private Boolean privilegeUser;
	private String name;
	private Boolean status;

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
	 * @return the privilegeContent
	 */
	public Boolean getPrivilegeContent() {
		return privilegeContent;
	}

	/**
	 * @param privilegeContent
	 *            the privilegeContent to set
	 */
	public void setPrivilegeContent(Boolean privilegeContent) {
		this.privilegeContent = privilegeContent;
	}

	/**
	 * @return the privilegeTemplate
	 */
	public Boolean getPrivilegeTemplate() {
		return privilegeTemplate;
	}

	/**
	 * @param privilegeTemplate
	 *            the privilegeTemplate to set
	 */
	public void setPrivilegeTemplate(Boolean privilegeTemplate) {
		this.privilegeTemplate = privilegeTemplate;
	}

	/**
	 * @return the privilegeElement
	 */
	public Boolean getPrivilegeElement() {
		return privilegeElement;
	}

	/**
	 * @param privilegeElement
	 *            the privilegeElement to set
	 */
	public void setPrivilegeElement(Boolean privilegeElement) {
		this.privilegeElement = privilegeElement;
	}

	/**
	 * @return the privilegeUser
	 */
	public Boolean getPrivilegeUser() {
		return privilegeUser;
	}

	/**
	 * @param privilegeUser
	 *            the privilegeUser to set
	 */
	public void setPrivilegeUser(Boolean privilegeUser) {
		this.privilegeUser = privilegeUser;
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
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

}
