package lotto;

import static lotto.Messages.BOUGHT;
import static lotto.Messages.HYPHEN;
import static lotto.Messages.PCS;
import static lotto.Messages.PERCENT;
import static lotto.Messages.ROUND_HUNDREDTHS;
import static lotto.Messages.SPACE;
import static lotto.Messages.TOTAL_RATE_OF_RETURN;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputHandler {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        println(purchasedLottos.size() + BOUGHT);
        purchasedLottos.forEach(lotto -> {
            ArrayList<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Integer::compareTo);
            println(numbers);
        });
    }

    public static void printWinningHistory(Map<Rank, Integer> winningHistory) {
        winningHistory.forEach((rank, count) -> System.out.println(rank + SPACE + HYPHEN + SPACE + count + PCS));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        String roundHundredths = String.format(ROUND_HUNDREDTHS, rateOfReturn);
        String output = TOTAL_RATE_OF_RETURN + SPACE + roundHundredths + PERCENT;
        println(output);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(Object x) {
        System.out.println(x);
    }
}
