package com.hclmini.bankingapp.Dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {
     @NotEmpty(message = "Please Fill the Address")
    private String address1;
    @NotEmpty(message = "Please fill Complete Address")
    private String address2;
    @NotEmpty(message = "enter the City name")
    private String city;
    @NotEmpty(message = "Enter the State Name.")
    private String state;
    @NotEmpty(message = "Enter the Zip code")
    private String zip;
    @NotEmpty(message = "Enter the Country.")
    private String country;
}
