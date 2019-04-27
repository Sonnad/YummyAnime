import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sonad on 06.12.17.
 */
public class myFirstTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

    }

    @Test
    public void testBooksList() throws Exception {
        driver.navigate().to("http://localhost:8080/sample");
        (new WebDriverWait(driver, 1)).until((ExpectedCondition<Boolean>) (WebDriver d) -> !(d.getPageSource().contains("Faust23")));
    }

    @Test
    public void testAuthorBooks() throws Exception {
        driver.navigate().to("http://localhost:8080/sample");
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Orwell")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        (new WebDriverWait(driver, 1)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getPageSource().contains("1984")
                && d.getPageSource().contains("Animal Farm")
                && d.getPageSource().contains("A Hanging"));
    }

    @Test
    public void tryLogin() throws Exception {

        driver.navigate().to("http://localhost:8080");
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Авторизация")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("hello");
        Thread.sleep(3000);
        driver.findElement(By.name("login")).sendKeys(Keys.RETURN);
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://localhost:8443/");

    }

    @Test
    public void addBook() throws Exception {
        driver.navigate().to("http://localhost:8080");
        driver.findElement(By.partialLinkText("Авторизация")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("hello");
        driver.findElement(By.name("login")).sendKeys(Keys.RETURN);
        driver.findElement(By.partialLinkText("Список книг")).sendKeys(Keys.RETURN);

        driver.findElement(By.name("bookName")).sendKeys("Test");
        driver.findElement(By.name("bookAuthor")).sendKeys("Goethe");
        driver.findElement(By.name("bookPublisher")).sendKeys("Parka");
        Thread.sleep(3000);
        driver.findElement(By.name("add")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Goethe")).sendKeys(Keys.RETURN);

        Thread.sleep(3000);

        (new WebDriverWait(driver, 1)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getPageSource().contains("Faust")
                && d.getPageSource().contains("Test"));
    }

    @Test
    public void deleteBook() throws Exception {
        driver.navigate().to("http://localhost:8080");
        driver.findElement(By.partialLinkText("Авторизация")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("hello");
        driver.findElement(By.name("login")).sendKeys(Keys.RETURN);
        driver.findElement(By.partialLinkText("Список книг")).sendKeys(Keys.RETURN);

        driver.findElement(By.name("deleteBook")).sendKeys("Test");
        Thread.sleep(3000);
        driver.findElement(By.name("del")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Goethe")).sendKeys(Keys.RETURN);

        Thread.sleep(3000);

        (new WebDriverWait(driver, 1)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getPageSource().contains("Faust"));
    }

}
