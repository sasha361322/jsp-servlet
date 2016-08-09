package mypackage;

import java.util.Date;
import java.util.LinkedList;

public class News {
    News (String url){
        PostParser postParser = new PostParser(url);
        Thread myThread = new Thread(postParser);
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        photoes = postParser.getPostPhotos();
        text = postParser.getPostText();
    }
    News (){
        id = 0;
        photoes = new LinkedList<>();
        text = "";
        work = new Work();
        date = new Date();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LinkedList<String> getPhotoes() {
        return photoes;
    }
    public void setPhotoes(LinkedList<String> photoes) {
        this.photoes = photoes;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Work getWork() {
        return work;
    }
    public void setWork(Work work) {
        this.work = work;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    private int id;
    private LinkedList<String> photoes;
    private String text;
    private Work work;
    private Date date;
}
