package service;

import pojo.CartItem;
import pojo.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);

    Integer getLastedOrderId();

    void addOrderItem(List<CartItem> cartOfUserId, Integer orderId);

    List<Order> getMyOrder(Integer userId);
}
