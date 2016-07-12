package inheritance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    static Integer i = 0;
    protected static WebDriver driver;

    @BeforeClass
    public static void setUpClass() throws Exception {
       driver = new FirefoxDriver();
        System.out.println(++i + " - Base setUpClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println(++i + " - Base setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println(++i + " - Base tearDown");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        driver.quit();
        System.out.println(++i + " - Base tearDownClass");
    }
}
