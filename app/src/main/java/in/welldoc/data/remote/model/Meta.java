package in.welldoc.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("pagination")
    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
