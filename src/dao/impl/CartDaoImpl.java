package dao.impl;

import dao.CartDao;
import pojo.CartItem;

import java.math.BigDecimal;
import java.util.List;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public List<CartItem> cart(Integer userId) {
        String sql = "select id, name, quantity, bookId, price, userId from t_cart where userId = ?";
        return queryForList(CartItem.class, sql, userId);
    }

    /**
     * 根据userId 和 bookId ，查询用户该书的数量，如果查询成功的话，就返回该数量，否则返回-1
     *
     * @param userId
     * @param bookId
     * @return
     */
    @Override
    public int queryCertainBook(Integer userId, Integer bookId) {
        String sql = "select quantity from t_cart where userId = ? and bookId = ?";
        Integer o = (Integer) querySingleValue(sql, userId, bookId);
        if (o == null) {
            return Integer.MIN_VALUE;
        }
        return o;
    }

    @Override
    public int addBook(CartItem cartItem) {
        String sql = "insert into t_cart(id, name, quantity, price, userId, bookId) values(?,?,?,?,?,?)";
        return update(sql, cartItem.getId(), cartItem.getName(), cartItem.getQuantity(), cartItem.getPrice(), cartItem.getUserId(), cartItem.getBookId());
    }

    @Override
    public int deleteBook(Integer userId, Integer bookId) {
        String sql = "delete from t_cart where userId = ? and bookId = ?";
        return update(sql, userId, bookId);
    }

    @Override
    public int updateBook(Integer userId, Integer quantity, Integer bookId) {
        String sql = "update t_cart set quantity = ? where userId = ? and bookId = ?";
        return update(sql, quantity, userId, bookId);
    }

    @Override
    public int totalQuantity(Integer userId) {
        String sql = "select sum(quantity) from t_cart where userId = ?";
        if (querySingleValue(sql, userId) == null) {
            return 0;
        } else {
            Number integer = (Number) querySingleValue(sql, userId);
            return integer.intValue();
        }
    }

    @Override
    public BigDecimal totalPrice(Integer userId) {
        String sql = "select sum(price * quantity) from t_cart where userId = ?";
        BigDecimal value = (BigDecimal) querySingleValue(sql, userId);
        if (value == null) {
            return new BigDecimal(0);
        }
        return value;
    }

    @Override
    public int clearAll(Integer userId) {
        String sql = "delete from t_cart where userId = ?";
        return update(sql, userId);
    }

    @Override
    public int deleteBookByUserId(Integer userId) {
        String sql = "delete from t_cart where userId = ?";
        return update(sql, userId);
    }

    @Override
    public List<Integer> queryBookIdByUserId(Integer userId) {
        String sql = "select bookId from t_cart where userId = ?";
        return queryForList(Integer.class, sql, userId);
    }
}
