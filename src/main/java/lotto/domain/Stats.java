package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Stats {
    THREE(3, 0),
    FOUR(4, 0),
    FIVE(5, 0),
    BONUS(7, 0),
    SIX(6, 0),
    CONTINUE(0, 0);

    private int name;
    private int count;

    Stats() {

    }

    Stats(int name, int count) {
        this.name = name;
        this.count = count;
    }

    public static void compare(List<Lotto> lottos, List<Integer> winLottoNumbers, int bonusNumber) {
        lottos.forEach(lotto -> {
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
            lotto.getNumbers().retainAll(winLottoNumbers);
            Stats stats = valueOfName(lotto.getNumbers());
            addCount(stats, hasBonusNumber);
        });
    }

    private static Stats valueOfName(List<Integer> numbers) {
        return Arrays.stream(values())
                .filter(stats -> stats.name == numbers.size())
                .findAny()
                .orElse(CONTINUE);
    }

    private static void addCount(Stats stats, boolean hasBonusNumber) {
        stats = validateBonus(stats, hasBonusNumber);
        stats.count++;
    }

    private static Stats validateBonus(Stats stats, boolean hasBonusNumber) {
        if(stats.equals(FIVE) && hasBonusNumber) {
            return BONUS;
        }
        return stats;
    }

    public void profit() {

    }
}
