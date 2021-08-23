package com.hclmini.bankingapp.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContactDto {
    private String emailId;

    private String homePhone;

    private String workPhone;
}
