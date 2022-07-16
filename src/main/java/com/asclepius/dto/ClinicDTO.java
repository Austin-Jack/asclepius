package com.asclepius.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ClinicDTO
 *
 * @author luolinyuan
 * @date 2022/7/3
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicDTO implements Serializable {
	public String cliName;

	public List<DepartmentDTO> departments;
}
