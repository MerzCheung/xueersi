package ming.zhang.crawler.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author merz
 * @Description:
 */
@Component
public class Beans {

    @Bean
    public ChromeDriver browser() {
        //可使用的浏览器有：IE浏览器（webdriver.ie.driver）
        //火狐浏览器  (webdriver.gecko.driver)
        //谷歌浏览器 (webdriver.chrome.driver)
        System.setProperty("webdriver.chrome.driver", "D:\\crawler\\doc\\chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        // 浏览器隐藏
//        chromeOptions.addArguments("headless");
        // 浏览器最大化
        chromeOptions.addArguments("start-maximized");
        ChromeDriver browser = new ChromeDriver(chromeOptions);
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }

    @Bean
    public Actions action(ChromeDriver browser) {
        return new Actions(browser);
    }
}
