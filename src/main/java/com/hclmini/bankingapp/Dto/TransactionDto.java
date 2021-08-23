package com.hclmini.bankingapp.Dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransactionDto {
    private Long accountNumber;

    private Date txDateTime;

    private String txType;

    private Double txAmount;
}
