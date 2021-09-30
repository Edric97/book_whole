package web;

import pojo.Book;
import pojo.CartItem;
import service.BookService;
import service.CartService;
import service.impl.BookServiceImpl;
import service.impl.CartServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CartServlet extends BaseServlet {

    private CartService cartService = new CartServiceImpl();
    private BookService bookService = new BookServiceImpl();

    protected void addCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = (Integer) req.getSession().getAttribute("userId");
        Integer bookId = WebUtils.transStrToInt(req.getParameter("bookId"), 0);

        int quantity = cartService.queryCertainBook(userId, bookId);
        Book book = bookService.queryBookById(bookId);
        CartItem cartItem = new CartItem(null, userId, bookId, book.getName(), 1, book.getPrice());

        if (quantity == Integer.MIN_VALUE) {
            //说明在数据库中，该用户并没有添加该书
            cartService.addBook(cartItem);
            resp.sendRedirect(req.getHeader("Referer"));
        } else {
            cartService.updateBook(userId, quantity + 1, bookId);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void exhibit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = (Integer) req.getSession().getAttribute("userId");

        List<CartItem> cart = cartService.cart(userId);

        Integer totalQuantity = cartService.totalQuantity(userId);
        BigDecimal totalPrice = cartService.totalPrice(userId);

        req.setAttribute("cart", cart);
        req.setAttribute("totalQuantity", totalQuantity);
        req.setAttribute("totalPrice", totalPrice);

        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = (Integer) req.getSession().getAttribute("userId");
        Integer bookId = WebUtils.transStrToInt(req.getParameter("bookId"), 0);

        cartService.deleteBook(userId, bookId);

        req.getRequestDispatcher("/cartServlet?action=exhibit").forward(req, resp);

    }

    protected void clearAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = (Integer) req.getSession().getAttribute("userId");

        cartService.clearAll(userId);

        req.getRequestDispatcher("/cartServlet?action=exhibit").forward(req, resp);

    }

}
