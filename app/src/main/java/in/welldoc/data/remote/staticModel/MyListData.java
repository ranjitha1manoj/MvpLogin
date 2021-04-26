package in.welldoc.data.remote.staticModel;

public class MyListData {

    public MyListData(String description) {
        this.description = description;
    }

    private String description;

    public MyListData(int imgId) {
        this.imgId = imgId;
    }

    private int imgId;
    public MyListData( int imgId,String description) {
        this.description = description;
        this.imgId = imgId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

}
