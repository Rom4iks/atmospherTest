package atmosphere.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//a[@class='sc-product__title-link']")
    private WebElement itemNameCART;
    @FindBy(xpath = "//span [@class='sc-product__property__name' and contains (text(),'Colour')]")
    private WebElement colorOfItemCART;
    @FindBy(xpath = "//span [@class='sc-product__property__name' and contains (text(),'Size')]")
    private WebElement sizeOfItemCART;

    public String getColor(){
      return   colorOfItemCART.getText();
    }
    public String getName(){
return itemNameCART.getText();
    }
    public String getSize(){
return sizeOfItemCART.getText();
    }

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

}
