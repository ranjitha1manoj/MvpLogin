package in.welldoc.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class Pagination {
    @SerializedName("total")

    private Integer total;
    @SerializedName("pages")

    private Integer pages;
    @SerializedName("page")
    private Integer page;
    @SerializedName("limit")
    private Integer limit;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
