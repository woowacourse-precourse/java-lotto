package lotto;

import lotto.domain.Dealer;
import lotto.domain.User;
import lotto.util.Message;
import lotto.util.Rank;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static lotto.util.Message.*;

public class LottoGame {
    private User user = new User();
    private Dealer dealer = new Dealer();
    private Map<Rank, Integer> matchResult = new TreeMap<>(Comparator.reverseOrder());

    public void start() {
        initMatchResult();
        user.start();
        dealer.start();
        matchLottoUserAndDealer();
        removeEmptyMatchResult();
        printMatchResult();
    }

    private void initMatchResult() {
        matchResult.put(Rank.FIRST, 0);
        matchResult.put(Rank.SECOND, 0);
        matchResult.put(Rank.THIRD, 0);
        matchResult.put(Rank.FOURTH, 0);
        matchResult.put(Rank.FIFTH, 0);
    }

    private void matchLottoUserAndDealer() {
        user.getLottos()
                .forEach(lotto -> {
                    long count = lotto.containsResultCount(dealer.getNumbers());
                    addMatchResult(count, lotto.containsBonusNumber(dealer.getBonusNumber()));
                });
    }

    private void addMatchResult(long count, boolean matchBonus) {
        Rank rank = Rank.fromCount(count, matchBonus);
        matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
    }

    private void removeEmptyMatchResult() {
        matchResult.remove(Rank.EMPTY);
    }

    private void printMatchResult() {
        System.out.print(STATS_WIN_LOTTO.getMessage());
        for (Map.Entry<Rank, Integer> entry : matchResult.entrySet()) {
            printStatsResult(entry.getKey(), entry.getValue());
        }

        printYield();
    }

    private void printYield() {
        System.out.printf(YIELD_RESULT.getMessage(), calculateYield());
    }

    private double calculateYield() {
        long matchPrice = 0;

        for (Map.Entry<Rank, Integer> entry : matchResult.entrySet()) {
            matchPrice += entry.getKey().getPrice() * entry.getValue();
        }

        return (double) 100 * (matchPrice - user.getMoney()) / user.getMoney();
    }

    private void printStatsResult(Rank rank, int count) {
        if (rank.equals(Rank.SECOND)) {
            System.out.printf(STATS_RESULT_BONUS.getMessage(), rank.getMatchCount(), priceFommater(rank.getPrice()), count);
            return;
        }

        System.out.printf(STATS_RESULT.getMessage(), rank.getMatchCount(), priceFommater(rank.getPrice()), count);
    }

    private String priceFommater(long price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }
}
