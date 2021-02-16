package org.iesvalleinclan.storeorder.controller;

import org.iesvalleinclan.storeorder.controller.constant.EndPointUris;
import org.iesvalleinclan.storeorder.model.dto.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(EndPointUris.ORDERS)
public interface OrderApi {

    @CrossOrigin
    @PostMapping
    ResponseEntity<OrderDTO> create(@Valid @RequestBody final OrderDTO orderDTO);

    @PutMapping(EndPointUris.ORDER)
    ResponseEntity<OrderDTO> update(@PathVariable final String reference, @Valid @RequestBody final OrderDTO orderDTO);

    @GetMapping
    ResponseEntity<List<OrderDTO>> getAll();

}
