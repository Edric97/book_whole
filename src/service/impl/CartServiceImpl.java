package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import pojo.CartItem;
import service.CartService;

import java.math.BigDecimal;
import java.util.List;

public class CartServiceImpl implements CartService {

    private CartDao cartDao = new CartDaoImpl();

    @Override
    public List<CartItem> cart(Integer userId) {
        return cartDao.cart(userId);
    }

    @Override
    public int queryCertainBook(Integer userId, Integer bookId) {
        return cartDao.queryCertainBook(userId, bookId);
    }

    @Override
    public void addBook(CartItem cartItem) {
        cartDao.addBook(cartItem);
    }

    @Override
    public void deleteBook(Integer userId, Integer bookId) {
        cartDao.deleteBook(userId, bookId);
    }

    @Override
    public void deleteBookByUserId(Integer userId) {
        cartDao.deleteBookByUserId(userId);
    }

    @Override
    public void updateBook(Integer userId, Integer quantity, Integer bookId) {
        cartDao.updateBook(userId, quantity, bookId);
    }

    @Override
    public int totalQuantity(Integer userId) {
        return cartDao.totalQuantity(userId);
    }

    @Override
    public BigDecimal totalPrice(Integer userId) {
        return cartDao.totalPrice(userId);
    }

    @Override
    public void clearAll(Integer userId) {
        cartDao.clearAll(userId);
    }

    @Override
    public List<Integer> queryBookIdByUserId(Integer userId) {
        return cartDao.queryBookIdByUserId(userId);
    }
}
