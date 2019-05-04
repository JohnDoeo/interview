package com.johndoeo.utils.jianshuSpider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

    @org.junit.Test
    public void test1(){
        final Document document = getDocument("https://www.jianshu.com/");
        parse(document);
    }

    /**
     * 打开浏览器，不能向下滑动
     * @param url
     * @return
     */
    public static Document getDocument(String url){
        Document doc = null;
        //可使用的浏览器有：IE浏览器（webdriver.ie.driver）
        //火狐浏览器  (webdriver.gecko.driver)
        //谷歌浏览器 (webdriver.chrome.driver)
        //                  是使用那个浏览器                                   chromedriver所在的位置
        System.setProperty("webdriver.chrome.driver", "E:\\chromeDriver\\chromedriver.exe");

        // InternetExplorerDriver()   浏览器
        // FirefoxDriver()            火狐浏览器
        //谷歌浏览器
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        //等待几秒
        try {
            //((JavascriptExecutor)driver).executeScript("scrollTo(0,10000)");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        doc = Jsoup.parse(driver.getPageSource());

        //关闭浏览器
        driver.close();
        driver.quit();

        return doc;
    }

    /**
     * 解析传过来的doc
     * @param doc
     */
    public static void parse(Document doc){
        if(doc == null){
            System.out.println("doc is null, unable to continue! ");
            return ;
        }
        Elements content = doc.select("div.content");

        //System.out.println(select);
        for (Element element : content) {
            //获取文章标题
            String title = element.select("a.title").text();

            //获取获取帖子网址
            String url = element.select("a.title").attr("href");
            url = "https://www.jianshu.com" + url;

            //获取文章的摘要
            String digest = element.select("p.abstract").text();

            //获取文章作者名称
            String author = element.select("a.nickname").text();

            //获取作者网址
            String authorUrl = element.select("a.nickname").attr("href");
            authorUrl = "https://www.jianshu.com" + authorUrl;

            System.out.println("title: " + title);
            System.out.println("url: " + url);
            System.out.println("digest:  " + digest);
            System.out.println("author: " + author);
            System.out.println("authorUrl: " + authorUrl);
            System.out.println("--------------\n");
        }
    }

    /**
     * 打开浏览器，向下滑动
     * @param url
     * @return
     */
//    public static Document getDocument(String url){
//        Document doc = null;
//        //可使用的浏览器有：IE浏览器（webdriver.ie.driver）
//        //火狐浏览器  (webdriver.gecko.driver)
//        //谷歌浏览器 (webdriver.chrome.driver)
//        //                  是使用那个浏览器                                   chromedriver所在的位置
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//
//        // InternetExplorerDriver()   浏览器
//        // FirefoxDriver()            火狐浏览器
//        //谷歌浏览器
//        WebDriver driver = new ChromeDriver();
//
//        driver.get(url);
//
//        //等待几秒
//        try {
//
//            //向下滚动  方法一
//            //JavascriptExecutor js = (JavascriptExecutor)driver;
//            //js.executeScript("scrollTo(0,20000)");
//
//            //向下滚动 方法二
//            ((JavascriptExecutor)driver).executeScript("scrollTo(0,10000)");
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        doc = Jsoup.parse(driver.getPageSource());
//
//        //关闭浏览器
//        driver.close();
//        driver.quit();
//
//        return doc;
//    }

    /**
     * 浏览器后台运行，向下滑动
     * @param url
     * @return
     */
//    public static Document getDocument(String url){
//        Document doc = null;
//        //可使用的浏览器有：IE浏览器（webdriver.ie.driver）
//        //火狐浏览器  (webdriver.gecko.driver)
//        //谷歌浏览器 (webdriver.chrome.driver)
//        //                  是使用那个浏览器                                   chromedriver所在的位置
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//
//        // InternetExplorerDriver()   浏览器
//        // FirefoxDriver()            火狐浏览器
//        //谷歌浏览器
//        WebDriver driver = null;
//
//        //创建chrome参数对象
//        ChromeOptions options = new ChromeOptions();
//
//        //浏览器后台运行
//        options.addArguments("headless");
//
//        driver = new ChromeDriver(options);
//        driver.get(url);
//
//        //等待几秒
//        try {
//
//            //向下滚动  方法一
//            //JavascriptExecutor js = (JavascriptExecutor)driver;
//            //js.executeScript("scrollTo(0,20000)");
//
//            //向下滚动 方法二
//            ((JavascriptExecutor)driver).executeScript("scrollTo(0,10000)");
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        doc = Jsoup.parse(driver.getPageSource());
//
//        //关闭浏览器
//        driver.close();
//        driver.quit();
//
//        return doc;
//    }
}
