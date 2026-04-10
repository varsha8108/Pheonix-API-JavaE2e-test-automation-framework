package com.pojo;

public class problems {
	private int id;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "problems [id=" + id + ", remark=" + remark + "]";
	}
	public problems(int id, String remark) {
		super();
		this.id = id;
		this.remark = remark;
	}
	
	
	
	
	
	
	
	
	
}
