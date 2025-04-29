package uppgift1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService service = new CalculatorService();
        int result = service.addNumbers(4, 6);
        System.out.println("Resultat: 4 + 6 = " + result);
        assertEquals(10, result);
    }

    @Test
    public void testAdd_withNegativeNumbers() {
        CalculatorService service = new CalculatorService();
        int result = service.addNumbers(-3, -2);
        System.out.println("Resultat: -3 + (-2) = " + result);
        assertEquals(-5, result);
    }

    @Test
    public void testAdd_withMixedSigns() {
        CalculatorService service = new CalculatorService();
        int result = service.addNumbers(-4, 6);
        System.out.println("Resultat: -4 + 6 = " + result);
        assertEquals(2, result);
    }

    @Test
    public void testAdd_withZero() {
        CalculatorService service = new CalculatorService();
        int result = service.addNumbers(0, 0);
        System.out.println("Resultat: 0 + 0 = " + result);
        assertEquals(0, result);
    }

    @Test
    public void testAdd_withLargeNumbers() {
        CalculatorService service = new CalculatorService();
        int result = service.addNumbers(1000000, 2000000);
        System.out.println("Resultat: 1 000 000 + 2 000 000 = " + result);
        assertEquals(3000000, result);
    }
}
