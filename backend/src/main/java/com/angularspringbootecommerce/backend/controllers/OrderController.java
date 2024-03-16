package com.angularspringbootecommerce.backend.controllers;

import com.angularspringbootecommerce.backend.dtos.CartDto;
import com.angularspringbootecommerce.backend.dtos.OrderDto;
import com.angularspringbootecommerce.backend.dtos.PaymentDto;
import com.angularspringbootecommerce.backend.models.Order;
import com.angularspringbootecommerce.backend.models.OrderItem;
import com.angularspringbootecommerce.backend.models.Product;
import com.angularspringbootecommerce.backend.services.CartService;
import com.angularspringbootecommerce.backend.services.OrderService;
import com.angularspringbootecommerce.backend.services.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;
    private final PaymentService paymentService;

    @GetMapping("/{userId}")
    public List<OrderDto> getOrdersByUserId(@PathVariable Long userId, Authentication authentication) {
        return orderService.getOrdersByUserId(userId, authentication);
    }

    @GetMapping("/all")
    public List<OrderDto> getOrdersAll() {
        return orderService.getOrdersAll();
    }

    @PostMapping("/checkout")
    public ResponseEntity<PaymentDto> checkout(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam Long number,
            @RequestParam Long userId,
            Authentication authentication) throws StripeException {
        String addresss=address;
        System.out.println("------------------------------------------"+addresss);
        CartDto cart = cartService.getCartByUserId(userId);
        BigDecimal totalPrice = cart.getTotalPrice();
        PaymentIntent paymentIntent = paymentService.createPaymentIntent(totalPrice);
        System.out.println("------------------------------------------"+address);
        System.out.println("------------------------------------------"+name);
        Order createdOrder = orderService.createOrderFromCart(cart,name,address,number, userId, authentication);

        cartService.clearCart(userId);

        PaymentDto paymentDto = new PaymentDto(paymentIntent.getClientSecret(), totalPrice, "usd", createdOrder.getId());

        return ResponseEntity.ok().body(paymentDto);
    }
}
