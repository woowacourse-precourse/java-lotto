package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningStat {
    private final Map<Prize, Integer> winningStat;

    public WinningStat() {
        winningStat = new HashMap<>();
        Arrays.stream(Prize.values())
                .forEach(x -> winningStat.put(x, 0));
    }

    public void add(int number, boolean bonus) {
        Prize prize = Prize.findPrize(number, bonus);
        winningStat.replace(prize, winningStat.get(prize) + 1);
    }
}
