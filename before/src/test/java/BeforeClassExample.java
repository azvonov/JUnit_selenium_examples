import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BeforeClassExample {
   public static WebDriver driver;

    //junit requires beforeClass to be static
    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://google.com");
    }

    @Test
    public void demoTest (){}

    @Test
    public void demoTest2 (){}

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        System.out.printf("TestFinished \n");
    }
}
