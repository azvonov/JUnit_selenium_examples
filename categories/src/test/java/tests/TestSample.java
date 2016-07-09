package tests;

import categories.FastTests;
import categories.SlowTests;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSample {
    Logger log = Logger.getLogger("TestSample");

    @Category(FastTests.class)
    @Test
    public void sampleTest() {
        log.setLevel(Level.INFO);
        log.info("FastTest");
    }
}
