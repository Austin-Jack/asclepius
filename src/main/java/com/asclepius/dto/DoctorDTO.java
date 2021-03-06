package com.asclepius.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author sny
 * @CreateTime 2022-07-01  15:54
 * @Description TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO implements Serializable {
    private Integer docId;

    private String docName;

    private Integer docSex;

    private Integer docRank;

    private String docImage;

    private String docDetail;
}
