package com.ecommerce.order.infrastructure.rest;

import com.ecommerce.order.application.OrderApplicationService;
import com.ecommerce.order.domain.exception.DomainException;
import com.ecommerce.order.domain.model.Order;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/public/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content),
            @ApiResponse(responseCode = "500", description = "Order not saved", content = @Content)
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderCreateRequest orderCreateRequest) throws DomainException {
        this.orderApplicationService.createOrder(orderCreateRequest);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "500", description = "Order not found", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderRestResource>> getAllOrders() {
        return new ResponseEntity<>(createOrderRestResources(), HttpStatus.OK);
    }

    private List<OrderRestResource> createOrderRestResources() {
        List<Order> orders = this.orderApplicationService.findAll();
        if (orders.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        OrderRestResourceTransformer transformer = new OrderRestResourceTransformer();
        List<OrderRestResource> orderRestResources = new ArrayList<>();
        orders.forEach(order -> {
            OrderRestResource resource = transformer.toRestResource(order);
            orderRestResources.add(resource);
        });
        return orderRestResources;
    }
}
