package uppgift6;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Kan ej dividera med 0");
        }
        return a / b;
    }

    public int square(int a) {
        return a * a;
    }

    public int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Fakultet definieras inte för negativa tal");
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public int parseAndAdd(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public boolean isClose(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }
}
