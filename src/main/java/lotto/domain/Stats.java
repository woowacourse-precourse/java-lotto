package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static lotto.constance.InputExceptionConstance.*;
import static lotto.view.OutputView.*;

public enum Stats {
    THREE(3, 5000, 0),
    FOUR(4, 50000, 0),
    FIVE(5, 1500000, 0),
    BONUS(5, 30000000, 0),
    SIX(6, 2000000000, 0),
    CONTINUE();

    private int name;
    private int amount;
    private int count;

    Stats() {

    }

    Stats(int name, int amount, int count) {
        this.name = name;
        this.amount = amount;
        this.count = count;
    }

    public static void compare(List<Lotto> lottos, List<Integer> winLottoNumbers, int bonusNumber) {
        lottos.forEach(lotto -> {
            boolean hasBonusNumber = lotto.getNumbers().contains(bonusNumber);
            lotto.getNumbers().retainAll(winLottoNumbers);
            Stats stats = valueOfName(lotto.getNumbers());
            addCount(stats, hasBonusNumber);
        });

        printStats();
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

    public static String getCount(Stats stats) {
        return HYPHEN + stats.count + NUMBER_UNIT;
    }

    public static String getAmount(Stats stats) {
        String amount = String.valueOf(stats.amount);
        return amount.replaceAll(AMOUNT_MARK_REGEX, COMMA);
    }

    public static String getName(Stats stats) {
        if(stats.equals(BONUS)) {
            return stats.name + ACCORD_NUMBER_FORMAT + ACCORD_NUMBER_AND_BONUS_FORMAT;
        }
        return stats.name + ACCORD_NUMBER_FORMAT;
    }

    public static void calculateProfit() {
    }
}
