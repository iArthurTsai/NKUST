//碁峰圖書附件下載器
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class GOTOP_book_attachment_downloader {
    public static void main(String[] args) throws IOException {
        try {
            //https://www.javatpoint.com/how-to-take-string-input-in-java
            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
            System.out.print("Enter a Book Number from \"http://books.gotop.com.tw/default.aspx\" : ");
            String str = sc.next(); //reads string before the space
            System.out.print("你輸入的書號：" + str); //書號 for example : AEI005900 AEI005931 AEI006600 AEI007000 ACG006200

            String Source = ("http://books.gotop.com.tw/download/" + str); //下載來源網址
            System.out.print("\nSource : " + Source);

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

                String src =(corver.absUrl("src"));

                //https://www.delftstack.com/zh-tw/howto/java/java-remove-character-from-string/#%E5%9C%A8-java-%E4%B8%AD%E4%BD%BF%E7%94%A8-replace-%E5%87%BD%E5%BC%8F%E5%BE%9E%E5%AD%97%E4%B8%B2%E4%B8%AD%E5%88%AA%E9%99%A4%E5%AD%97%E5%85%83
                String front_cover = src.replace("http://www.gotop.com.tw/Waweb2004/WawebImages/bookXL/", "");

                System.out.println("File name : " + front_cover);


                
                //https://stackoverflow.com/questions/28840604/how-to-initiate-a-file-download-in-the-browser-using-java
                String fileName = front_cover;
                URL link = new URL(src);

                InputStream in = new BufferedInputStream(link.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1!=(n=in.read(buf)))
                {
                    out.write(buf, 0, n);
                }
                out.close();
                in.close();
                byte[] response = out.toByteArray();

                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(response);
                fos.close();

                //URL fetchWebsite = new URL(headline.absUrl("src")); //自動下載封面
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

                String href =(attachment.absUrl("href"));

                String file_name = href.replace("http://dlcenter.gotop.com.tw/SampleFiles/" + str + "/download/", "");
                System.out.println("File name : " + file_name);

                //Scanner format = new Scanner(System.in); //System.in is a standard input stream
                //System.out.print("Enter file format : ");
                //String file_format = format.next(); //reads string before the space
                //System.out.print("你輸入的檔案格式：" + file_format + "\n"); //檔案格式
                System.out.print("Downloading..." + "\n");



                //String fileName = file_name;
                //URL link = new URL(href);

                //InputStream in = new BufferedInputStream(link.openStream());
                //ByteArrayOutputStream out = new ByteArrayOutputStream();
                //byte[] buf = new byte[1024];
                //int n = 0;
                //while (-1!=(n=in.read(buf)))
                //{
                    //out.write(buf, 0, n);
                //}
                //out.close();
                //in.close();
                //byte[] response = out.toByteArray();

                //FileOutputStream fos = new FileOutputStream(fileName);
                //fos.write(response);
                //fos.close();

                //URL fetchWebsite = new URL(attachment.absUrl("href")); //自動下載附件

                //Path path = Paths.get(file_name); // + "." + file_format
                //try (InputStream inputStream = fetchWebsite.openStream()) {
                    //Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                //}
                break;
            }
        }
        catch (Exception e) {
            System.out.println("\nerror: " + e);
            System.out.println("\n書號有誤或無附件或檔案名有中文名");
        }
    }
}
