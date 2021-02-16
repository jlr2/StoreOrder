package org.iesvalleinclan.storeorder.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {
    @Id
    private String id;
    private String city;
    private String zipCode;
    private String address;
}
