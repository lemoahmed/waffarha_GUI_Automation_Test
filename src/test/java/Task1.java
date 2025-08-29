import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Task1 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void searchResult() {
        driver.get("https://duckduckgo.com/");

        WebElement searchInput = driver.findElement(By.id("searchbox_input"));
        searchInput.sendKeys("TestNG");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("listbox--«ri»")));
        String actual = driver.findElement(By.xpath("(//ul[@id='listbox--«ri»']/li)[4]")).getText();
        System.out.println(actual);

        String expected = "TestNG Tutorial";

        assertEquals(actual, expected);
    }

    @AfterMethod
    public void endTask() {

            driver.quit();
    }
}
