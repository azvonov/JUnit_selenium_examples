import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class VerifierRule {
    private List<String> systemErrorMessages = new ArrayList<String>();
    @Rule
    public TestRule verifier = new Verifier(){
        @Override
        protected void verify() throws Throwable {
            assertThat(systemErrorMessages.size(), is(0));
        }
    };
  @Test
  public void afterThisTestVerifyerShouldCheckSizeOfMessages (){
  }

  @Test
  public void afterThisTestVeryfierShouldCheckSizeOfMessagesAgain (){
      systemErrorMessages.add("error message");
  }
}
