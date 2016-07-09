package tests;

import categories.SlowTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExample {
    Logger log = Logger.getLogger("TestExample");

    @Category(SlowTests.class)
    @Test
    public void exampleTest(){
        log.setLevel(Level.INFO);
        log.info("SlowTest");
    }
}
