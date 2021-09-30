package pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    public static final Integer STATUS = 0;

    private Integer orderId;
    private Integer userId;
    private Integer status = STATUS;
    private BigDecimal amount;
    private Timestamp timestamp;

    public Order() {
    }

    public Order(Integer orderId, Integer userId, Integer status, BigDecimal amount, Timestamp timestamp) {
        this.orderId = orderId;
        this.userId = userId;
        if (status != null) {
            this.status = status;
        }
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public static Integer getSTATUS() {
        return STATUS;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", status=" + status +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
