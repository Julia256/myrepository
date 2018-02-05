import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.String;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;


public class WebDriverTest {

    WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void ChromeDriverTest() throws Exception{
        driver.get("https://habrahabr.ru");
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Компании")).click();
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);

        driver.findElement(By.id("companies_suggest")).sendKeys("Google");
        Thread.sleep(2000);

        String Name = driver.findElement(By.className("searched-item")).getText();
        String Rating = driver.findElement(By.className("stats__counter_rating")).getText();
        String SubscribersCount = driver.findElement(By.className("stats__counter_subscribers")).getText();
        Thread.sleep(1000);

        System.out.println("Название компании из списка: " + Name);
        System.out.println("Рейтинг: " + Rating);
        System.out.println("Количество подписчиков: " + SubscribersCount);
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}