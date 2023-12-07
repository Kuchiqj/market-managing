package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class SmbmsBill {
    private Integer id;

    private String billCode;

    private String productName;

    private String productDesc;

    private String productUnit;

    private BigDecimal productCount;

    private BigDecimal totalPrice;

    private Integer isPayment;

    private Integer createdBy;

    private Integer providerId;

    private Date creationDate;

 private SmbmsProvider smbmsProvider;
}
