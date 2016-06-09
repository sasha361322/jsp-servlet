package mypackage;

public class Type_work {
    Type_work(){
        id = 0;
        photo="";
        name="";
        series_id=0;
        description="";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSeries_id() {
        return series_id;
    }
    public void setSeries_id(int series_id) {
        this.series_id = series_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private int id;
    private String photo;
    private String name;
    private int series_id;
    private String description;
}
