package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void открытаглавнаястраницаhabrahabr() throws Throwable {
        driver.get("https://habrahabr.ru");
    }

    @Когда("^выбран пункт меню (.*) в потоке$")
    public void выбранПунктМенюРазработкаВПотоке(String arg) throws Throwable {
         By flows = By.xpath(String.format("//span[contains(@class,'default-block__header-title') and text()='Потоки']/parent::div/parent::div/div[@class='default-block__content']/ul/li/a/span[contains(text(),'%s')]",arg));
        driver.findElement(flows).click();
    }

    @Когда("^выбран пункт Лучшие за неделю$")
    public void выбранПунктЛучшиеЗаНеделю() throws Throwable {
        bestweek.ClickBestWeek(driver);
        Thread.sleep(3000);
    }

    @То("^получена публикация с максимальным количеством голосов$")
    public void полученаПубликацияСМаксимальнымКоличествомГолосов() throws Throwable {
        bestweek.GetMaxRatingWeek(driver);
    }

    @Когда("^выбран раздел (.*)")
    public void выбранРаздел(String arg) throws Throwable {
        By hubs = By.xpath(String.format("//a[contains(@class,'nav-links__item-link') and contains(text(),'%s')]",arg));
        driver.findElement(hubs).click();
    }

    @Когда("^выбрана категория (.*)$")
    public void выбранаКатегория(String arg) throws Throwable {
        dev.ClickCategory(driver, arg);
    }

    @Когда("^набрано в поиске (.*)$")
    public void набраноВПоиске(String arg) throws Throwable {
        dev.Search(driver, arg);
        Thread.sleep(3000);
    }

    @То("^результаты поиска совпадают$")
    public void результатыПоискаСовпадают() throws Throwable {
        //Результаты поиска по слову "Тестирование"
        By searchResult = By.xpath("//a[contains(@class,'list-snippet__title-link')]");

        assertEquals("Тестирование мобильных приложений", driver.findElements(searchResult).get(0).getText());
        assertEquals("Тестирование игр", driver.findElements(searchResult).get(1).getText());
        assertEquals("Тестирование IT-систем", driver.findElements(searchResult).get(2).getText());
        assertEquals("Тестирование веб-сервисов", driver.findElements(searchResult).get(3).getText());
    }
}





