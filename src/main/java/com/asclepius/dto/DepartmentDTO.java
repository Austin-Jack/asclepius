package com.asclepius.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DepartmentDTO
 *
 * @author luolinyuan
 * @date 2022/7/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
	private Integer dId;

	private String dName;
}
