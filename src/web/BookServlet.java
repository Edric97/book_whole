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
import java.math.BigDecimal;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.transStrToInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.transStrToInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page&");
        req.setAttribute("page", page);


        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryAllBooks();

        req.setAttribute("books", books);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.transStrToInt(req.getParameter("id"), 0);

        int pageNo = WebUtils.transStrToInt(req.getParameter("pageNo"), 1);

        /*
        在数据库中找到编号为id的书，并返回到新的页面
         */
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.setAttribute("id", id);
        req.setAttribute("pageNo", pageNo);

        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer id = WebUtils.transStrToInt(req.getParameter("id"), 0);
//        String name = req.getParameter("name");
//        BigDecimal price = new BigDecimal(req.getParameter("price"));
//        String author = req.getParameter("author");
//        Integer sales = WebUtils.transStrToInt(req.getParameter("sales"), 0);
//        Integer stock = WebUtils.transStrToInt(req.getParameter("stock"), 0);

        int pageNo = WebUtils.transStrToInt(req.getParameter("pageNo"), 1);
        Book book1 = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

//        Book book = new Book(id, name, price, author, sales, stock, null);
        bookService.updateBook(book1);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.transStrToInt(req.getParameter("pageNo"), 1);

        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        bookService.addBook(book);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = WebUtils.transStrToInt(req.getParameter("id"), 0);

        int pageNo = WebUtils.transStrToInt(req.getParameter("pageNo"), 1);

        bookService.deleteBookById(id);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);

    }

    protected void listAuthorWord(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        String author = req.getParameter("authorName");

        List<Book> books = bookService.queryBookByAuthor(author);

        req.setAttribute("books", books);

        req.getRequestDispatcher("/pages/manager/certainAuthor_book.jsp").forward(req, resp);

    }


}
