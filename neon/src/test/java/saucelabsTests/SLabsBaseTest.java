package saucelabsTests;

import base.BaseDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.ResultsPage;

import java.net.MalformedURLException;
import java.net.URL;


public class SLabsBaseTest extends BaseDriver {

    BaseDriver bd = new BaseDriver();
    public HomePage homePage;
    public ResultsPage resultsPage;

    String sauceUserName = "rfontan76";
    String sauceAccessKey = "68b2a63b-f30e-4da7-af4c-c46704b56cfe";

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //set your user name and access key to run tests in Sauce
        capabilities.setCapability("username", sauceUserName);

        //set your sauce labs access key
        capabilities.setCapability("accessKey", sauceAccessKey);

        //set browser to Safari
        capabilities.setCapability("browserName", "Safari");

        //set operating system to macOS version 10.13
        capabilities.setCapability("platform", "macOS 10.13");

        //set the browser version to 11.1
        capabilities.setCapability("version", "11.1");

        driver = new RemoteWebDriver(new URL("https://ondemand.saucelabs.com:443/wd/hub"), capabilities);

        driver.navigate().to("http://www.google.com");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
