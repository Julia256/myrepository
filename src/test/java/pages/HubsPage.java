package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HubsPage {
    private WebDriver driver;

    public HubsPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement SelectCategory(WebDriver driver, String arg){
        return driver.findElement(By.xpath(String.format("//span[contains(@class,'stacked-menu__item-text') and contains(text(),'%s')]/parent::a", arg)));
    }
    public WebElement Search(WebDriver driver){
        return driver.findElement(By.id("hubs_suggest"));
    }
}
