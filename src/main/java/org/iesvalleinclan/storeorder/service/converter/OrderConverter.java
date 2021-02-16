package org.iesvalleinclan.storeorder.service.converter;

import org.iesvalleinclan.storeorder.model.OrderStatusVO;
import org.iesvalleinclan.storeorder.model.OrderVO;
import org.iesvalleinclan.storeorder.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderConverter {

    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private OrderedProductConverter orderedProductConverter;

    public OrderDTO convertEntityToDTO(final OrderVO orderVO) {

        return OrderDTO.builder()
                .shippingAddress(addressConverter.convertEntityToDTO(orderVO.getShippingAddress()))
                .user(userConverter.convertEntityToDTO(orderVO.getUser()))
                .products(orderVO.getProducts().stream()
                        .map(orderedProductVO -> orderedProductConverter.convertEntityToDTO(orderedProductVO))
                        .collect(Collectors.toList()))
                .date(orderVO.getDate())
                .totalPrice(orderVO.getTotalPrice())
                .reference(orderVO.getReference()).status(orderVO.getStatus().getValue()).build();
    }

    public OrderVO convertDTOToEntity(final OrderDTO orderDTO) {

        return OrderVO.builder().shippingAddress(addressConverter.convertDTOToEntity(orderDTO.getShippingAddress()))
                .user(userConverter.convertDTOToEntity(orderDTO.getUser()))
                .products(orderDTO.getProducts().stream()
                        .map(orderedProductDTO -> orderedProductConverter.convertDTOToEntity(orderedProductDTO))
                        .collect(Collectors.toList()))
                .date(orderDTO.getDate())
                .totalPrice(orderDTO.getTotalPrice())
                .reference(orderDTO.getReference()).status(OrderStatusVO.valueOf(orderDTO.getStatus())).build();
    }
}
