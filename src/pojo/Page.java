package pojo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 4;

    private Integer pageNo;
    private Integer pageSize = PAGE_SIZE;
    private Integer pageTotalQuantity;
    private Integer pageTotal;
    private List<T> items;
    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotalQuantity, Integer pageTotal, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalQuantity = pageTotalQuantity;
        this.pageTotal = pageTotal;
        this.items = items;
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotalQuantity, Integer pageTotal, List<T> items, String url) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalQuantity = pageTotalQuantity;
        this.pageTotal = pageTotal;
        this.items = items;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalQuantity() {
        return pageTotalQuantity;
    }

    public void setPageTotalQuantity(Integer pageTotalQuantity) {
        this.pageTotalQuantity = pageTotalQuantity;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotalQuantity=" + pageTotalQuantity +
                ", pageTotal=" + pageTotal +
                ", items=" + items +
                '}';
    }
}
