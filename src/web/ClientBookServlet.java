package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.transStrToInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.transStrToInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/clientBookServlet?action=page&");
        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String min = req.getParameter("min");
        int max = WebUtils.transStrToInt(req.getParameter("max"), Integer.MAX_VALUE);
        int pageNo = WebUtils.transStrToInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.transStrToInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

//        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice&");

        if (min != null) {
            sb.append("min=").append(WebUtils.transStrToInt(req.getParameter("min"), 0)).append("&");
        }
        if (max != Integer.MAX_VALUE) {
            sb.append("max=").append(max).append("&");
        }

        int min1 = WebUtils.transStrToInt(req.getParameter("min"), 0);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min1, max);
        page.setUrl(sb.toString());

        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);


    }

}
