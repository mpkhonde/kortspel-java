package uppgift7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameWheel {
    private ArrayList<Slice> slices;

    public GameWheel() {
        slices = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            String color;
            if (i % 5 == 0) {
                color = "black";
            } else if (i % 2 == 0) {
                color = "blue";
            } else {
                color = "red";
            }
            int prize = (rand.nextInt(20) + 1) * 100;
            slices.add(new Slice(color, prize));
        }
    }

    public Slice spinWheel() {
        Random rand = new Random();
        return slices.get(rand.nextInt(slices.size()));
    }

    public void scramble() {
        ArrayList<Slice> reds = new ArrayList<>();
        ArrayList<Slice> blues = new ArrayList<>();
        ArrayList<Slice> blacks = new ArrayList<>();

        for (Slice s : slices) {
            switch (s.getColor()) {
                case "red" -> reds.add(s);
                case "blue" -> blues.add(s);
                case "black" -> blacks.add(s);
            }
        }

        Collections.shuffle(reds);
        Collections.shuffle(blues);
        Collections.shuffle(blacks);

        for (int i = 0; i < slices.size(); i++) {
            if (i % 5 == 0) {
                slices.set(i, blacks.remove(0));
            } else if (i % 2 == 0) {
                slices.set(i, blues.remove(0));
            } else {
                slices.set(i, reds.remove(0));
            }
        }
    }

    public void sort() {
        ArrayList<Slice> reds = new ArrayList<>();
        ArrayList<Slice> blues = new ArrayList<>();
        ArrayList<Slice> blacks = new ArrayList<>();

        for (Slice s : slices) {
            switch (s.getColor()) {
                case "red" -> reds.add(s);
                case "blue" -> blues.add(s);
                case "black" -> blacks.add(s);
            }
        }

        reds.sort((a, b) -> Integer.compare(a.getPrizeAmount(), b.getPrizeAmount()));
        blues.sort((a, b) -> Integer.compare(a.getPrizeAmount(), b.getPrizeAmount()));
        blacks.sort((a, b) -> Integer.compare(a.getPrizeAmount(), b.getPrizeAmount()));

        for (int i = 0; i < slices.size(); i++) {
            if (i % 5 == 0) {
                slices.set(i, blacks.remove(0));
            } else if (i % 2 == 0) {
                slices.set(i, blues.remove(0));
            } else {
                slices.set(i, reds.remove(0));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < slices.size(); i++) {
            sb.append(i).append(" - ").append(slices.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public void print() {
    }
}
