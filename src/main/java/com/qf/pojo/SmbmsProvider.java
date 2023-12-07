package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class SmbmsProvider {
    private Integer id;

    private String proCode;

    private String proName;

    private String proDesc;

    private String proContact;

    private String proPhone;

    private String proAddress;

    private String proFax;

    private Integer createdBy;

    private Date creationDate;

    private Date modifyDate;

    private Integer modifyBy;
}
