package lotto;

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
        println("구입금액을 입력해 주세요.");
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
        println("당첨 번호를 입력해 주세요.");
        return InputHandler.readWinningNumber();
    }

    private static Bonus inputBonusNumber() {
        println();
        println("보너스 번호를 입력해 주세요.");
        return InputHandler.readBonusNumber();
    }

    private static Map<Rank, Integer> getWinningHistory(List<Lotto> purchasedLottos, Lotto winningNumber, Bonus bonus) {
        println();
        println("당첨 통계");
        println("---");
        Map<Rank, Integer> winningHistory = getWinningHistory(winningNumber, bonus, purchasedLottos);
        printWinningHistory(winningHistory);
        return winningHistory;
    }

    private static void CalculateRateOfReturn(Money money, Map<Rank, Integer> winningHistory) {
        double rateOfReturn = LottoCalculator.getRateOfReturn(winningHistory, money);
        printRateOfReturn(rateOfReturn);
    }

    private static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        println(purchasedLottos.size() + "개를 구매했습니다.");
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
        winningHistory.forEach((rank, count) -> System.out.println(rank + " - " + count + "개"));
    }

    private static void printRateOfReturn(double rateOfReturn) {
        String roundHundredths = String.format("%.1f", rateOfReturn);
        String output = "총 수익률은 " + roundHundredths + "%입니다.";
        println(output);
    }

    private static void println() {
        System.out.println();
    }

    private static void println(Object x) {
        System.out.println(x);
    }
}
