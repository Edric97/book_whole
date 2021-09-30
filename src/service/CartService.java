package service;

import pojo.CartItem;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    List<CartItem> cart(Integer userId);

    int queryCertainBook(Integer userId, Integer bookId);

    void addBook(CartItem cartItem);//添加图书，是因为该图书在数据库中还不存在，即找不到对应得到bookId

    void deleteBook(Integer userId, Integer bookId);

    void deleteBookByUserId(Integer userId);//在账单功能实现的时候，需要将相应的userId的所有购物车信息，全部删除

    void updateBook(Integer userId, Integer quantity, Integer bookId);

    int totalQuantity(Integer userId);

    BigDecimal totalPrice(Integer userId);

    void clearAll(Integer userId);

    List<Integer> queryBookIdByUserId(Integer userId);
}