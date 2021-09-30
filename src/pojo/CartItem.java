package pojo;

import java.math.BigDecimal;

public class CartItem {

    private Integer id;//具体的购物车中的图书的ID
    private Integer userId;//用户的ID
    private Integer bookId;//图书的信息
    private String name;//购物车中的图书名称
    private Integer quantity;//购物车中该图书的数量
    private BigDecimal price;//购物车中该图书的价格

    public CartItem() {
    }

    public CartItem(Integer id, Integer userId, Integer bookId, String name, Integer quantity, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}