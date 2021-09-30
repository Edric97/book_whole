package web;

import pojo.CartItem;
import pojo.Order;
import pojo.OrderItem;
import service.BookService;
import service.CartService;
import service.OrderService;
import service.impl.BookServiceImpl;
import service.impl.CartServiceImpl;
import service.impl.OrderServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();
    private CartService cartService = new CartServiceImpl();
    private BookService bookService = new BookServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = WebUtils.transStrToInt(req.getParameter("userId"), 0);

        List<CartItem> cartOfUserId = cartService.cart(userId);//当前用户的购物车中的所有内容
        BigDecimal totalPrice = cartService.totalPrice(userId);//当前用户购物车中的总金额

        Order order = new Order(null, userId, null, totalPrice, new Timestamp(System.currentTimeMillis()));

        /*
        这里应该在t_order中增加订单信息，并在t_orderItem中添加具体订单里面的图书信息

        但是我这里的操作太笨拙了！！！
         */
        orderService.createOrder(order);
        Integer orderId = orderService.getLastedOrderId();
        orderService.addOrderItem(cartOfUserId, orderId);

//        System.out.println(order.getTimestamp());
//        System.out.println(order.getTimestamp().toString());
//        System.out.println("------------------------------");
        System.out.println(cartOfUserId.toString());
        System.out.println(orderId);

        cartService.deleteBookByUserId(userId);//在数据库t_cart表中：把当前用户的的所有图书信息全部删除
        for (CartItem cartItem : cartOfUserId) {

            bookService.updateBookSalesAndStockByBookIdAndQuantity(cartItem.getBookId(), cartItem.getQuantity());
            //在数据库t_book表中：更新图书的销量，库存信息

        }


        orderId = (int) System.currentTimeMillis();

        req.setAttribute("orderId", orderId);

        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

    }

    protected void showMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = WebUtils.transStrToInt(req.getParameter("userId"), 0);

        List<Order> myOrder = orderService.getMyOrder(userId);

        req.setAttribute("myOrder", myOrder);

        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);

    }

    protected void showMyOrderItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}