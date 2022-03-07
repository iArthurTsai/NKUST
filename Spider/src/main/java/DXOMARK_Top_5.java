import java.util.Scanner;
import java.lang.*;
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
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.io.InputStream;
//import java.net.URL;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;

public class DXOMARK_Top_5 {
    public static void main(String[] args) throws IOException {
        try {
            Document Dxo = Jsoup.connect("https://www.dxomark.com/").get();
            System.out.println(Dxo.title() + "\n");

            Elements rankingTab = Dxo.getElementsByClass("rankingTab");//從dxo中選擇rankingTab裡面
            for (Element Top_5 : rankingTab) { //在rankingTab裡面抓出listElement flex-row
                Elements listElement = Top_5.getElementsByClass("listElement flex-row");
                for (Element Top : listElement) { //在listElement flex-row裡面抓出Devices
                    Elements dxomark = Top.select("div.deviceName.flex-col.flex-left.flex-grow h3 a");
                    for (Element deviceName : dxomark) { //在Devices裡面抓出deviceName和網址
                        String dxomarkscore = Top.getElementsByTag("div").text();
                        //String dxomarkranking = deviceName.getElementsByTag("a").text();
                        String dxomarkhref = deviceName.absUrl("href");
                        System.out.println(dxomarkscore + "\n" + "網址：" + deviceName.absUrl("href"));
                    }
                }
            }

            System.out.println("\nCopyright © 2008-2022 DXOMARK. All rights reserved");

        } catch (Exception e) {
            System.out.println("\nerror: " + e);
        }

//By Camera Score        
//#content > div:nth-child(3) > div > div > div > div.rankings.list > div.ranking-overflow-container > div > div:nth-child(5) > div
//row device-row
        try {
            Document sort_camera = Jsoup.connect("https://www.dxomark.com/smartphones/#sort-camera/device-").get();
            System.out.println(sort_camera.title() + "\n");

            Elements rankings_list = sort_camera.getElementsByClass("rankings list");//從dxo中選擇rankingTab裡面
            for (Element list :  rankings_list) { //在rankings list裡面抓出row device-row
                Elements device_row = list.getElementsByClass("row device-row");
                for (Element Top : device_row) { //在row device-roww裡面抓出Devices
                    String dxomarkscorelist = Top.getElementsByTag("span").text();
                    //String dxomarkranking = deviceName.getElementsByTag("a").text();
                    //String dxomarkhref = deviceName.absUrl("href");
                    System.out.println(dxomarkscorelist + "\n");
                }
            }

            System.out.println("\nCopyright © 2008-2022 DXOMARK. All rights reserved");

        } catch (Exception e) {
            System.out.println("\nerror: " + e);
        }

//#section1 > div.mainbor.mt2 > div.m_l.fl > ul:nth-child(3) > div.nrank-b
        try {
            Document doc1 = Jsoup.connect("https://www.antutu.com/en/ranking/rank1.htm").get();
            System.out.println(doc1.title() + "\n");

            Elements nrank_b = doc1.getElementsByClass("nrank-b");
            for (Element devices : nrank_b) { //在nrank_b裡面抓出li
                String deviceName = devices.getElementsByTag("li").text();
                System.out.println(deviceName); //網址
                //Elements bfirst = devices.getElementsByClass("bfirst");
            }

            System.out.println("\nCopyright© 2022 www.antutu.com");

        } catch (Exception e) {
            System.out.println("\nerror: " + e);
        }
    }
}
