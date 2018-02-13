package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestClass2 {
    private Selenium selenium;
    public String courseName;
    public String classN;
    public String sectionNumber;
    public String location;
    public String meetingDates;
    public String DateTime;
    public String allText;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chris\\Desktop\\proj\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.katalon.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
        selenium.open("https://bcsweb.is.berkeley.edu/psc/bcsprd_pub/EMPLOYEE/HRMS/c/COMMUNITY_ACCESS.CLASS_SEARCH.GBL?");
        selenium.click("name=DERIVED_CLSRCH_SSR_EXPAND_COLLAPS$149$$IMG$1");
        TimeUnit.SECONDS.sleep(1);
        selenium.click("id=SSR_CLSRCH_WRK_INCLUDE_CLASS_DAYS$7");
        selenium.select("id=SSR_CLSRCH_WRK_INCLUDE_CLASS_DAYS$7", "label=include any of these days");
        TimeUnit.SECONDS.sleep(1);
        selenium.click("id=SSR_CLSRCH_WRK_INCLUDE_CLASS_DAYS$7");
        TimeUnit.SECONDS.sleep(1);
        selenium.click("id=SSR_CLSRCH_WRK_MON$7");
        selenium.click("id=SSR_CLSRCH_WRK_TUES$7");
        selenium.click("id=SSR_CLSRCH_WRK_WED$7");
        selenium.click("id=SSR_CLSRCH_WRK_THURS$7");
        selenium.click("id=SSR_CLSRCH_WRK_FRI$7");
        selenium.click("id=SSR_CLSRCH_WRK_SAT$7");
        selenium.click("id=SSR_CLSRCH_WRK_SUN$7");
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void testUntitledTestCase(int classNbr) throws Exception {
        String classNumber = Integer.toString(classNbr);
        selenium.click("id=SSR_CLSRCH_WRK_CLASS_NBR$9");
        TimeUnit.SECONDS.sleep(1);
        selenium.type("id=SSR_CLSRCH_WRK_CLASS_NBR$9", classNumber);
        TimeUnit.SECONDS.sleep(1);
        selenium.click("id=CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH");
        TimeUnit.SECONDS.sleep(2);
        allText = selenium.getText("//div[@id='win0divSSR_CLSRSLT_WRK_GROUPBOX3$0']/table/tbody/tr/td");
        courseName = selenium.getText("id=win0divSSR_CLSRSLT_WRK_GROUPBOX2GP$0");
        classN = selenium.getText("css=td.PSLEVEL3GRIDODDROW.PSGRIDFIRSTCOLUMN");
        sectionNumber = selenium.getText("id=MTG_CLASSNAME$0");
        location = selenium.getText("id=MTG_ROOM$0");
        meetingDates = selenium.getText("id=MTG_TOPIC$0");
        DateTime = selenium.getText("id=MTG_DAYTIME$0");
        TimeUnit.SECONDS.sleep(1);
        assertEquals("1 class section(s) found", selenium.getText("css=td.PSGROUPBOXLABEL"));
        selenium.click("id=CLASS_SRCH_WRK2_SSR_PB_MODIFY");
        TimeUnit.SECONDS.sleep(2);
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
