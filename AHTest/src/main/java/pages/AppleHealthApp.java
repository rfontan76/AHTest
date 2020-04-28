package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AppleHealthApp extends BasePage {

    public AppleHealthApp(AppiumDriver driver){
        super(driver);

    }

    @iOSXCUITFindBy(className = "//XCUIElementTypeButton[@name=\"Edgar\"]")
    private IOSElement button;

    @iOSXCUITFindBy(className = "//XCUIElementTypeButton[@name=\"Edgar\"]")
    private IOSElement edgarLink;

    public boolean isButtonDisplayed(){
        return button.isDisplayed();
    }
    public boolean isLinkIsVisible(){
        return edgarLink.isDisplayed() && edgarLink.isEnabled();
    }
}
