package inheritance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClass extends BaseTest{


    @Override
    @Before
    public void setUp() throws Exception {
        System.out.println(++i + " - BeforeTestMethod");
        super.setUp();

    }

    @Test
    public void denoMethod1() throws Exception {
        driver.get("http://google.com");
        System.out.println(++i +" - Test1");
    }

    @Test
    public void demoMethod2() throws Exception {
        System.out.println(++i + " - Test2");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        System.out.println(++i + " - AfterTestMethod");
        super.tearDown();
    }
}
