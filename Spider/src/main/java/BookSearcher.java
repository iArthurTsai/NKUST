import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * A simple example, used on the jsoup website.
 */

public class BookSearcher {
    public static void main(String[] args) throws IOException {
        try {
            Document doc = Jsoup.connect("https://en.m.wikipedia.org/").get();
            System.out.println("doc.title(): " + doc.title());

            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title"));
                System.out.println(headline.absUrl("href"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        try {
            Document doc = Jsoup.connect("https://lib.ebookservice.tw/ks/#book/0c2ce1f1-b4c7-43a6-a1c3-1eab6bc6a919").get();
            System.out.println(doc.title());
            //Elements items = doc.getElementsByClass("col-sm-9 col-xs-12 title");//從doc中選擇col-sm-9 col-xs-12 title裡面

            Elements newsHeadlines = doc.select("#bookModal div.modal-header div");//col-sm-9 col-xs-12 title
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("class"));
                System.out.println(headline.absUrl("href"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        try {
            Document doc = Jsoup.connect("https://lib.ebookservice.tw/ks/#book/0c2ce1f1-b4c7-43a6-a1c3-1eab6bc6a919").get();
            System.out.println(doc.title());
            Elements items = doc.getElementsByClass("modal-content");//從doc中選擇modal-content裡面



            for (Element item1 : items) {//在modal-content裡面抓出modal-title
                String num = item1.getElementsByClass("board-name").get(0).text();
                String title = item1.getElementsByClass("board-title").get(0).text();
                System.out.println(item1.getElementsByClass("modal-title"));
                Document doc1 = Jsoup.connect("https://lib.ebookservice.tw/ks/#book/0c2ce1f1-b4c7-43a6-a1c3-1eab6bc6a919").get();//從board-name中選擇的素材與網頁組合並進入

                Elements newsHeadlines = doc1.select("#bookModal div.modal-content div.modal-header");

                for (Element headline : newsHeadlines) {
                    Elements items1 = doc1.getElementsByClass("modal-header");//從doc1中選擇modal-header
                    for(Element item2 : items1){
                        String num2 = item2.getElementsByClass("modal-title").get(0).text();//在class底下選擇第三個span(第一個留言的位置)
                        System.out.println("Comment:" + num2);
                        break;
                    }
                    break;
                }
                //break;
//                System.out.print("\n");
            }
            //break;
            //}
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        //碁峰圖書附件下載器
        try {

            //https://www.javatpoint.com/how-to-take-string-input-in-java
            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
            System.out.print("Enter a Book Number from \"http://books.gotop.com.tw/default.aspx\" : ");
            String str = sc.next(); //reads string before the space
            //String url = ("http://books.gotop.com.tw/download/" + str);

            Document doc = Jsoup.connect("http://books.gotop.com.tw/download/" + str).get();
            //System.out.println(doc.title());

            //Elements Title = doc.select("#Label1");
            //System.out.println("書名：" + elements);
            Element Title = doc.getElementById("Label1"); //書名
            System.out.println("書名：" + Title.text()); //https://stackoverflow.com/a/19091653

            //Element Image = doc.getElementById("Image1");
            //System.out.println("封面：" + Image);
            Elements Image = doc.select("#Image1"); //封面
            for (Element headline : Image) {
                System.out.println("封面：" + headline.absUrl("src")); //封面網址
            }

            //Elements Writer = doc.select("#Label2");
            //System.out.println("作者：" + Writer);
            Element Writer = doc.getElementById("Label2"); //作者
            System.out.println("作者：" + Writer.text());

            //Elements ISBN = doc.select("#Label3");
            //System.out.println("ISBN：" + ISBN);
            Element ISBN = doc.getElementById("Label3"); //ISBN
            System.out.println("ISBN：" + ISBN.text());

            Elements newsHeadlines = doc.select("#DataList1_ctl00_labList tr a");
            //#DataList1_ctl00_labList > table > tbody > tr > td:nth-child(1) > div > font > a
            //#DataList1_ctl00_labList > table > tbody > tr
            for (Element headline : newsHeadlines) {
                System.out.println(headline.absUrl("href")); //範例下載網址

                System.out.print("書號：" + str); //書號
            }

        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        //Document doc = Jsoup.connect("http://www.yiibai.com").get();
        //String keywords = doc.select("meta[name=keywords]").first().attr("content");
        //System.out.println("Meta keyword : " + keywords);
        //String description = doc.select("meta[name=description]").get(0).attr("content");
        //System.out.println("Meta description : " + description);
    }
}
