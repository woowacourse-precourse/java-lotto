package lotto;

import java.util.stream.Stream;

import static lotto.Rank.values;

public class Calculate {
    public static long getLotteryWinningPrize() {
        return Stream.of(values()).mapToLong(i -> i.getPrize() * i.getCount()).sum();
    }
}
