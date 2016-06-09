package mypackage;

public class Seria {
    public Seria(){
        id=0;
        name="";
        name_ru="";
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
    public String getName_ru() {
        return name_ru;
    }
    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }
    private int id;
    private String name;
    private String name_ru;
    private String photo;
    private String description;
}
