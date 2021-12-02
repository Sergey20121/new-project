import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestComputer {

    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resourses\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test

    public void testFeedBack()
    {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var nameLocator = By.cssSelector(".data.text");
        driver.findElement(nameLocator);
        var buttonLocator = By.id("comment");
        var messageLocator = By.className("message-header");
        driver.findElement(nameLocator).sendKeys("Vasya");
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("не отобразился текст",
                driver.findElement(messageLocator).isDisplayed());
    }
}
