//碁峰圖書附件下載器
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpEntity;
import org.apache.commons.io.FileUtils;
//import java.io.InputStream;
//import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;

public class GOTOP_book_attachment_downloader {
    public static void main(String[] args) throws IOException {
        String home = System.getProperty("user.home"); //https://www.796t.com/post/MmNtYzI=.html
        try {

            //https://www.javatpoint.com/how-to-take-string-input-in-java
            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
            System.out.print("Enter a Book Id or URL from \"http://books.gotop.com.tw/default.aspx\" : ");
            String str = sc.next(); //reads string before the space
            if (str.contains("http://books.gotop.com.tw/v_")) {str = str.replace("http://books.gotop.com.tw/v_", "");} //https://www.delftstack.com/zh-tw/howto/java/how-to-check-if-a-string-contains-character-in-java/#%E4%BD%BF%E7%94%A8%E5%AD%97%E4%B8%B2-contains-%E6%96%B9%E6%B3%95%E8%88%87-if-else-%E8%AA%9E%E5%8F%A5%E4%B8%80%E8%B5%B7%E4%BD%BF%E7%94%A8
            System.out.print("你輸入的書號：" + str); //書號 for example : AEI005900 AEI005931 AEI006600 AEI007000 ACG006200

            String Source = ("http://books.gotop.com.tw/download/" + str); //下載來源網址
            System.out.print("\n下載來源網址：" + Source);

            String path = (home + "\\Downloads\\" + str + "\\");

            Document doc = Jsoup.connect(Source).get();
            //System.out.println("書名: " + doc.title());

            //Elements Title = doc.select("#Label1"); //書名
            //System.out.println("書名：" + Title);
            Element Title = doc.getElementById("Label1"); //書名
            System.out.println("\n書名：" + Title.text()); //https://stackoverflow.com/a/19091653

            Elements Image = doc.select("#Image1"); //封面
            //System.out.println("封面：" + Image);
            //Element Image = doc.getElementById("Image1");
            //System.out.println("封面：" + Image);
            for (Element corver : Image) {
                System.out.println("封面下載網址：" + corver.absUrl("src")); //封面下載網址

                String src = (corver.absUrl("src"));

                //https://www.delftstack.com/zh-tw/howto/java/java-remove-character-from-string/#%E5%9C%A8-java-%E4%B8%AD%E4%BD%BF%E7%94%A8-replace-%E5%87%BD%E5%BC%8F%E5%BE%9E%E5%AD%97%E4%B8%B2%E4%B8%AD%E5%88%AA%E9%99%A4%E5%AD%97%E5%85%83
                String front_cover = src.replace("http://www.gotop.com.tw/Waweb2004/WawebImages/bookXL/", "");

                System.out.println("封面名稱：" + front_cover);

                //自動下載封面
                CloseableHttpClient httpClient = HttpClients.createDefault(); //https://stackoverflow.com/questions/35995431/how-to-specify-user-agent-and-referer-in-fileutils-copyurltofileurl-file-meth

                HttpGet Getcorver = new HttpGet(src);
                Getcorver.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
                Getcorver.addHeader("Referer", Source);

                    CloseableHttpResponse httpResponse = httpClient.execute(Getcorver);
                    HttpEntity Entity = httpResponse.getEntity();

                    if (Entity != null) {
                        FileUtils.copyInputStreamToFile(Entity.getContent(), new File(path + front_cover));
                    }

                Getcorver.releaseConnection();

                //URL fetchWebsite = new URL(corver.absUrl("src")); //自動下載封面
                //https://www.delftstack.com/zh-tw/howto/java/java-downloading-file/#%E5%9C%A8-java-%E4%B8%AD%E4%BD%BF%E7%94%A8-files-copy-%E4%B8%8B%E8%BC%89%E6%AA%94%E6%A1%88

                //Path cover = Paths.get(front_cover); //"front_cover.jpg"
                //try (InputStream inputStream = fetchWebsite.openStream()) {
                //Files.copy(inputStream, cover, StandardCopyOption.REPLACE_EXISTING);
                //}
                break;
            }

            //Elements Writer = doc.select("#Label2"); //作者
            //System.out.println("作者：" + Writer);
            Element Writer = doc.getElementById("Label2"); //作者
            System.out.println("作者：" + Writer.text());

            //Elements ISBN = doc.select("#Label3"); //ISBN
            //System.out.println("ISBN：" + ISBN);
            Element ISBN = doc.getElementById("Label3"); //ISBN
            System.out.println("ISBN：" + ISBN.text());

            Elements newsHeadlines = doc.select("#DataList1_ctl00_labList tr a");
            //#DataList1_ctl00_labList > table > tbody > tr > td:nth-child(1) > div > font > a
            //#DataList1_ctl00_labList > table > tbody > tr
            for (Element attachment : newsHeadlines) {
                System.out.println("附件下載網址：" + attachment.absUrl("href")); //附件下載網址

                String href = (attachment.absUrl("href"));

                String file_name = href.replace("http://dlcenter.gotop.com.tw/SampleFiles/" + str + "/download/", "");
                System.out.println("附件名稱：" + file_name);

                //Scanner format = new Scanner(System.in); //System.in is a standard input stream
                //System.out.print("Enter file format : ");
                //String file_format = format.next(); //reads string before the space
                //System.out.print("你輸入的檔案格式：" + file_format + "\n"); //檔案格式
                System.out.print("Downloading..." + "\n");

                //自動下載附件
                CloseableHttpClient httpClient = HttpClients.createDefault(); //https://stackoverflow.com/questions/35995431/how-to-specify-user-agent-and-referer-in-fileutils-copyurltofileurl-file-meth

                HttpGet Getattachment = new HttpGet(href);
                Getattachment.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
                Getattachment.addHeader("Referer", Source);

                CloseableHttpResponse httpResponse = httpClient.execute(Getattachment);
                HttpEntity Entity = httpResponse.getEntity();

                if (Entity != null) {
                    FileUtils.copyInputStreamToFile(Entity.getContent(), new File(path + file_name));
                }

                Getattachment.releaseConnection();

                //URL fetchWebsite = new URL(attachment.absUrl("href")); //自動下載附件

                //Path path = Paths.get(file_name); // + "." + file_format
                //try (InputStream inputStream = fetchWebsite.openStream()) {
                //Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                //}
                break;
            }
            System.out.println("Downloaded files was saved to " + path);
            java.awt.Desktop.getDesktop().open(new File(path)); //https://www.itread01.com/p/1434970.html
            System.out.println("Copyright 2077© GOTOP Information Inc, All Rights Reserved 請勿任意連結、轉載"); //http://books.gotop.com.tw/err.html

        } catch (Exception e) {
            System.out.println("\nerror: " + e);
            System.out.println("無附件或書號有誤");
            System.out.println("Youre a sussy baka, i see"); //https://www.codegrepper.com/code-examples/whatever/among+us
            java.awt.Desktop.getDesktop().open(new File(home + "\\" + "NKUST_C110181103" + "\\" + "SussyBakaRemix.m4a"));
        }
    }
}
