package atmosphere.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver webDriver;
    @FindBy(xpath = "//input[@placeholder='Search for shoes, jackets, water bottles and more']")
    private WebElement searchInput;

    public void typeIntoSearch(String itemName) {
        searchInput.sendKeys(itemName.toUpperCase(), Keys.ENTER);

    }

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
