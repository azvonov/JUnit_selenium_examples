import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;

import static junit.framework.TestCase.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WatchmanRule {

    //добавляет указанное действие после окончания теста
    //в зависимоти от результата теста, действия могут быть разные

    public static String watchLog = "";

    @Rule
    public TestRule watchman = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
           watchLog += description.getMethodName() + " succeded  \n";
        }

        @Override
        protected void failed(Throwable e, Description description) {
            watchLog += description.getMethodName() + " failed  \n";
        }
    };

    @Test
    public void thisMethodSucceds (){}
    @Test
    public void thisMethodFails (){
        fail();
    }

    @Ignore("Test is ignored as a demonstration")
    @Test
    public void demonstration (){

    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.printf(watchLog);
    }
}
