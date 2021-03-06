package com.asclepius.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DepartmentDTO
 *
 * @author luolinyuan
 * @date 2022/7/3
 **/
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements Serializable {
	private Integer dId;

	private String name;

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public Integer getdId() {
		return dId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
