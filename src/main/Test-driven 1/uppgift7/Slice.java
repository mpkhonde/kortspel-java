package uppgift7;

public class Slice {
    private String color;
    private int prizeAmount;

    public Slice(String color, int prizeAmount) {
        this.color = color;
        this.prizeAmount = prizeAmount;
    }

    public String getColor() {
        return color;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    @Override
    public String toString() {
        return "Slice [color=" + color + ", prizeAmount=" + prizeAmount + "]";
    }
}
