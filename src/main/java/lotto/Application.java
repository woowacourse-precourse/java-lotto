package lotto;

import static lotto.Messages.*;
import static lotto.OutputHandler.*;

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
            Bonus bonus = inputBonusNumber(winningNumber);
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

    private static Bonus inputBonusNumber(Lotto winningNumber) {
        println();
        println(INPUT_BONUS_NUMBER);
        return InputHandler.readBonusNumber(winningNumber);
    }

    private static Map<Rank, Integer> getWinningHistory(List<Lotto> purchasedLottos, Lotto winningNumber, Bonus bonus) {
        println();
        println(WINNING_STATISTICS);
        println(HORIZONTAL_RULE);
        Map<Rank, Integer> winningHistory = getWinningHistory(winningNumber, bonus, purchasedLottos);
        printWinningHistory(winningHistory);
        return winningHistory;
    }

    private static Map<Rank, Integer> getWinningHistory(Lotto winningNumber, Bonus bonus, List<Lotto> purchasedLottos) {
        Map<Rank, Integer> winningHistory = new LinkedHashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> winningHistory.put(rank, 0));
        purchasedLottos.forEach(ticket -> LottoCalculator.calculateRank(winningNumber, bonus, ticket)
                .ifPresent(rank -> winningHistory.put(rank, winningHistory.get(rank) + 1)));
        return winningHistory;
    }

    private static void CalculateRateOfReturn(Money money, Map<Rank, Integer> winningHistory) {
        double rateOfReturn = LottoCalculator.getRateOfReturn(winningHistory, money);
        printRateOfReturn(rateOfReturn);
    }
}
