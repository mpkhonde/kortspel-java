package uppgift5;

public class CalculatorService {

    public int square(int a) {
        return a * a;
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fakultet definieras inte för negativa tal");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
