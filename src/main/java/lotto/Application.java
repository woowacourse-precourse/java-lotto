package lotto;

import static lotto.Messages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            Money money = inputPurchasePrice();
            List<Lotto> purchasedLottos = purchaseLotto(money);
            Lotto winningNumber = inputWinningNumber();
            Bonus bonus = inputBonusNumber();
            Map<Rank, Integer> winningHistory = getWinningHistory(purchasedLottos, winningNumber, bonus);
            CalculateRateOfReturn(money, winningHistory);
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
        }
    }

    private static Money inputPurchasePrice() {
        println(INPUT_PURCHASE_PRICE);
        return InputHandler.readMoney();
    }

    private static List<Lotto> purchaseLotto(Money money) {
        List<Lotto> purchasedLottos = LottoShop.purchase(money);
        println();
        printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private static Lotto inputWinningNumber() {
        println();
        println(INPUT_WINNING_NUMBER);
        return InputHandler.readWinningNumber();
    }

    private static Bonus inputBonusNumber() {
        println();
        println(INPUT_BONUS_NUMBER);
        return InputHandler.readBonusNumber();
    }

    private static Map<Rank, Integer> getWinningHistory(List<Lotto> purchasedLottos, Lotto winningNumber, Bonus bonus) {
        println();
        println(WINNING_STATISTICS);
        println(HORIZONTAL_RULE);
        Map<Rank, Integer> winningHistory = getWinningHistory(winningNumber, bonus, purchasedLottos);
        printWinningHistory(winningHistory);
        return winningHistory;
    }

    private static void CalculateRateOfReturn(Money money, Map<Rank, Integer> winningHistory) {
        double rateOfReturn = LottoCalculator.getRateOfReturn(winningHistory, money);
        printRateOfReturn(rateOfReturn);
    }

    private static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        println(purchasedLottos.size() + BOUGHT);
        purchasedLottos.forEach(lotto -> {
            ArrayList<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Integer::compareTo);
            println(numbers);
        });
    }

    private static Map<Rank, Integer> getWinningHistory(Lotto winningNumber, Bonus bonus, List<Lotto> purchasedLottos) {
        Map<Rank, Integer> winningHistory = new LinkedHashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> winningHistory.put(rank, 0));
        purchasedLottos.forEach(ticket -> LottoCalculator.calculateRank(winningNumber, bonus, ticket)
                .ifPresent(rank -> winningHistory.put(rank, winningHistory.get(rank) + 1)));
        return winningHistory;
    }

    private static void printWinningHistory(Map<Rank, Integer> winningHistory) {
        winningHistory.forEach((rank, count) -> System.out.println(rank + SPACE + HYPHEN + SPACE + count + PCS));
    }

    private static void printRateOfReturn(double rateOfReturn) {
        String roundHundredths = String.format(ROUND_HUNDREDTHS, rateOfReturn);
        String output = TOTAL_RATE_OF_RETURN + SPACE + roundHundredths + PERCENT;
        println(output);
    }

    private static void println() {
        System.out.println();
    }

    private static void println(Object x) {
        System.out.println(x);
    }
}
