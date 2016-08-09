import org.junit.Test;


public class GlobalTimeout {

    @Test(timeout=5000)
    public void shouldFailafter5Seconds(){
        for(;;);
    }
}
