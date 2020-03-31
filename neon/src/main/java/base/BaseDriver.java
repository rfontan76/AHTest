package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import properties.PropertiesFile;
import java.util.concurrent.TimeUnit;


public class BaseDriver {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    public static String browserName = null;

    public WebDriver initialize_driver(){

        PropertiesFile.getBrowserType();

    if(browserName.equalsIgnoreCase("chrome")) {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
   }
    if(browserName.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    if(browserName.equalsIgnoreCase("headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tdriver.set(driver);
        return getDriver();
    }


    public static synchronized WebDriver getDriver(){

        return  tdriver.get();
    }
}
