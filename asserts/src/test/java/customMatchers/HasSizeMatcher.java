package customMatchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Collection;

public class HasSizeMatcher extends TypeSafeMatcher<Collection<? extends  Object>> {
    private Matcher<Integer> matcher;

    public HasSizeMatcher(Matcher<Integer> matcher){
        this.matcher = matcher;
    }

    protected boolean matchesSafely(Collection<? extends Object> collection) {
         return matcher.matches(collection.size());
    }

    public void describeTo(Description description) {
        description.appendText("a collection with a size that is");
        matcher.describeTo(description);
    }
}
