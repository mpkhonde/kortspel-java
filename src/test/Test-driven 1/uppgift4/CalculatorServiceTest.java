package uppgift4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    // Addition
    @Test
    public void testAdd_shouldReturnCorrectSum() {
        int result = service.addNumbers(5, 7);
        System.out.println("Addition: 5 + 7 = " + result);
        assertEquals(12, result);
    }

    @Test
    public void testAdd_withNegativeNumbers() {
        int result = service.addNumbers(-3, -7);
        System.out.println("Addition med negativa tal: -3 + (-7) = " + result);
        assertEquals(-10, result);
    }

    @Test
    public void testAdd_withZero() {
        int result = service.addNumbers(0, 0);
        System.out.println("Addition med noll: 0 + 0 = " + result);
        assertEquals(0, result);
    }

    @Test
    public void testAdd_withLargeNumbers() {
        int result = service.addNumbers(1_000_000, 2_000_000);
        System.out.println("Addition med stora tal: 1 000 000 + 2 000 000 = " + result);
        assertEquals(3_000_000, result);
    }

    // Subtraktion
    @Test
    public void testSubtract_shouldReturnCorrectDifference() {
        int result = service.subtractNumbers(10, 4);
        System.out.println("Subtraktion: 10 - 4 = " + result);
        assertEquals(6, result);
    }

    @Test
    public void testSubtract_withNegativeNumbers() {
        int result = service.subtractNumbers(-10, -5);
        System.out.println("Subtraktion med negativa tal: -10 - (-5) = " + result);
        assertEquals(-5, result);
    }

    @Test
    public void testSubtract_withZero() {
        int result = service.subtractNumbers(0, 0);
        System.out.println("Subtraktion med noll: 0 - 0 = " + result);
        assertEquals(0, result);
    }

    @Test
    public void testSubtract_withLargeNumbers() {
        int result = service.subtractNumbers(2_000_000, 1_000_000);
        System.out.println("Subtraktion med stora tal: 2 000 000 - 1 000 000 = " + result);
        assertEquals(1_000_000, result);
    }

    // Multiplikation
    @Test
    public void testMultiply_shouldReturnCorrectProduct() {
        int result = service.multiplyNumbers(3, 5);
        System.out.println("Multiplikation: 3 * 5 = " + result);
        assertEquals(15, result);
    }

    @Test
    public void testMultiply_withNegativeNumbers() {
        int result = service.multiplyNumbers(-4, 6);
        System.out.println("Multiplikation med negativt tal: -4 * 6 = " + result);
        assertEquals(-24, result);
    }

    @Test
    public void testMultiply_withZero() {
        int result = service.multiplyNumbers(0, 999);
        System.out.println("Multiplikation med noll: 0 * 999 = " + result);
        assertEquals(0, result);
    }

    @Test
    public void testMultiply_withLargeNumbers() {
        int result = service.multiplyNumbers(1_000, 1_000);
        System.out.println("Multiplikation med stora tal: 1000 * 1000 = " + result);
        assertEquals(1_000_000, result);
    }

    // Division
    @Test
    public void testDivide_shouldReturnCorrectQuotient() {
        int result = service.divideNumbers(20, 4);
        System.out.println("Division: 20 / 4 = " + result);
        assertEquals(5, result);
    }

    @Test
    public void testDivide_withNegativeNumbers() {
        int result = service.divideNumbers(-20, 4);
        System.out.println("Division med negativt tal: -20 / 4 = " + result);
        assertEquals(-5, result);
    }

    @Test
    public void testDivide_withLargeNumbers() {
        int result = service.divideNumbers(1_000_000, 100);
        System.out.println("Division med stora tal: 1 000 000 / 100 = " + result);
        assertEquals(10_000, result);
    }

    @Test
    public void testDivideByZero_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                service.divideNumbers(10, 0)
        );
        System.out.println("Division med 0 kastade undantag: " + exception.getMessage());
        assertEquals("Kan ej dividera med 0", exception.getMessage());
    }
}
