package ming.zhang.crawler.crawlers;

import lombok.extern.slf4j.Slf4j;
import ming.zhang.crawler.entity.CurriculumEntity;
import ming.zhang.crawler.entity.XueersiInitBean;
import ming.zhang.crawler.mapper.XueersiMapper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

/**
 * @author merz
 * @Description:
 */
@Slf4j
@Component
public class Xueersi {
    private static final String URL = "https://www.xueersi.com";

    @Autowired
    private XueersiMapper xueersiMapper;

    @Autowired
    private ChromeDriver browser;

    private static String province = null;
    private static String switchGrade = null;
    private static String switchSubject = null;

    public void start() {
        browser.get(URL);
        for(int i = 3; i < 35; i++) {
            String js = "document.querySelectorAll('.region-list__item')[" + i + "].click();";
            browser.executeScript(js);
            province = browser.findElementByXPath("//p[@class='global-header__region__tip']/span").getText();
            log.info("省份: {}", province);
            try {
                selectSwitchGrade();
            } catch (Exception e) {
                log.error("错误页面url: {}", browser.getCurrentUrl());
                e.printStackTrace();
            }
        }
        log.info("quit>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        browser.close();
        browser.quit();
    }

    private void selectSwitchGrade() {
        List<WebElement> elementByXPath = browser.findElementsByXPath("//div[@class='course-list']/dl[1]/dd/a");
        elementByXPath.forEach(item -> {
            log.info("年级: {}", item.getText());
            if (!"中班".equals(item.getText()) && !"大班".equals(item.getText())) {
                switchGrade = item.getText();
                String href = item.getAttribute("href");
                browser.executeScript("window.open('"+href+"')");
                ArrayList<String> tabs = new ArrayList<String> (browser.getWindowHandles());
                browser.switchTo().window(tabs.get(tabs.size()-1));
                selectSwitchSubject();
                browser.executeScript("window.close()");
                browser.switchTo().window(tabs.get(tabs.size()-2));
            }
        });
    }

    private void selectSwitchSubject() {
        List<WebElement> elementByXPath = browser.findElementsByXPath("//div[@class='course-list']/dl[2]/dd/a");
        elementByXPath.forEach(item -> {
            if (!item.getAttribute("href").contains("subjectId=0")) {
                log.info("学科: {}", item.getText());
                    switchSubject = item.getText();
                    String href = item.getAttribute("href");
                    browser.executeScript("window.open('"+href+"')");
                    ArrayList<String> tabs = new ArrayList<String> (browser.getWindowHandles());
                    browser.switchTo().window(tabs.get(tabs.size()-1));
                    selectSwitchType();
                    browser.executeScript("window.close()");
                    browser.switchTo().window(tabs.get(tabs.size()-2));
                }
        });
    }

    private void selectSwitchType() {
        // 同步课
        List<WebElement> elementsByXPath = browser.findElementsByXPath("//div[@class='sync-course__list']/div[2]/a");
        // 专题课,三节课,10分钟素养课
//        List<WebElement> courseList1 = browser.findElementsByXPath("//div[@class='special-course-view']");

        elementsByXPath.forEach(item -> {
            String href = item.getAttribute("href");
            openTab(href);
        });

//        courseList1.forEach(item -> {
//            String switchType = item.findElement(By.className("title__name")).getText();
//            String more = null;
//            try {
//                more = item.findElement(By.className("title__more")).getAttribute("href");
//            } catch (NoSuchElementException e) {
//                log.error("title__more没有 url: {}", browser.getCurrentUrl());
//            }
//            if (StringUtils.isBlank(more)) {
//                List<WebElement> tags = item.findElement(By.className("course-list")).findElements(By.tagName("a"));
//                CurriculumEntity.CurriculumEntityBuilder curriculumEntityBuilder = CurriculumEntity.builder()
//                        .province(province)
//                        .switchGrade(switchGrade)
//                        .switchSubject(switchSubject)
//                        .switchType(switchType);
//                tags.forEach(ele -> {
//                    String times = ele.findElement(By.className("card-info")).findElement(By.className("card-info__data")).getText();
//                    String duration = ele.findElement(By.xpath("./p[@class='card-title']/span[2]")).getText();
//                    String teacher = ele.findElement(By.xpath("./div[@class='teacher-list']/div[1]/p[2]")).getText();
//                    String rating = null;
//                    try {
//                        rating = ele.findElement(By.className("card-bottom__price")).findElement(By.tagName("strong")).getText();
//                    } catch (NoSuchElementException e) {
//                        log.error("没有找到card-bottom__price，已爆满，url:{}", browser.getCurrentUrl());
//                    }
//                    String views = ele.getAttribute("href");
//                    CurriculumEntity curriculumEntity = curriculumEntityBuilder.concreteTime(times)
//                            .duration(duration)
//                            .teacher(teacher)
//                            .rating(rating)
//                            .views(views).build();
//                    save(curriculumEntity);
//                });
//            } else {
//                openTab(more);
//            }
//        });
    }

    private void syncCourse() throws InterruptedException {
        StringBuilder url = new StringBuilder(browser.getCurrentUrl());
        List<WebElement> elementByXPaths = browser.findElementsByXPath("//div[@class='course-select']/div");
        if (CollectionUtils.isEmpty(elementByXPaths)) {
            String num = browser.findElementByXPath("//div[@class='right-bar__text']/strong").getText();
            Integer courseList = browser.findElementsByXPath("//div[@class='courseList']/a").size();
            if (!StringUtils.isBlank(num)) {
                while (Integer.valueOf(num) != courseList) {
                    browser.executeScript("window.scrollTo(0, 100000);");
                    Thread.sleep(500);
                    courseList = browser.findElementsByXPath("//div[@class='courseList']/a").size();
                }
                List<WebElement> elementsByXPath = browser.findElementsByXPath("//div[@class='courseList']/a");
                WebElement elementByXPath = browser.findElementByXPath("//div[@class='breadcrumb__width']");
                String switchGrade = elementByXPath.findElement(By.xpath("./div[1]/div/span[1]")).getText();
                String switchType = elementByXPath.findElement(By.xpath("./div[2]/div/span[1]")).getText();
                String switchSubject = elementByXPath.findElement(By.xpath("./div[3]/div/span[1]")).getText();
                List<WebElement> breadcrumb__alreayFilter = elementByXPath.findElements(By.xpath("//div[@class='breadcrumb__alreayFilter']"));
                CurriculumEntity.CurriculumEntityBuilder builder = CurriculumEntity.builder()
                        .province(province).switchGrade(switchGrade).switchType(switchType).switchSubject(switchSubject);
                for (int i = 0; i<breadcrumb__alreayFilter.size();i++) {
                    WebElement el = breadcrumb__alreayFilter.get(i);
                    String key = el.findElement(By.xpath("./p[@class='breadcrumb__breadcrumbItem']/span[1]")).getText().replace("：", "");
                    String value = el.findElement(By.xpath("./p[@class='breadcrumb__breadcrumbItem']/span[2]")).getText();
                    if ("学期".equals(key)) {
                        builder.terms(value);
                    } else if ("知识点".equals(key)) {
                        builder.point(value);
                    } else if ("分类".equals(key)) {
                        builder.labels(value);
                    } else if ("进度".equals(key)) {
                        builder.studyPhases(value);
                    } else if ("难度".equals(key)) {
                        builder.difficulties(value);
                    } else if ("时间".equals(key)) {
                        builder.times(value);
                    } else if ("时段".equals(key)) {
                        builder.timeSlots(value);
                    } else if ("版本".equals(key)) {
                        builder.version(value);
                    }
                }
                elementsByXPath.forEach(el -> {
                    String duration = el.findElement(By.xpath("./p[@class='card-title']/span[2]")).getText();
                    String views = el.getAttribute("href");
                    String concreteTime = el.findElement(By.className("card-info__data")).getText();
                    String teacher = el.findElement(By.xpath("./div[@class='teacher-list']/div[1]/p[2]")).getText();
                    String rating = null;
                    try {
                        rating = el.findElement(By.className("card-bottom__price")).findElement(By.tagName("strong")).getText();
                    } catch (NoSuchElementException e) {
                        log.error("没有找到card-bottom__price，已爆满，url:{}", browser.getCurrentUrl());
                    }
                    CurriculumEntity curriculumEntity = builder.duration(duration)
                            .views(views)
                            .concreteTime(concreteTime)
                            .teacher(teacher)
                            .rating(rating).build();
                    save(curriculumEntity);
                });
            }
        } else {
            WebElement elementByXPath = elementByXPaths.get(0);
            String row__label = elementByXPath.findElement(By.className("row__label")).getText();
            List<WebElement> elementsByClass = elementByXPath.findElements(By.className("select-btn"));
            if (StringUtils.equals("学期", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.TERMS.get(item.getText())) {
                        jointUrl(url, "&terms=", XueersiInitBean.TERMS.get(item.getText()));
                    } else {
                        log.error("学期未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            } else if (StringUtils.equals("版本", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.VERSIONS.get(item.getText())) {
                        jointUrl(url, "&versions=", XueersiInitBean.VERSIONS.get(item.getText()));
                    } else {
                        log.error("版本未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            } else if (StringUtils.equals("难度", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.DIFFICULTIES.get(item.getText())) {
                        jointUrl(url, "&difficulties=", XueersiInitBean.DIFFICULTIES.get(item.getText()));
                    } else {
                        log.error("难度未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            } else if (StringUtils.equals("时间", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.TIMES.get(item.getText())) {
                        jointUrl(url, "&times=", XueersiInitBean.TIMES.get(item.getText()));
                    } else {
                        log.error("时间未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            } else if (StringUtils.equals("时段", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.TIMESLOTS.get(item.getText())) {
                        jointUrl(url, "&timeSlots=", XueersiInitBean.TIMESLOTS.get(item.getText()));
                    } else {
                        log.error("时段未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            } else if (StringUtils.equals("知识点", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.KNOWLEDGES.get(item.getText())) {
                        jointUrl(url, "&knowledges=", XueersiInitBean.KNOWLEDGES.get(item.getText()));
                    } else {
                        log.error("知识点未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            } else if (StringUtils.equals("分类", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.LABELS.get(item.getText())) {
                        jointUrl(url, "&labels=", XueersiInitBean.LABELS.get(item.getText()));
                    } else {
                        log.error("分类未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            } else if (StringUtils.equals("进度", row__label)) {
                for (WebElement item : elementsByClass) {
                    if (null != XueersiInitBean.STUDYPHASES.get(item.getText())) {
                        jointUrl(url, "&studyPhases=", XueersiInitBean.STUDYPHASES.get(item.getText()));
                    } else {
                        log.error("进度未配置：url:{}, 选项：{}", url, item.getText());
                    }
                }
            }
        }
    }

    private void jointUrl(StringBuilder url, String key, String value) {
        if (url.toString().contains(key)) {
            url = new StringBuilder(url.toString().substring(0, url.toString().indexOf(key))).append(key).append(value);
        } else {
            url.append(key).append(value);
        }
        if (!url.toString().contains("?")) {
            url = new StringBuilder(url.toString().replace("&", "?"));
        }
        openTab(url.toString());
    }

    private void openTab(String url) {
        browser.executeScript("window.open('"+url+"')");
        ArrayList<String> tabs = new ArrayList<String> (browser.getWindowHandles());
        browser.switchTo().window(tabs.get(tabs.size()-1));
        try {
            syncCourse();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        browser.executeScript("window.close()");
        browser.switchTo().window(tabs.get(tabs.size()-2));
    }

    private void save(CurriculumEntity curriculumEntity) {
        Integer save = xueersiMapper.save(curriculumEntity);
        log.info("插入进度：{}，curriculumEntity：{}", save, curriculumEntity.toString());
    }
}
