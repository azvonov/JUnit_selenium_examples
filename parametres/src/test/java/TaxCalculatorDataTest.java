import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class TaxCalculatorDataTest {

    TaxCalculator mockedTaxCalculator = mock(TaxCalculator.class);


    private Double income;
    private Double expectedTax;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0.00, 0.00},
                {10000.00, 1250.00},
                {1400.00, 1750.00}}
        );
    }

    public TaxCalculatorDataTest(Double income, Double expectedTax) {
        this.income = income;
        this.expectedTax = expectedTax;
        mockingRules();
    }
    private void mockingRules(){
        when(mockedTaxCalculator.calculateTax(0.00)).thenReturn(0.00);
        when(mockedTaxCalculator.calculateTax(10000.00)).thenReturn(1252.00);
        when(mockedTaxCalculator.calculateTax(1400.00)).thenReturn(1750.00);
    }

    @Test
    public void shouldCalculateCorrectTax (){
       Assert.assertEquals(expectedTax, mockedTaxCalculator.calculateTax(income));
    }
}
