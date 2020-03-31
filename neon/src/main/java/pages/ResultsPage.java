package pages;

import base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BaseDriver {


  By searchInputField = By.name("q");
  By searchButton = By.xpath("//input[@name='btnK']");


    public ResultsPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getUrl(){
     String url = driver.getCurrentUrl();
     return url;
    }


}
