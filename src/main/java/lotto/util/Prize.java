package lotto.util;

import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.PurchaseAmount;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.util.message.OutputMessage.*;

public enum Prize {
    FIFTH_PRIZE(3, 5000, false),
    FORTH_PRIZE(4, 50000, false),
    THIRD_PRIZE(5, 1500000, false),
    SECOND_PRIZE(5, 30000000, true),
    FIRST_PRIZE(6, 2000000000, false),
    NO_PRIZE(0, 0, false);

    private final int sameNumbers;
    private final int money;
    private final boolean isBonus;

    Prize(int sameNumbers, int money, boolean isBonus) {
        this.sameNumbers = sameNumbers;
        this.money = money;
        this.isBonus = isBonus;
    }

    public static Prize getPrize(int index, List<List<Integer>> myLotto) {
        int count = Calculator.countSameNumbers(index);
        if (count == SECOND_PRIZE.sameNumbers && BonusNumber.isIn(myLotto.get(index))) {
            return SECOND_PRIZE;
        }
        Prize[] allPrize = Prize.values();
        for (Prize prize : allPrize) {
            if (count == prize.sameNumbers) {
                return prize;
            }
        }
        return Prize.NO_PRIZE;
    }

    public static float calculateRate(EnumMap<Prize, Integer> result) {
        int sum = 0;
        Prize[] allPrize = Prize.values();
        for (Prize prize : allPrize) {
            sum = sum + result.get(prize) * prize.money;
        }
        return PurchaseAmount.calculateRate(sum);
    }

    public static StringBuilder setResult(EnumMap<Prize, Integer> result) {
        StringBuilder resultMessage = new StringBuilder();
        for (Map.Entry<Prize, Integer> e : result.entrySet()) {
            if (e.getKey().sameNumbers == 0) {
                continue;
            }
            String moneyFormat = new DecimalFormat("###,###").format(e.getKey().money);
            resultMessage.append(String.format(OUTPUT_RESULT_PART1.get(), e.getKey().sameNumbers));
            if (e.getKey().isBonus) {
                resultMessage.append(String.format(OUTPUT_RESULT_BONUS.get()));
            }
            resultMessage.append((String.format(OUTPUT_RESULT_PART2.get(), moneyFormat, e.getValue())));
        }
        return resultMessage;
    }
}
