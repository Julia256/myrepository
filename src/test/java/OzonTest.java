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
import java.lang.*;

public class OzonTest {

    WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void Test() throws Exception{
        driver.get("https://ozon.ru");

        if (!driver.findElement(By.className("bPage")).isDisplayed()) {
            driver.findElement(By.className("eDYbanner_close")).click();
        }

        driver.findElement(By.className("eHeaderCatalogButton_Text")).click();
        List<WebElement> menuLinks = driver.findElements(By.className("eOzonCatalog_1LevelLinkText"));
        for (WebElement link : menuLinks){
            if("Книги".equals(link.getText()))
            {
                link.click();
                break;
            }
        }

        List<WebElement> bestSeller = driver.findElements(By.className("bTextLink"));
        for (WebElement best : bestSeller){
            if("Бестселлеры".equals(best.getText()))
            {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("window.scrollTo("+best.getLocation().x+", "+best.getLocation().y+");");
                WebElement webelement = best.findElements(By.xpath("//parent::div[@class='eUniversalShelf_MainTitle']/parent::div[@class='bUniversalShelf']/descendant::a[@class='eShelfTile_Link']")).get(0);
                if (!driver.findElement(By.className("bPage")).isDisplayed()) {driver.findElement(By.className("eDYbanner_close")).click();}
                webelement.click();
                break;
            }
        }

        //Добавить книгу в корзину
        if (!driver.findElement(By.className("bPage")).isDisplayed()) {driver.findElement(By.className("eDYbanner_close")).click();}
        driver.findElement(By.className("bSaleBlockButton")).click();

        //Добавить еще один экземпляр книги
        if (!driver.findElement(By.className("bPage")).isDisplayed()) {driver.findElement(By.className("eDYbanner_close")).click();}
        driver.findElement(By.className("mPlusOne")).click();

        //Перейти в корзину
        if (!driver.findElement(By.className("bPage")).isDisplayed()) {driver.findElement(By.className("eDYbanner_close")).click();}
        driver.findElement(By.xpath("//div[contains(@class,'eMyOzon_Item_Bottom') and text()='Корзина']/parent::a")).click();

        Thread.sleep(5000);

        //Удалить 1 товар из корзины
        driver.findElement(By.className("mMinus")).click();

        //Удалить 1 товар из корзины
        driver.findElement(By.className("jsChild_DOM_remove_button")).click();
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}