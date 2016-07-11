import org.hamcrest.Matcher;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static customMatchers.MyMatchers.hasSize;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.collection.IsIn.isIn;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.number.OrderingComparison.greaterThan;
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
    @Test
    public void  notInRange(){
        String [] colors = new String[]{"red","green","blue"};
        String myColor = "red";
        assertThat(myColor, not(isIn(colors)));
    }

    @Test
    public void  listShouldHaveAnItem(){
        List<String> colors = Arrays.asList("red","green","blue");
        String myColor = "red";
        assertThat(colors, hasItem(myColor));
        assertThat(colors, hasItems("green","red"));
        assertThat(colors, hasItems(anyOf(is("red"),is("Red)"))));
        assertThat("red,green,blue", either(containsString("yellow")).or(containsString("red")));
        assertThat(colors, everyItem(containsString("e")));
    }

    @Test
    public void  combiningMatchers(){
        List<String> colors = Arrays.asList("red","green","blue");
        String myColor = "red";
        assertThat(colors, allOf(hasItem(myColor)
                ,hasItems("green","red")
                ,hasItems(anyOf(is("red"),is("Red)")))
                ,everyItem(containsString("e"))));
    }
    @Test
    public void  combinableMatchersExample(){
        assertThat(7, not(either((equalTo(3))).or(equalTo(4))));
        assertThat(new BigDecimal(7.22),
                is(closeTo(
                        new BigDecimal(7.12),new BigDecimal(0.33))));
        assertThat(new BigDecimal(7.00), greaterThan(new BigDecimal(6.98)));
    }

    @Test
    public void hasPropertyAndCustomMatchers() {
        List<Stakeholder> stackeHolders = new ArrayList<Stakeholder>();
        stackeHolders.add(new Stakeholder("Health Care"){});
        stackeHolders.add(new Stakeholder("Auto Service"));

        Matcher<Stakeholder> calledHealthCare = hasProperty("name",is("Health Care"));

        assertThat(stackeHolders,hasItems(calledHealthCare));
    }

    public class Stakeholder {
        private String name;
        public Stakeholder(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    @Test
    public void  customMatcher(){
        List<String> colors = Arrays.asList("red","green","blue");
        assertThat(colors,hasSize(greaterThan(2)));
        assertThat(colors,hasSize(is(3)));
    }

}
