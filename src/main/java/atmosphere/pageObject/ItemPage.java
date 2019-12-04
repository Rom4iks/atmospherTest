package atmosphere.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ItemPage {

    private WebDriver webDriver;
    private Random rand = new Random();

    @FindBy(xpath = "//button [@class = 'add-cart product-detail__button product-detail__button-icon']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a [@href = '/shopping-cart.html' and @class = 'header-cart__trigger drawer-ui__toggle']")
    private WebElement clickOnCartIcon;

    @FindBy(xpath = "//h1 [@class ='global-page-header__title']")
    private  WebElement itemName;

    @FindBys({
            @FindBy (xpath = "//a [@data-value and @data-control-type ='size' and not (@class = 'option-tiles__item option-tiles__item--out-of-stock')]")})
    private List<WebElement> sizeItemList;

    @FindBys({
            @FindBy (xpath = "//a [@data-value and @data-control-type ='color']")})
    private List<WebElement> colorItemList;
    @FindBy(xpath = "//h3 [@class = 'input-title product-detail__options-title']")
    private WebElement colorText;


    public void pickColor() {
        WebElement randomColor = colorItemList.get(rand.nextInt(colorItemList.size()));
        randomColor.click();
    }
    public String colorName(){
        return colorText.getText();
    }

    public void   pickSize() {
        WebElement randomSize = sizeItemList.get(rand.nextInt(sizeItemList.size()));
        randomSize.click();
    }

    public void addItemToCart() {
        addToCartButton.click();
    }

    public void navigateToCart() {
    clickOnCartIcon.click();
    }
    public String getItemName(){
       return itemName.getText();
    }
    public ItemPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
