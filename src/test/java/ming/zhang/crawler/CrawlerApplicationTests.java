package ming.zhang.crawler;

import ming.zhang.crawler.crawlers.Xueersi;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrawlerApplicationTests {


    @Autowired
    private ChromeDriver browser;

    @Autowired
    private Actions action;

    @Autowired
    private Xueersi xueersi;

    @Test
    void xueersi() {
        xueersi.start();
    }


    @Test
    public void addBookToEmptyList() throws InterruptedException {
        String baseUrl = "https://www.xueersi.com/course-center/s-23/s6/s-836?switch_grade=6&switch_subject=2";
        browser.get(baseUrl);
        WebElement elementByXPath = browser.findElementByXPath("//div[@class='right-bar__text']/strong");
        System.out.println(elementByXPath.getText());
        // 控制滚动条
        browser.executeScript("window.scrollTo(0, 1000);");
        WebElement elementByXPath2 = browser.findElementByXPath("//p[@class='global-header__region__tip']");
        // 控制鼠标
        action.moveToElement(elementByXPath2).perform();
        Thread.sleep(5000);
        WebElement elementByXPath1 = browser.findElementByXPath("//div[@class='global-header__region__list']//span[2]");
        System.out.println("城市：" + elementByXPath1.getText());
        // 点击事件
        elementByXPath1.click();
        browser.quit();
    }

    @Test
    public void testStr() {
        String url = "https://www.xueersi.com/course-center/s-23/s25/s-836?switch_grade=25&switch_subject=2&terms=4&difficulties=173&times=1140850689&timeSlots=4";
        System.out.println(url.substring(0, url.indexOf("&times=")));
    }

}
