import org.junit.Test;


public class GlobalTimeout {
//    @Rule
//    public Timeout timeout = new Timeout(5000);

    @Test(timeout=5000)
    public void shouldFailafter5Seconds(){
        for(;;);
    }
}
