/**
 * 
 */
package com.my.reports.base.entity;

import java.io.Serializable;

/**
 * @author MustafaS.
 *
 */
public class ServiceResult implements Serializable{

	private static final long serialVersionUID = -9185982452428371232L;
	
	private Object data;
	private String[] messages;
	
	public ServiceResult(){}
	
	public ServiceResult(Object data){
		this.data = data;
	}
	
	public ServiceResult(Object data, String... messages){
		this(data);
		this.messages = messages;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}
	
	
	
}
