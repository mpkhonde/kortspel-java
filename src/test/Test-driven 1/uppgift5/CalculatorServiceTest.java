package uppgift5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    @Test
    public void testSquare_shouldReturnCorrectResult() {
        int result = service.square(6);
        System.out.println("Kvadrat: 6^2 = " + result);
        assertEquals(36, result);
    }

    @Test
    public void testIsEven_withEvenNumber() {
        boolean result = service.isEven(10);
        System.out.println("Är 10 jämnt? " + result);
        assertTrue(result);
    }

    @Test
    public void testIsEven_withOddNumber() {
        boolean result = service.isEven(7);
        System.out.println("Är 7 jämnt? " + result);
        assertFalse(result);
    }

    @Test
    public void testFactorial_shouldReturnCorrectValue() {
        int result = service.factorial(5);
        System.out.println("5! = " + result);
        assertEquals(120, result);
    }

    @Test
    public void testFactorial_withNegative_shouldThrow() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.factorial(-3));
        System.out.println("Fakultet med negativt tal kastade undantag: " + ex.getMessage());
        assertEquals("Fakultet definieras inte för negativa tal", ex.getMessage());
    }
}
