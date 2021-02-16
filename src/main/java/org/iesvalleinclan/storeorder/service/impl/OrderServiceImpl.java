package org.iesvalleinclan.storeorder.service.impl;


import org.apache.commons.lang3.RandomStringUtils;
import org.iesvalleinclan.storeorder.model.OrderVO;
import org.iesvalleinclan.storeorder.model.dto.OrderDTO;
import org.iesvalleinclan.storeorder.repository.OrderRepository;
import org.iesvalleinclan.storeorder.service.OrderService;
import org.iesvalleinclan.storeorder.service.converter.OrderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public OrderDTO create(final OrderDTO orderDTO) {
        OrderVO orderVO = completeNewOrder(orderDTO);
        return orderConverter.convertEntityToDTO(orderRepository.insert(orderVO));
    }

    @Override
    public OrderDTO update(final String reference, final OrderDTO orderDTO) {
        OrderVO updatedOrder = Optional.ofNullable(orderRepository.findByReference(reference))
                .map(orderVO -> updateOrderData(orderDTO, orderVO))
                .orElseThrow(() ->
                        new NoSuchElementException("The order with reference=" + reference + " was not found"));

        return orderConverter.convertEntityToDTO(orderRepository.save(updatedOrder));
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream()
                .map(orderVO -> orderConverter.convertEntityToDTO(orderVO))
                .collect(Collectors.toList());
    }

    private OrderVO updateOrderData(final OrderDTO orderReceived, final OrderVO oldOrderVO) {
        OrderVO updatedOrder = calculateTotalPrice(orderReceived);
        updatedOrder.setId(oldOrderVO.getId());
        updatedOrder.setReference(oldOrderVO.getReference());
        updatedOrder.setDate(oldOrderVO.getDate());
        return updatedOrder;
    }

    private OrderVO completeNewOrder(final OrderDTO newOrderDTO) {
        OrderVO orderReceived = calculateTotalPrice(newOrderDTO);
        orderReceived.setDate(new Date());
        orderReceived.setReference(RandomStringUtils.randomAlphanumeric(8));
        return orderReceived;
    }

    private OrderVO calculateTotalPrice(final OrderDTO orderDTO) {
        OrderVO orderVO = orderConverter.convertDTOToEntity(orderDTO);
        orderVO.setTotalPrice(orderVO.getProducts().stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum());
        return orderVO;
    }

}