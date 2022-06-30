package com.asclepius.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: sny
 * @CreateTime: 2022-06-30  15:34
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private Integer cId;

    private Integer uId;

    private String identityID;

    private Integer sex;

    private Integer age;

    private String name;

    private String telNumber;

}
