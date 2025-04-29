package uppgift4;

public class CalculatorService {

    public int addNumbers(int a, int b) {
        return a + b;
    }

    public int subtractNumbers(int a, int b) {
        return a - b;
    }

    public int multiplyNumbers(int a, int b) {
        return a * b;
    }

    public int divideNumbers(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Kan ej dividera med 0");
        }
        return a / b;
    }
}
