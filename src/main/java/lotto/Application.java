package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        println("구입금액을 입력해 주세요.");
        Money money = InputHandler.readMoney();
        println();

        List<Lotto> purchasedLottos = LottoShop.purchase(money);
        printPurchasedLottos(purchasedLottos);
        println();

        println("당첨 번호를 입력해 주세요.");
        Lotto winningNumber = InputHandler.readWinningNumber();
        println();

        println("보너스 번호를 입력해 주세요.");
        Bonus bonus = InputHandler.readBonusNumber();
        println();

        println("당첨 통계");
        println("---");
        Map<Rank, Integer> winningHistory = getWinningHistory(winningNumber, bonus, purchasedLottos);
        printWinningHistory(winningHistory);

        double rateOfReturn = LottoCalculator.getRateOfReturn(winningHistory, money);
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

    private static void println() {
        System.out.println();
    }

    private static void println(Object x) {
        System.out.println(x);
    }
}
