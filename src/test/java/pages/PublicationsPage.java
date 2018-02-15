package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class PublicationsPage {
    private WebDriver driver;

    //Раздел "Лучшие"
    By best = By.xpath("//span[contains(@class,'tabs-menu__item-text') and contains(text(),'Лучшие')]/parent::a");
    //Раздел "Неделя"
    By bestWeek = By.xpath("//a[contains(@class,'toggle-menu__item-link') and contains(text(),'Неделя')]");
    //Публикация с большим количеством голосов
    By maxRating = By.xpath("//span[contains(@class,'voting-wjt__counter')][1]/parent::div/parent::li/parent::ul/parent::footer/parent::article/h2[contains(@class,'post__title')]/a[contains(@class,'post__title_link')]");

    public PublicationsPage(WebDriver driver) {
        this.driver = driver;
    }
    public PublicationsPage ClickBestWeek(WebDriver driver) throws InterruptedException {
        driver.findElement(best).click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.findElement(bestWeek).click();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        return this;
    }
    public void GetMaxRatingWeek(WebDriver driver) throws InterruptedException {
        System.out.println(driver.findElement(maxRating).getText());
    }
}
