package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PublicationsPage {
    private WebDriver driver;

    public PublicationsPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement SelectBest(WebDriver driver){
        //Раздел "Лучшие"
        return driver.findElement(By.xpath("//span[contains(@class,'tabs-menu__item-text') and contains(text(),'Лучшие')]/parent::a"));
    }
    public WebElement SelectWeek(WebDriver driver){
        //Раздел "Неделя"
        return driver.findElement(By.xpath("//a[contains(@class,'toggle-menu__item-link') and contains(text(),'Неделя')]"));
    }
    public WebElement MaxRatingWeek(WebDriver driver){
        //Публикация с большим количеством голосов
        return driver.findElement(By.xpath("//span[contains(@class,'voting-wjt__counter')][1]/parent::div/parent::li/parent::ul/parent::footer/parent::article/h2[contains(@class,'post__title')]/a[contains(@class,'post__title_link')]"));
    }
}
