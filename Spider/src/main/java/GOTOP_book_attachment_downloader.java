//碁峰圖書附件下載器
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class GOTOP_book_attachment_downloader {
    public static void main(String[] args) throws IOException {
        try {
            Document doc = Jsoup.connect("http://books.gotop.com.tw/download/AEI007000").get();//for example : AEI005900 AEI005931 AEI006600 AEI007000
            //System.out.println("書名: " + doc.title());

            //Elements Title = doc.select("#Label1"); //書名
            //System.out.println("書名：" + Title);
            Element Title = doc.getElementById("Label1"); //書名
            System.out.println("\n書名：" + Title.text()); //https://stackoverflow.com/a/19091653


            Elements Image = doc.select("#Image1"); //封面
            //System.out.println("封面：" + Image);
            //Element Image = doc.getElementById("Image1");
            //System.out.println("封面：" + Image);
            for (Element headline : Image) {
                System.out.println("封面下載網址：" + headline.absUrl("src")); //封面下載網址
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
                System.out.println("附件下載網址：" + attachment.absUrl("href")); //範例下載網址
            }

        }
        catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}
