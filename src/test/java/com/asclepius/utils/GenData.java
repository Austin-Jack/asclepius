package com.asclepius.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.read.listener.PageReadListener;
import com.asclepius.mapper.ClinicMapper;
import com.asclepius.mapper.DepartmentMapper;
import com.asclepius.mapper.DoctorMapper;
import com.asclepius.pojo.Clinic;
import com.asclepius.pojo.Department;
import com.asclepius.pojo.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;


/**
 * 生成医院基本数据！
 *
 * @author luolinyuan
 * @date 2022/7/5
 **/
@SpringBootTest
@Ignore
@Deprecated
@RunWith(SpringRunner.class)
public class GenData {
	@Autowired
	DataSourceTransactionManager manager;


	@Resource
	DoctorMapper doctorMapper;

	@Resource
	DepartmentMapper departmentMapper;

	@Resource
	ClinicMapper clinicMapper;

	private static final String PATH_PREFIX = "doctor-data";

	private static final String EXCEL_PATH = PATH_PREFIX + File.separator + "doctorData.xlsx";

	private static final HashSet<ExcelDoctor> doctors = new HashSet<>(512);


	static {
		EasyExcel.read(EXCEL_PATH, ExcelDoctor.class, new PageReadListener<ExcelDoctor>(doctors::addAll)).sheet().doRead();
	}


	@Test
	public void insertData() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(Propagation.REQUIRED.value());
		definition.setIsolationLevel(Isolation.SERIALIZABLE.value());
		TransactionStatus status = manager.getTransaction(definition);
		try {
			insertClinic();
			insertDepartment();
			insertDoctor();
			manager.commit(status);
		} catch (Exception e) {
			manager.rollback(status);
		}
	}

	public void insertClinic() {
		HashMap<Integer, String> clinicMap = new HashMap<>();
		for (ExcelDoctor doctor : doctors) {
			clinicMap.put(doctor.getClinicId(), doctor.getClinicName());
		}
		clinicMap.forEach((integer, s) -> {
			Clinic clinic = new Clinic();
			clinic.setCliLevel(0);
			clinic.setCliId(integer);
			clinic.setCliName(s);
			clinicMapper.insert(clinic);
		});
	}

	public void insertDepartment() {
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		for (ExcelDoctor doctor : doctors) {
			map.put(doctor.getDepartmentName(), doctor.getClinicId());
			map2.put(doctor.getDepartmentName(), doctor.getDepartmentId());
		}
		map.forEach((name, id) -> {
			Department department = new Department();
			department.setCliId(id);
			department.setdId(map2.get(name));
			department.setdName(name);
			departmentMapper.insert(department);
		});
	}

	public void insertDoctor() {
		for (ExcelDoctor tmpDoc : doctors) {
			Doctor doctor = new Doctor();
			doctor.setdId(tmpDoc.getDepartmentId());
			doctor.setDocDetail(tmpDoc.getDetail());
			String imagePath = tmpDoc.getImagePath();
			doctor.setDocImage("/doctor" + imagePath.substring(imagePath.lastIndexOf("/")));
			doctor.setDocName(tmpDoc.getDoctorName());
			String rank = tmpDoc.getRank();
			int rankNum = 0;
			if (rank.contains("教授")) {
				rankNum = 2;
			} else if (rank.contains("副主任")) {
				rankNum = 1;
			}
			doctor.setDocRank(rankNum);
			doctorMapper.insert(doctor);
		}
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ExcelDoctor {

		@ExcelProperty("clinicId")
		private Integer clinicId;

		@ExcelProperty("clinicName")
		private String clinicName;

		@ExcelProperty("departmentId")
		private Integer departmentId;

		@ExcelProperty("doctorName")
		private String doctorName;

		@ExcelProperty("departmentName")
		private String departmentName;

		@ExcelProperty("imagePath")
		private String imagePath;

		@ExcelProperty("rank")
		private String rank;

		@ExcelProperty("detail")
		private String detail;
	}
}
