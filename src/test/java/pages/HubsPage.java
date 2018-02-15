package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HubsPage {
    private WebDriver driver;

    //Строка поиска
    By search = By.id("hubs_suggest");


    public HubsPage(WebDriver driver) {
        this.driver = driver;
    }
    public HubsPage ClickCategory(WebDriver driver, String arg) throws InterruptedException {
        //Найти раздел
        By dev = By.xpath(String.format("//span[contains(@class,'stacked-menu__item-text') and contains(text(),'%s')]/parent::a", arg));
        driver.findElement(dev).click();
        return this;
    }
    public HubsPage Search(WebDriver driver, String text) throws InterruptedException {
        driver.findElement(search).sendKeys(text);
        return this;
    }
}
