package org.iesvalleinclan.storeorder.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String reference;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date date;
    private Double totalPrice;
    @Valid
    @NotNull(message = "The user data cannot be empty")
    private UserDTO user;
    @Valid
    @NotNull(message = "The shipping address cannot be empty")
    private AddressDTO shippingAddress;
    @NotEmpty(message = "The order is empty!")
    private List<@Valid OrderedProductDTO> products;
    private Integer status = 0;
}
