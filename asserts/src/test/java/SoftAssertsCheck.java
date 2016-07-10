import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertsCheck {

    @Test
    public void allAssertsShouldBeDoneBeforeTestFail() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2, "objects are not equal");
        softAssert.assertFalse(true, "expected  false but recieved true");
        softAssert.assertFalse(true);

        softAssert.assertAll();
    }
}
