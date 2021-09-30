package dao.impl;

import dao.OrderDao;
import pojo.CartItem;
import pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public void createOrder(Order order) {
        String sql = "insert into t_order(userId, status, amount, orderTime) values(?,?,?,?)";
        update(sql, order.getUserId(), order.getStatus(), order.getAmount(), order.getTimestamp());
    }

    @Override
    public Integer getLastedOrderId() {
        String sql = "select orderId from t_order order by orderId desc limit 1";
        return (Integer) querySingleValue(sql);
    }

    @Override
    public void addOrderItem(List<CartItem> cartOfUserId, Integer orderId) {
        for (CartItem cartItem : cartOfUserId) {
            String sql = "insert into t_orderItem(orderId, name, quantity, price, bookId, userId) values(?, ?, ?, ?, ?, ?) ";
            update(sql, orderId, cartItem.getName(), cartItem.getQuantity(), cartItem.getPrice(), cartItem.getBookId(), cartItem.getUserId());
        }
    }

    @Override
    public List<Order> getMyOrder(Integer userId) {
        String sql = "select orderId, status, amount, orderTime from t_order where userId = ?";
        return queryForList(Order.class, sql, userId);
    }
}
