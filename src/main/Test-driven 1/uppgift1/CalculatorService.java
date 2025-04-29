package uppgift1;

public class CalculatorService {
    private Calculator calculator = new Calculator();

    public int addNumbers(int a, int b) {
        return calculator.add(a, b);
    }

    public int subtractNumbers(int a, int b) {
        return calculator.subtract(a, b);
    }

    public int multiplyNumbers(int a, int b) {
        return calculator.multiply(a, b);
    }

    public int divideNumbers(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Kan ej dividera med 0");
        }
        return calculator.divide(a, b);
    }
}
