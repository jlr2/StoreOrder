package org.iesvalleinclan.storeorder.controller.api;


import org.iesvalleinclan.storeorder.controller.OrderApi;
import org.iesvalleinclan.storeorder.model.dto.OrderDTO;
import org.iesvalleinclan.storeorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderApi {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<OrderDTO> create(final OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.create(orderDTO));
    }

    @Override
    public ResponseEntity<OrderDTO> update(final String reference, final OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.update(reference, orderDTO));
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
}