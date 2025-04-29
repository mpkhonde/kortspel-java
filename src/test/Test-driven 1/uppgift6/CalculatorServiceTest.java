package uppgift6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    @Test
    public void testParseAndAdd_shouldReturnCorrectResult() {
        assertEquals(9, service.parseAndAdd("4", "5"));
    }

    @Test
    public void testAddDoubles_shouldNotBeExactlyEqual() {
        double result = service.addDoubles(0.1, 0.2);
        assertFalse(result == 0.3); // Flyttalsfälla
    }

    @Test
    public void testAreClose_shouldBeTrueForFloatingPoint() {
        assertTrue(service.areClose(0.1 + 0.2, 0.3));
    }
}
