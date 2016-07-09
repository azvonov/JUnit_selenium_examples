import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ParametrizedTests {

    private static WebDriver driver;
    private static StringBuffer verificationErrors = new
            StringBuffer();

    private String height;
    private String weight;
    private String bmi;
    private String bmiCategory;

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(
                new Object[][]{
                        {"160", "45", "17.6", "Underweight"},
                        {"168", "70", "24.8", "Normal"},
                        {"181", "89", "27.2", "Overweight"},
                        {"178", "100", "31.6", "Obesity"}
                }
        );
    }

    public ParametrizedTests(String height, String weight, String bmi, String bmiCategory) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bmiCategory = bmiCategory;
    }

    @Before
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
    }
        @Test
        public void testBMICalculator ()throws Exception {
            //Get the Height element and set the value using parameterised
            //height variable
            WebElement heightField = driver.findElement(By.name("heightCMS"));
            heightField.clear();
            heightField.sendKeys(height);

            //Get the Weight element and set the value using parameterised
            //Weight variable
            WebElement weightField = driver.findElement(By.name("weightKg"));
            weightField.clear();
            weightField.sendKeys(weight);

            //Click on Calculate Button
            WebElement calculateButton = driver.findElement(By.id("Calculate"));
            calculateButton.click();
            try {
                //Get the Bmi element and verify its value using parameterised
                //bmi variable
                WebElement bmiLabel = driver.findElement(By.name("bmi"));
                assertEquals(bmi, bmiLabel.getAttribute("value"));

                //Get the Bmi Category element and verify its value using
                //parameterised bmiCategory variable
                WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
                assertEquals(bmiCategory, bmiCategoryLabel.
                        getAttribute("value"));

            } catch (Error e) {
                //Capture and append Exceptions/Errors
                verificationErrors.append(e.toString());
                System.err.println("Assertion Fail " + verificationErrors.
                        toString());
            }
        }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
