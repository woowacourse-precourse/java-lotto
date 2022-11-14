package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningStat {
    private final Map<Prize, Integer> winningStat;

    public WinningStat() {
        winningStat = new HashMap<>();
        Arrays.stream(Prize.values())
                .filter(x -> x != Prize.NONE)
                .forEach(x -> winningStat.put(x, 0));
    }

    public void add(int number, boolean bonus) {
        Prize prize = Prize.findPrize(number, bonus);
        if (prize !=Prize.NONE) {
            winningStat.replace(prize, winningStat.get(prize) + 1);
        }
    }

    public int getNumber(Prize prize) {
        return winningStat.get(prize);
    }

    private int totalPrize() {
        return winningStat.keySet().stream()
                .map(n -> n.getPrize() * winningStat.get(n))
                .reduce(Integer::sum)
                .orElse(0);
    }

    public String yield(int amount) {
        System.out.println(totalPrize());
        return String.format("%.1f", (double) totalPrize() / amount * 100);
    }
}