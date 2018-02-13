package com.example.tests;

import java.util.concurrent.TimeUnit;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class TestClass {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://www.katalon.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
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
        selenium.click("id=SSR_CLSRCH_WRK_CLASS_NBR$9");
        TimeUnit.SECONDS.sleep(1);
        selenium.type("id=SSR_CLSRCH_WRK_CLASS_NBR$9", "39838");
        TimeUnit.SECONDS.sleep(1);
        selenium.click("id=CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH");
        TimeUnit.SECONDS.sleep(2);
        String myText = selenium.getText("//div[@id='win0divSSR_CLSRSLT_WRK_GROUPBOX3$0']/table/tbody/tr/td");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(myText);
        assertEquals("1 class section(s) found", selenium.getText("css=td.PSGROUPBOXLABEL"));
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
