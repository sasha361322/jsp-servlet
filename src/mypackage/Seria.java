package mypackage;

import java.util.LinkedList;
public class Seria {
    public Seria(int id, String name, String photo, LinkedList description){
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.description = description;
    }
    public Seria(){
        id=0;
        name="";
        photo="";
        description = new LinkedList<>();
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
    public LinkedList getDescription(){
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
    public void setDescription(LinkedList<String> description) {
        this.description = description;
    }
    private int id;
    private String name;
    private String photo;
    private LinkedList<String> description;
}
