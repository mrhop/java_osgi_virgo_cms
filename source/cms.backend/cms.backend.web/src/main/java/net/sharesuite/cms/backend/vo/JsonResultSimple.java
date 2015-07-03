package net.sharesuite.cms.backend.vo;

import java.io.Serializable;

public class JsonResultSimple implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JsonResultSimple(Boolean success){
		this.success = success;
	}

	private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
