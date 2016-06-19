package mypackage;

import java.util.LinkedList;

public class Work {
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getArticle() {
        return article;
    }
    public void setArticle(String article) {
        this.article = article;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getType_work_id() {
        return type_work_id;
    }
    public void setType_work_id(int type_work_id) {
        this.type_work_id = type_work_id;
    }
    public float getSize_x() {
        return size_x;
    }
    public void setSize_x(float size_x) {
        this.size_x = size_x;
    }
    public float getSize_y() {
        return size_y;
    }
    public void setSize_y(float size_y) {
        this.size_y = size_y;
    }
    public String getOwn_photo() {
        return own_photo;
    }
    public void setOwn_photo(String own_photo) {
        this.own_photo = own_photo;
    }
    public String getCount_lists() {
        return count_lists;
    }
    public void setCount_lists(String count_lists) {
        this.count_lists = count_lists;
    }
    public LinkedList<Component> getComponents() {
        return components;
    }
    public void setComponents(LinkedList<Component> components) {
        this.components = components;
    }
    private int id;
    private String article;
    private String description;
    private int type_work_id;
    private int price;
    private float size_x;
    private float size_y;
    private String own_photo;
    private String count_lists;
    private LinkedList<Component> components;
}
