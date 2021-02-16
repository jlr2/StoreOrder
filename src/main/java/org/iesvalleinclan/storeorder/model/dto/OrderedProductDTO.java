package org.iesvalleinclan.storeorder.model.dto;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProductDTO {
    @NotBlank(message = "The product introduced is not correct")
    private String reference;
    @NotNull(message = "The product introduced is not correct")
    private Double price;
    @Min(value = 1, message = "The quantity must be 1 or more")
    private int quantity;
}

