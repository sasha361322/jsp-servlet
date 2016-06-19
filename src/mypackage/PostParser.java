package mypackage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import java.util.LinkedList;

public class PostParser {
    PostParser(String url){
        Document doc;
        //"https://new.vk.com/paperar?w=wall-119698233_16" to "https://new.vk.com/wall-119698233_16"
        url = "https://new.vk.com/" + url.substring(url.indexOf("wall-"));
        postText="";
        postPhotos = new LinkedList<String >();
        try {
            doc = Jsoup.connect(url).timeout(100*1000).get();
            Elements text = doc.select("div.pi_text");
            for (Node child:text.get(0).childNodes()){
                postText+=child;
            }
            Elements photoes = doc.select("a.medias_thumb.thumb_item.al_photo");
            for(Element e:photoes) {
                Elements refs = e.getElementsByAttribute("href");
                for(Element ref:refs){
                    String almostPhoto = ref.attr("href");
                    String temp[] = almostPhoto.split("[&]+");
                    String temp_url = "https://new.vk.com"+temp[temp.length-2];
                    Document docPhoto = Jsoup.connect(temp_url).timeout(100*1000).get();
                    Elements els = docPhoto.select("div.mv_description");
                    for (Element el:els){
                        Elements elemetns_with_ref = el.getElementsByAttribute("href");
                        for (Element element_with_ref:elemetns_with_ref){
                            postPhotos.add(element_with_ref.attr("href"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
    public String getPostText() {
        return postText;
    }
    public LinkedList<String> getPostPhotos() {
        return postPhotos;
    }
    private String postText;
    private LinkedList<String> postPhotos;
}
