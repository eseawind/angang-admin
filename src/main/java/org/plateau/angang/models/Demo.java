package org.plateau.angang.models;

import java.io.Serializable;

public class Demo implements Serializable {
	
	private static final long serialVersionUID = 971789108210145098L;

	private int id;
	
	private String name;
	
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
