package com.hclmini.bankingapp.Dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContactDto {
    @Email
    @NotEmpty
    private String emailId;

    @NotEmpty
    private String homePhone;

    @NotNull
    private String workPhone;
}
