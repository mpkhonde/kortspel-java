package uppgift6;

public class CalculatorService {

    public int parseAndAdd(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public int parseAndMultiply(String a, String b) {
        return Integer.parseInt(a) * Integer.parseInt(b);
    }

    public int parseAndDivide(String a, String b) {
        int denominator = Integer.parseInt(b);
        if (denominator == 0) {
            throw new IllegalArgumentException("Kan ej dividera med 0");
        }
        return Integer.parseInt(a) / denominator;
    }

    public boolean areClose(double a, double b) {
        return Math.abs(a - b) < 0.000001;
    }

    public double addDoubles(double v, double v1) {
        return v;
    }
}
