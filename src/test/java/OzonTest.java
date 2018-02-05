import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;


public class OzonTest {

    WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Test() throws Exception{
        driver.manage().window().maximize();
        driver.get("https://ozon.ru");
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);

        List<WebElement> menuLinks = driver.findElements(By.cssSelector(".eHeaderCategoryLinks_Link"));
        for (WebElement link : menuLinks){
            if("Книги".equals(link.getText()))
            {
                link.click();
                break;
            }
        }
        Thread.sleep(3000);

        List<WebElement> bestSeller = driver.findElements(By.className("bTextLink"));
        for (WebElement best : bestSeller){
            if("Бестселлеры".equals(best.getText()))
            {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("window.scrollTo("+best.getLocation().x+", "+best.getLocation().y+");");
                Thread.sleep(9000);
                driver.findElement(By.className("eDYbanner_close")).click();
                best.findElements(By.xpath("//parent::div[@class='eUniversalShelf_MainTitle']/parent::div[@class='bUniversalShelf']/descendant::a[@class='eShelfTile_Link']")).get(0).click();
                break;
            }
        }
        Thread.sleep(3000);

        //Добавить книгу в корзину
        driver.findElement(By.className("bSaleBlockButton")).click();
        Thread.sleep(3000);

        //Добавить еще один экземпляр книги
        driver.findElement(By.className("mPlusOne")).click();
        Thread.sleep(8000);

        //Перейти в корзину
        driver.findElement(By.className("mCart")).click();
        Thread.sleep(10000);

        //Удалить 1 товар из корзины
        driver.findElement(By.className("mMinus")).click();
        Thread.sleep(5000);

        //Удалить 1 товар из корзины
        driver.findElement(By.className("mRemove")).click();
        Thread.sleep(5000);
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}