import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertsCheck {

    // NOTE - For best exception logging use testng version >= 6.9.10
    @Test
    public void allAssertsShouldBeDoneBeforeTestFail() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 2, "objects are not equal");
        softAssert.assertFalse(true, "expected  false but recieved true");
        softAssert.assertFalse(true);

        softAssert.assertAll();
    }
}
