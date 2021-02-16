package org.iesvalleinclan.storeorder.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Order")

public class OrderVO {
    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private Date date;
    private Double totalPrice;
    private UserVO user;
    private AddressVO shippingAddress;
    private OrderStatusVO status;

    // atributo de relación para saber los productos del pedido
    private List<OrderedProductVO> products;
}