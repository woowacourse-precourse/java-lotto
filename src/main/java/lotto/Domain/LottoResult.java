package lotto.Domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    Map<Rank, Integer> result = new LinkedHashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void calculateLottoRanks(LotteryTickets lotteryTickets, WinningNumber winningNumber) {

        for (Lotto lotto : lotteryTickets.getLottoTickets()) {
            boolean hasBonus = false;
            int num = (int) lotto.getNumbers().stream().filter(x -> winningNumber.getWinningNumbers().contains(x)).count();
            if (num == 5 && checkItHasBonus(lotto, winningNumber.getBonusNum())) {
                hasBonus = true;
            }
            Rank rank = Rank.findByMatchCount(num, hasBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

    }

    private boolean checkItHasBonus(Lotto lotto, int bonusNum) {
        return lotto.getNumbers().contains(bonusNum);
    }

    public float calcEarnedRatio(int purchaseAmount) {
        return getTotalEarnedMoney() / purchaseAmount;
    }

    public float getTotalEarnedMoney() {
        return (float) result.entrySet()
                .stream()
                .filter((Map.Entry<Rank, Integer> e) -> e.getValue() > 0).mapToLong(entry -> (long) entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getResult() {
        return result.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Rank, Integer> e) -> e.getKey().getPrice()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public void setResult(Map<Rank, Integer> result) {
        this.result = result;
    }
}
