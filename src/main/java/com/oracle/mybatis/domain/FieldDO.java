package com.oracle.mybatis.domain;

public class FieldDO {
	private String fieldOne;
	private String fieldTwo;
	
	public FieldDO() {
		super();
	}

	public FieldDO(String fieldOne, String fieldTwo) {
		super();
		this.fieldOne = fieldOne;
		this.fieldTwo = fieldTwo;
	}

	public String getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	@Override
	public String toString() {
		return "Field [fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo + "]";
	}
	
	
	
	
}
