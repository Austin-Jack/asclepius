package com.asclepius.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author sny
 * @CreateTime 2022-07-01  16:01
 * @Description TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorScheduleDTO implements Serializable {
	private String dName;

	private Integer cLevel;

	private String docName;

	private Integer docRank;

	private Float apCost;

	List<ScheduleTime> times;

	public String getdName() {
		return this.dName;
	}

	public Integer getcLevel() {
		return this.cLevel;
	}

	public static class ScheduleTime {
		private Integer sId;

		private Long time;

		public Integer getsId() {
			return sId;
		}

		public void setsId(Integer sId) {
			this.sId = sId;
		}

		public Long getTime() {
			return time;
		}

		public void setTime(Long time) {
			this.time = time;
		}
	}
}
