package in.welldoc.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NoticeList {

    @SerializedName("notice_list")
    private ArrayList<Datum> noticeList;

    public ArrayList<Datum> getNoticeArrayList() {
        return noticeList;
    }

    public void setNoticeArrayList(ArrayList<Datum> noticeArrayList) {
        this.noticeList = noticeArrayList;
    }
}