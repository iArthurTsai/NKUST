//碁峰圖書附件下載器
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class GOTOP_book_attachment_downloader {
    public static void main(String[] args) throws IOException {
        try {
            Document doc = Jsoup.connect("http://books.gotop.com.tw/download/AEI005900").get();//for example : AEI005900 AEI005931 AEI006600 AEI007000
            //System.out.println("書名: " + doc.title());

            //Elements Title = doc.select("#Label1"); //書名
            //System.out.println("書名：" + Title);
            Element Title = doc.getElementById("Label1"); //書名
            System.out.println("書名：" + Title.text()); //https://stackoverflow.com/a/19091653


            Elements Image = doc.select("#Image1"); //封面
            //System.out.println("封面：" + Image);
            //Element Image = doc.getElementById("Image1");
            //System.out.println("封面：" + Image);
            for (Element headline : Image) {
                System.out.println("封面下載網址：" + headline.absUrl("src")); //封面下載網址

                URL fetchWebsite = new URL(headline.absUrl("src")); //自動下載封面
                //https://www.delftstack.com/zh-tw/howto/java/java-downloading-file/#%E5%9C%A8-java-%E4%B8%AD%E4%BD%BF%E7%94%A8-files-copy-%E4%B8%8B%E8%BC%89%E6%AA%94%E6%A1%88

                Path path = Paths.get("front_cover.jpg");
                try (InputStream inputStream = fetchWebsite.openStream()) {
                    Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                }
                break;
            }

            //Elements Writer = doc.select("#Label2"); //作者
            //System.out.println("作者：" + Writer);
            Element Writer = doc.getElementById("Label2"); //作者
            System.out.println("書名：" + Writer.text());

            //Elements ISBN = doc.select("#Label3"); //ISBN
            //System.out.println("ISBN：" + ISBN);
            Element ISBN = doc.getElementById("Label3"); //ISBN
            System.out.println("ISBN：" + ISBN.text());

            Elements newsHeadlines = doc.select("#DataList1_ctl00_labList tr a");
            //#DataList1_ctl00_labList > table > tbody > tr > td:nth-child(1) > div > font > a
            //#DataList1_ctl00_labList > table > tbody > tr
            for (Element attachment : newsHeadlines) {
                System.out.println("附件下載網址：" + attachment.absUrl("href")); //附件下載網址

                URL fetchWebsite = new URL(attachment.absUrl("href")); //自動下載附件

                Path path = Paths.get("file_name.pdf");
                try (InputStream inputStream = fetchWebsite.openStream()) {
                    Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                }
                break;
            }

        }
        catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}
