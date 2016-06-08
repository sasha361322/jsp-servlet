package mypackage;

public class Seria {
    public Seria(int id, String name, String photo, String description){
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }
    public Seria(){
        id=0;
        name="";
        photo="";
        description = "";
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhoto(){
        return photo;
    }
    public String getDescription(){
        return description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private int id;
    private String name;
    private String photo;
    private String description;
}
