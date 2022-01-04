
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

        try {
            Document doc = Jsoup.connect("http://books.gotop.com.tw/download/AEI007000").get();
            //System.out.println("書名: " + doc.title());

            Elements elements = doc.select("#Label1");
            System.out.println("書名: " + elements);

            Elements writer = doc.select("#Label2");
            System.out.println("writer: " + writer);

            Elements ISBN = doc.select("#Label3");
            System.out.println("ISBN: " + ISBN);
            var str = ISBN
            str = str.replace(/<\/?span[^>]*>/g,"");

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
