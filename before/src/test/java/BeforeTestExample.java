import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BeforeTestExample {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://google.com");
    }

    @Test
    public void demoTest (){}

    @Test
    public void demoTest2 (){}

    @After
    public void tearDown() throws Exception {
        driver.quit();
        System.out.printf("TestFinished \n");
    }
}
