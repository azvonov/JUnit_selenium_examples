import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;

public class UsesErrorCollector {
    //Собирает все ошибки на протяжении теста. После окончания теста выводит лог.
    //Таким образом тест не валится на первом неудачном ассерте и видна вся картина

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void example() {
        collector.checkThat(1, equalTo(2));
        collector.checkThat("a", equalTo("b"));
    }
}
