
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * A simple example, used on the jsoup website.
 */
public class Spider {
    public static void main(String[] args) throws IOException {
//        try {
//            Document doc = Jsoup.connect("https://en.m.wikipedia.org/").get();
//            System.out.println("doc.title(): " + doc.title());
//
//            Elements newsHeadlines = doc.select("#mp-itn b a");
//            for (Element headline : newsHeadlines) {
//                System.out.println(headline.attr("title"));
//                System.out.println(headline.absUrl("href"));
//            }
//        } catch (Exception e) {
//            System.out.println("error: " + e);
//        }
//        try {
//            Document doc = Jsoup.connect("https://rule.nkust.edu.tw/").get();
//            System.out.println("doc.title(): " + doc.title());
//
//            Elements newsHeadlines = doc.select("#Dyn_2_2 div.mtitle a");//#Dyn_2_2 > div > div > section > div:nth-child(1) > div > div > div > div > a
//            for (Element headline : newsHeadlines) {
//                System.out.println(headline.attr("title"));
//                System.out.println(headline.absUrl("href"));
//            }
//        } catch (Exception e) {
//            System.out.println("error: " + e);
//        }
        try {
            Document doc = Jsoup.connect("https://www.ptt.cc/bbs/index.html").get();
            System.out.println(doc.title());

            Elements newsHeadlines = doc.select("#main-container a.board");
            for (Element headline : newsHeadlines) {
                //System.out.println(headline.attr("title"));
                System.out.println(headline.absUrl("href"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        try {
            Document doc = Jsoup.connect("https://www.ptt.cc/bbs/index.html").get();
            System.out.println(doc.title());
            Elements items = doc.getElementsByClass("b-ent");//從doc中選擇b-ent裡面

            for (Element item1 : items) {//在b-ent裡面抓出board-name和board-title
                String num = item1.getElementsByClass("board-name").get(0).text();
                String title = item1.getElementsByClass("board-title").get(0).text();//board-title
                System.out.println("board>"+item1.getElementsByClass("board-title"));
                Document doc1 = Jsoup.connect("https://www.ptt.cc/bbs/" + num + "/index.html").get();//從board-name中選擇的素材與網頁組合並進入
//                System.out.println("Board: " + num);
//                System.out.println("Article title: " + title);
                Elements newsHeadlines = doc1.select("#main-container div.r-list-container.action-bar-margin.bbs-screen a");
                //System.out.println(doc1);
                for (Element headline : newsHeadlines) {
                    Elements items1 = doc1.getElementsByClass("r-ent");//從doc1中選擇r-ent
                    for (Element item2 : items1) {//從r-ent中逐步搜尋素材
//                        System.out.println(headline.absUrl("href"));
                        Document doc2 = Jsoup.connect(headline.absUrl("href")).get();//進入Elements newsHeadlines所抓出的href的網址
                        Elements items2 = doc2.getElementsByClass("push");//從href網頁中選擇push
                        for(Element item3 : items2){
                            String num2 = item3.getElementsByClass("push").get(0).getElementsByTag("span").get(2).text();//在class底下選擇第三個span(第一個留言的位置)
                            String num3 = item3.getElementsByClass("push").get(0).getElementsByTag("span").get(1).text();
//                            System.out.println("Comment:" + num3 + num2);
                            break;
                        }
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

        //Document doc = Jsoup.connect("http://www.yiibai.com").get();
        //String keywords = doc.select("meta[name=keywords]").first().attr("content");
        //System.out.println("Meta keyword : " + keywords);
        //String description = doc.select("meta[name=description]").get(0).attr("content");
        //System.out.println("Meta description : " + description);
    }
}