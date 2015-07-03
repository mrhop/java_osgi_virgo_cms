package net.sharesuite.cms.backend.vo;

import java.io.Serializable;

public class JsonResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JsonResult(Boolean success,Object result){
		this.success = success;
		this.result = result;
	}

	private Boolean success;
	
	private Object result;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
