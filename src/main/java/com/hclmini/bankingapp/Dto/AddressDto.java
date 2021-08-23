package com.hclmini.bankingapp.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
}
