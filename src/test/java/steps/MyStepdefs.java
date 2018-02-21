package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HubsPage;
import pages.PublicationsPage;
import static org.junit.Assert.assertEquals;



public class MyStepdefs {
    protected WebDriver driver;
    PublicationsPage bestweek =  new PublicationsPage(driver);
    HubsPage dev =  new HubsPage(driver);


    @Before("@success")
    public void setupDriver() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After("@success")
    public void stopDriver() throws Throwable {
        driver.close();
    }

    @Пусть("^открыта главная страница habrahabr$")
    public void открытаглавнаястраницаhabrahabr() {
        driver.get("https://habrahabr.ru");
    }

    @Когда("^выбран пункт меню (.*) в потоке$")
    public void выбранПунктМенюРазработкаВПотоке(String arg) {
         By flows = By.xpath(String.format("//span[contains(@class,'default-block__header-title') and text()='Потоки']/parent::div/parent::div/div[@class='default-block__content']/ul/li/a/span[contains(text(),'%s')]",arg));
        driver.findElement(flows).click();
    }

    @Когда("^выбран пункт Лучшие за неделю$")
    public void выбранПунктЛучшиеЗаНеделю() {
        bestweek.SelectBest(driver).click();
        bestweek.SelectWeek(driver).click();
    }

    @То("^получена публикация с максимальным количеством голосов$")
    public void полученаПубликацияСМаксимальнымКоличествомГолосов() {
        System.out.println(bestweek.MaxRatingWeek(driver).getText());
    }

    @Когда("^выбран раздел (.*)")
    public void выбранРаздел(String arg) {
        By hubs = By.xpath(String.format("//a[contains(@class,'nav-links__item-link') and contains(text(),'%s')]",arg));
        driver.findElement(hubs).click();
    }

    @Когда("^выбрана категория (.*)$")
    public void выбранаКатегория(String arg) {
        dev.SelectCategory(driver, arg).click();
    }

    @Когда("^набрано в поиске (.*)$")
    public void набраноВПоиске(String arg) throws Throwable{
        dev.Search(driver).sendKeys(arg);
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("filled")));
    }

    @То("^результаты поиска совпадают$")
    public void результатыПоискаСовпадают() {
        //Результаты поиска по слову "Тестирование"
        By searchResult = By.xpath("//a[contains(@class,'list-snippet__title-link')]");

        assertEquals("Тестирование мобильных приложений", driver.findElements(searchResult).get(0).getText());
        assertEquals("Тестирование игр", driver.findElements(searchResult).get(1).getText());
        assertEquals("Тестирование IT-систем", driver.findElements(searchResult).get(2).getText());
        assertEquals("Тестирование веб-сервисов", driver.findElements(searchResult).get(3).getText());
    }
}





