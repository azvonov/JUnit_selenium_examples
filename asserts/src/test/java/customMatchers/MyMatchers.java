package customMatchers;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import java.util.Collection;

public class MyMatchers {
    @Factory
    public static Matcher<Collection<? extends Object>> hasSize(Matcher<Integer> matcher){
        return new HasSizeMatcher(matcher);
    }
}
