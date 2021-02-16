package org.iesvalleinclan.storeorder.model.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    @NotBlank(message = "City cannot be empty")
    private String city;
    @NotBlank(message = "Zipcode cannot be empty")
    private String zipCode;
    @NotBlank(message = "Address cannot be empty")
    private String address;
}