package lotto.Model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Draw {
    private final List<Integer> winning;
    private final int bonus;
    private final List<List<Integer>> lottoes;
    private List<Integer> prizeCounts = Arrays.asList(0, 0, 0, 0, 0);

    public Draw(List<Integer> winning, int bonus, List<List<Integer>> lottoes) {
        this.winning = winning;
        this.bonus = bonus;
        this.lottoes = lottoes;
        compare();
    }

    void compare() {
        for (List<Integer> lotto : lottoes) {
            int count = (int) lotto.stream()
                    .filter(old -> winning.stream().anyMatch(Predicate.isEqual(old))).count();
            int bonusCount = 0;
            if (lotto.contains(bonus)) bonusCount = 1;

            int prizeCount = countPrize(count, bonusCount);

            if (prizeCount != 5)
                prizeCounts.set(prizeCount, prizeCounts.get(prizeCount) + 1);
        }
    }

    int countPrize(int count, int bonusCount) {
        if (count == 6) return 4;
        if (count == 5 && bonusCount == 1) return 3;
        if (count == 5) return 2;
        if (count == 4) return 1;
        if (count == 3) return 0;
        return 5;
    }

    public List<Integer> getPrizeCounts() {
        return this.prizeCounts;
    }
}
