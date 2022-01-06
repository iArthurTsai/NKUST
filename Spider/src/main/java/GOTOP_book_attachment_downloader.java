import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class GOTOP_book_attachment_downloader {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://books.gotop.com.tw/download/AEI007000").get();
            System.out.println("書名: " + doc.title());


        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}
