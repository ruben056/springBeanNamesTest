package be.rd.beans;

import org.springframework.beans.factory.annotation.Required;

public class Bean1 {

	private String msg;

	@Required
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg(){
		return this.msg;
	}
}
