import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class GOTOP_book_attachment_downloader {
    public static void main(String[] args) throws IOException {
        try {
            Document doc = Jsoup.connect("http://books.gotop.com.tw/download/AEI007000").get();
            //System.out.println("書名: " + doc.title());

            Elements Title = doc.select("#Label1"); //書名
            System.out.println("書名：" + Title);

            Elements Image = doc.select("#Image1"); //封面
            System.out.println("封面：" + Image);
            Elements Writer = doc.select("#Label2"); //作者
            System.out.println("作者：" + Writer);

            Elements ISBN = doc.select("#Label3"); //ISBN
            System.out.println("ISBN：" + ISBN);

        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}
