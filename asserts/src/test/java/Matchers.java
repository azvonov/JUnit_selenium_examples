import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class Matchers {


    @Test
    public void thisIsAStandartAssert() {
        assertEquals("six".length(), 4);
    }

    @Test
    public void thisIsASimpleHamcrestCase() {

        assertThat("six".length(), equalTo(4));

        assertThat("six".length(), is(equalTo(4)));
    }
}
