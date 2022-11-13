package lotto;

import java.util.HashMap;
import java.util.List;

public class WinCalculator {
    private final HashMap<String, Integer> calculatedPrize;

    public WinCalculator() {
        calculatedPrize = new HashMap<>();
        calculatedPrize.put("first", 0);
        calculatedPrize.put("second", 0);
        calculatedPrize.put("third", 0);
        calculatedPrize.put("fourth", 0);
        calculatedPrize.put("fifth", 0);
        calculatedPrize.put("totalPrize", 0);
    }

    public HashMap<String, Integer> getEachPrize(List<Lotto> tickets, Lotto winningNumbers, int bonusNumber) {
        for (Lotto eachTicket: tickets) {
            compare(eachTicket, winningNumbers, bonusNumber);
        }

        return this.calculatedPrize;
    }

    public void compare(Lotto eachTicket, Lotto winningNumbers, int bonusNumber) {
        List<Integer> soldNumbers = eachTicket.getNumbers();
        List<Integer> winNumbers = winningNumbers.getNumbers();
        int hit = 0;
        int bonusHit = 0;

        for (int eachSold : soldNumbers) {
            if (winNumbers.contains(eachSold)) {
                hit += 1;
            }
        }

        if (soldNumbers.contains(bonusNumber)) {
            bonusHit += 1;
        }

        setCalculatedPrize(hit, bonusHit);
    }

    public void setCalculatedPrize(int hit, int bonusHit) {

        if (hit == 3) {
            calculatedPrize.put("fifth", calculatedPrize.get("fifth") + 1);
            calculatedPrize.put("totalPrize", calculatedPrize.get("totalPrize") + 5000);
        }

        if (hit == 4) {
            calculatedPrize.put("fourth", calculatedPrize.get("fourth") + 1);
            calculatedPrize.put("totalPrize", calculatedPrize.get("totalPrize") + 50_000);
        }

        if (hit == 5 && bonusHit == 0) {
            calculatedPrize.put("third", calculatedPrize.get("third") + 1);
            calculatedPrize.put("totalPrize", calculatedPrize.get("totalPrize") + 1_500_000);
        }

        if (hit == 5 && bonusHit == 1) {
            calculatedPrize.put("second", calculatedPrize.get("second") + 1);
            calculatedPrize.put("totalPrize", calculatedPrize.get("totalPrize") + 30_000_000);
        }

        if (hit == 6) {
            calculatedPrize.put("first", calculatedPrize.get("first") + 1);
            calculatedPrize.put("totalPrize", calculatedPrize.get("totalPrize") + 2_000_000_000);
        }
    }
}
