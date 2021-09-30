package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import pojo.CartItem;
import pojo.Order;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public Integer getLastedOrderId() {
        return orderDao.getLastedOrderId();
    }

    @Override
    public void addOrderItem(List<CartItem> cartOfUserId, Integer orderId) {
        orderDao.addOrderItem(cartOfUserId, orderId);
    }

    @Override
    public List<Order> getMyOrder(Integer userId) {
        return orderDao.getMyOrder(userId);
    }
}
