package atmosphere.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ItemSearchResult {

    private WebDriver webDriver;
    private Random rand = new Random();

    @FindBys({ @FindBy (xpath = "//img [@class = 'product-grid-image']")
    })
    private List<WebElement> seachResultList;

    public ItemSearchResult(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void pickOneItem() {
       seachResultList.get(rand.nextInt(seachResultList.size())).click();

    }
}
