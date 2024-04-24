package com.example.Shop.mapper;

import com.example.Shop.Cart;
import com.example.Shop.CartItem;
import com.example.Shop.model.order.Order;
import com.example.Shop.model.order.OrderItem;
import com.example.Shop.transferObject.OrderDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    /* Mapper, który przepisuje obiekty */

    public static Order mapToOrder(OrderDto orderDto){
        return Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postCode(orderDto.getPostCode())
                .city(orderDto.getCity())
                .created(LocalDateTime.now())
                .build();

    }
    public static List<OrderItem> mapToOrderItemList(Cart cart, Order order){
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem ci: cart.getCartItems()) {
            orderItems.add(new OrderItem(order.getOrderId(), ci.getItem().getId(), ci.getCounter()));
        }
        return orderItems;
    }
}
