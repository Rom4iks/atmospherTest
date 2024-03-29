package atmosphere;

import atmosphere.pageObject.CartPage;
import atmosphere.pageObject.ItemPage;
import atmosphere.pageObject.ItemSearchResult;
import atmosphere.pageObject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddToCartTest {
    private WebDriver webDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.atmosphere.ca/");
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void endBrowser(){
        webDriver.close();
        webDriver.quit();
    }

    @Test
    public void verifyAddToCart() {

        MainPage mainPage = new MainPage(webDriver);
        mainPage.typeIntoSearch("parkas");
        ItemSearchResult itemSearchResult = new ItemSearchResult(webDriver);
        WebDriverWait wait = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [@class ='pagination__info']")));
        itemSearchResult.pickOneItem();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        ItemPage itemPage = new ItemPage(webDriver);

        itemPage.pickColor();
        wait.withTimeout(Duration.ofSeconds(10));
//        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String itemColor = itemPage.colorName();
        wait.withTimeout(Duration.ofSeconds(10));
        itemPage.pickSize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String itemName = itemPage.getItemName();

        itemPage.addItemToCart();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        itemPage.navigateToCart();
        CartPage cartPage = new CartPage(webDriver);
        String cartItemName = cartPage.getName();
        Assert.assertEquals("Wrong ItemName in CART",itemName.toUpperCase(),cartItemName.toUpperCase());
        String cartItemColor = cartPage.getColor();
        Assert.assertEquals("Wrong ItemColor in CART",itemColor.toUpperCase().replaceAll("\\s+",""),cartItemColor.toUpperCase().replaceAll("\\s+",""));
//        String cartItemSize = cartPage.getSize();
//        Assert.assertEquals("Wrong ItemSize in CART",itemSize,cartItemSize);

    }
}
