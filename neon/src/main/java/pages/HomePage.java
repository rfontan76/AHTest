package pages;

import base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseDriver {


  By searchInputField = By.name("q");
  By searchButton = By.xpath("//input[@name='btnK']");



    public HomePage(WebDriver driver){
      this.driver = driver;
  }

    public  void setSearchText(String text){
     driver.findElement(searchInputField).sendKeys(text);

    }

    public ResultsPage searchButton(){
     driver.findElement(searchButton).sendKeys(Keys.RETURN);
     return  new ResultsPage(driver);
    }

}
