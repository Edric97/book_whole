package dao;

import pojo.CartItem;

import java.math.BigDecimal;
import java.util.List;

public interface CartDao {
    List<CartItem> cart(Integer userId);

    int queryCertainBook(Integer userId, Integer bookId);

    int addBook(CartItem cartItem);

    int deleteBook(Integer userId, Integer bookId);

    int updateBook(Integer userId, Integer quantity, Integer bookId);

    int totalQuantity(Integer userId);

    BigDecimal totalPrice(Integer userId);

    int clearAll(Integer userId);

    int deleteBookByUserId(Integer userId);

    List<Integer> queryBookIdByUserId(Integer userId);
}
