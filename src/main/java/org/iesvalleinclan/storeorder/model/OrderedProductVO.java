package org.iesvalleinclan.storeorder.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProductVO {
    private String reference;
    private Double price;
    private int quantity;
}
