package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmbmsUser {
    private Integer id;

    private String userPassword;

    private String userCode;

    private String userName;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String address;

    private Integer userRole;

    private Integer createBy;

    private Date creationDate;

    private Integer modifyBy;

    private Date modifyDate;

    private  SmbmsRole smbmsRole;

}
