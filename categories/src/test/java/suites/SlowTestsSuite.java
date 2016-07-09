package suites;

import categories.SlowTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.TestExample;
import tests.TestSample;

@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Suite.SuiteClasses( { TestExample.class, TestSample.class })
public class SlowTestsSuite {
}

