package neonTests;

import analizers.Retry;
import base.BaseDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.ResultsPage;


public class BaseTest extends BaseDriver {

    BaseDriver bd = new BaseDriver();
    public HomePage homePage;
    public ResultsPage resultsPage;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        bd.initialize_driver();
        bd.driver.get("http://www.google.com");
        homePage = new HomePage(bd.driver);
        resultsPage = new ResultsPage(bd.driver);
    }

    @AfterTest
    public void tearDown(){
        bd.driver.close();
        bd.driver.quit();
    }
}
